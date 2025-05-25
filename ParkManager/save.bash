#CREATE MAVEN PROJECT
mvnstart() {
  if [ -z "$1" ]; then
    echo "Utilisation : mvnstart nom-du-projet"
    return 1
  fi

  if [ -d "$1" ]; then
    echo "Erreur : Le répertoire '$1' existe déjà. Veuillez le supprimer ou choisir un autre nom."
    return 1
  fi

  # Crée le projet avec un autre archetype pour éviter les erreurs
  mvn archetype:generate \
    -DgroupId=org.manu \
    -DartifactId="$1" \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DinteractiveMode=false \
    -Dversion=1.0-SNAPSHOT

  # Vérifie si le projet a été créé avec succès
  if [ $? -ne 0 ]; then
    echo "Erreur lors de la création du projet."
    return 1
  fi

  cd "$1" || return

  # Remplacer le fichier pom.xml avec notre version personnalisée incluant JUnit 5
  cat > pom.xml <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.manu</groupId>
    <artifactId>$1</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Dépendance JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.10.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Plugin Maven Surefire pour JUnit 5 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <useModulePath>false</useModulePath>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
EOF

cat <<EOL > src/test/java/org/manu/AppTest.java
package org.manu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void testAppHasAGreeting() {
        assertTrue(true);
    }
}
EOL


  echo "Projet Java 21 '$1' créé et prêt avec JUnit 5."
}