
# 🟨 Les bases essentielles de Java

## 🔹 1. Structure d’un programme Java
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Manu !");
    }
}
```
- `class` = définition d’une **classe**
- `main()` = point d’entrée du programme
- `System.out.println()` = affiche du texte

---

## 🔹 2. Variables et types
```java
int age = 25;
double prix = 9.99;
boolean isCool = true;
String nom = "Manu";
```

---

## 🔹 3. Conditions
```java
if (age >= 18) {
    System.out.println("Majeur");
} else {
    System.out.println("Mineur");
}
```

---

## 🔹 4. Boucles
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

while (age < 30) {
    age++;
}
```

---

## 🔹 5. Fonctions (méthodes)
```java
public static int addition(int a, int b) {
    return a + b;
}
```

---

## 🔹 6. Objets et classes
```java
public class Personne {
    String nom;
    int age;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public void sePresenter() {
        System.out.println("Je suis " + nom + ", j'ai " + age + " ans.");
    }
}
```

Utilisation :
```java
Personne p = new Personne("Manu", 25);
p.sePresenter();
```

---

## 🔹 7. ArrayList et collections
```java
import java.util.ArrayList;

ArrayList<String> noms = new ArrayList<>();
noms.add("Manu");
noms.add("Léa");

for (String nom : noms) {
    System.out.println(nom);
}
```

---

## 🔹 8. Importations
```java
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
```

---

## 🔹 9. Encapsulation (privé/public + getters/setters)
```java
public class Voiture {
    private String marque;

    public Voiture(String marque) {
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
```

---

## 🔹 10. Commentaires
```java
// Commentaire sur une ligne

/*
Commentaire
sur plusieurs lignes
*/
```

---

## 🔹 11. Nom des fichiers
Le nom du fichier `.java` **doit être le même** que le nom de la classe publique principale.

---

## 🔹 12. Compilation / Exécution
```bash
javac Main.java    // compile → crée Main.class
java Main          // exécute
```

---

## 🔹 13. Principes orientés objet (POO)
- **Classe** = plan
- **Objet** = instance
- **Encapsulation**
- **Héritage**
- **Polymorphisme**

---

## 🔹 14. Packages utiles
| Package            | Utilité principale                            |
|--------------------|------------------------------------------------|
| `java.util.*`       | Collections, dates, Scanner                   |
| `java.time.*`       | Dates modernes                                |
| `java.io.*`         | Fichiers (lecture/écriture)                   |
| `javax.swing.*`     | Interfaces graphiques                         |
| `java.nio.file.*`   | Gestion avancée de fichiers                   |

---

## 🔹 15. Conseils bonus
- Pratique avec des **mini projets**
- Utilise **IntelliJ** ou **VS Code**
- Retiens que **tout est objet**
- Java est **verbeux**, mais clair et puissant
