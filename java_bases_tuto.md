# tutoriel-java

# 🚀 TUTO COMPLET – LES FONDAMENTAUX DE JAVA
# 📚 Sommaire

1. [⚙️ Syntaxe de base](#1-⚙️-syntaxe-de-base)  
2. [🧮 Variables et types](#2-🧮-variables-et-types)  
3. [🔁 Conditions et boucles](#3-🔁-conditions-et-boucles)  
4. [📦 Tableaux (arrays)](#4-📦-tableaux-arrays)  
5. [🧱 Classes, objets et constructeurs](#5-🧱-classes-objets-et-constructeurs)  
6. [🔄 Méthodes](#6-🔄-méthodes)  
7. [🧬 Héritage](#7-🧬-héritage)  
8. [🧹 Interface](#8🧹--interface)  
9. [🛠️ Modificateurs d’accès](#9-🛠️-modificateurs-daccès)  
10. [📚 Packages & Imports](#10-📚-packages--imports)  
11. [🧠 Collections](#11-🧠-collections)  
12. [🢨 Exceptions](#12-🢨-exceptions)  
13. [🧼 Bonnes pratiques](#13-🧼-bonnes-pratiques)  
14. [📖 Scanner et Fichiers](#14-📖-scanner-et-fichiers)  
15. [🌟 Programmation avancée en détail](#15-🌟-programmation-avancée-en-détail)  
16. [🔄 Enums](#16-🔄-enums)  
17. [🧱 Design Patterns (aperçu)](#17-🧱-design-patterns-aperçu)  
18. [📡 Programmation réseau (Sockets)](#18-📡-programmation-réseau-sockets)  
19. [✅ Tests unitaires avec JUnit](#19-✅-tests-unitaires-avec-junit)






## 1. ⚙️ Syntaxe de base

```java
public class Main {    
	public static void main(String[] args) {        
		System.out.println("Hello world !");    
	}
}
```

## 2. 🧮 Variables et types

```java
int age = 25;
double prix = 19.99;
boolean estActif = true;
char lettre = 'A';
String nom = "Manu";
```

- **Types primitifs** : `int`, `double`, `boolean`, `char`
- **Types objets** : `String`, `Scanner`, `ArrayList`, etc.

## 3. 🔁 Conditions et boucles

### If / else

```java
if (age >= 18) {    
	System.out.println("Majeur");
} 
else {    
	System.out.println("Mineur");
}
```

### Switch

```java
int choix = 2;

switch (choix) {    
	case 1 -> System.out.println("Un");    
	case 2 -> System.out.println("Deux");    
	default -> System.out.println("Autre");
}
```

### Boucles

```java
for (int i = 0; i < 5; i++) {    
	System.out.println(i);
}

int i = 0;while (i < 5) {    
	System.out.println(i);
  i++;
}
```

## 4. 📦 Tableaux (arrays)

```java
int[] notes = {12, 15, 8};
```

```java
for (int i = 0; i < notes.length; i++) {    
	System.out.println(notes[i]);
}
```

```java
for (int note : notes) {    
	System.out.println(note);
}
```

## 5. 🧱 Classes, objets et constructeurs

```java
public class Personne {
    String nom;
    int age;   
    
    public Personne(String nom, int age) { 
        this.nom = nom;        
        this.age = age;    
     }}
```

```java
Personne p = new Personne("Manu", 25);
```

## 6. 🔄 Méthodes

```java
public class MathUtil {    
	public static int doubler(int x) {        
			return x * 2;    
	}
}
```

```java
int resultat = MathUtil.doubler(5); // 10
```

## 7. 🧬 Héritage

```java
class Animal {    
	void parler() {        
		System.out.println("Je suis un animal");    
	}
}

class Chien extends Animal {    
	void parler() {        
		System.out.println("Wouf !");    
	}
}
```

```java
Animal a = new Chien();
a.parler(); // "Wouf !"
```

## 8. 🧩 Interface

- Interface = contrat
- Classe = comportement

## 9. 🛠️ Modificateurs d’accès

| Modificateur | Accessible depuis… |
| --- | --- |
| public | Partout |
| private | Dans la classe uniquement |
| protected | Dans le même package ou sous-classe |
| (aucun) | Dans le même package uniquement |

Les modificateurs d'accès sont essentiels pour contrôler la visibilité et l'accessibilité des éléments dans votre code

. Voici leur utilité :

- **public** : Accessible depuis n'importe où dans le programme. Utile pour les éléments qui doivent être utilisés par d'autres classes.
- **private** : Accessible uniquement dans la classe où il est déclaré. Permet d'encapsuler les données et de protéger l'accès direct aux attributs.
- **protected** : Accessible dans le même package et par les classes qui héritent. Utile pour partager des fonctionnalités entre classes liées tout en les cachant du reste du programme.
- **default** (sans modificateur) : Accessible uniquement dans le même package. Permet de regrouper des fonctionnalités liées dans un même package.

Une bonne pratique est de toujours définir explicitement ces modificateurs d'accès, car cela permet de mieux contrôler et sécuriser votre code

.

## 10. 📚 Packages & Imports

```java
import java.util.Scanner;
```

### Créer un package perso

```java
package com.manu.utils;

public class Util {    
	public static void salut() {        
		System.out.println("Salut !");    
	}
}
```

## 11. 🧰 Collections

### ArrayList

```java
import java.util.ArrayList;

ArrayList<String> noms = new ArrayList<>();

noms.add("Manu");
noms.add("Paul");

for (String nom : noms) {    
	System.out.println(nom);
}
```

### HashMap

```java
import java.util.HashMap;

HashMap<String, Integer> scores = new HashMap<>();

scores.put("Manu", 15);
scores.put("Paul", 18);

System.out.println(scores.get("Manu")); // 15
```

## 12. 🧨 Exceptions

```java
try {    
	int res = 10 / 0;
} 
catch (ArithmeticException e) {    
	System.out.println("Erreur : division par zéro !");
}
```

## 13. 🧼 Bonnes pratiques

- Utiliser des noms clairs
- Découper en petites méthodes
- Éviter la duplication
- Commenter si nécessaire
- Toujours définir les modificateurs d’accès

## 🧪 En résumé

| Élément | Ce que ça fait |
| --- | --- |
| class | Plan pour créer un objet |
| interface | Contrat de méthodes |
| object | Instance d’une classe |
| array | Tableau de taille fixe |
| ArrayList | Liste dynamique |
| extends | Hérite d’une classe |
| implements | Implémente une interface |
| import | Utilise une classe externe |
| package | Organise ton code |
| try/catch | Gère les erreurs |

## 14. 📖 Scanner et Fichiers

### Scanner - Lecture depuis console

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

System.out.print("Entrez votre nom : ");
String nom = scanner.nextLine();

System.out.print("Entrez votre âge : ");
int age = scanner.nextInt();

scanner.close();
```

### Lecture de fichier

```java
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

try {
    File fichier = new File("texte.txt");
    BufferedReader lecteur = new BufferedReader(new FileReader(fichier));
    
    String ligne;
    while ((ligne = lecteur.readLine()) != null) {
        System.out.println(ligne);
    }
    
    lecteur.close();
} catch (Exception e) {
    System.out.println("Erreur : " + e.getMessage());
}
```

### Écriture dans un fichier

```java
import java.io.FileWriter;
import java.io.BufferedWriter;

try {
    FileWriter fw = new FileWriter("sortie.txt");
    BufferedWriter writer = new BufferedWriter(fw);
    
    writer.write("Première ligne\n");
    writer.write("Deuxième ligne");
    
    writer.close();
} catch (Exception e) {
    System.out.println("Erreur : " + e.getMessage());
}
```

- **Scanner** : Utile pour lire les entrées utilisateur depuis la console
- **BufferedReader** : Efficace pour lire des fichiers ligne par ligne
- **BufferedWriter** : Permet d'écrire dans un fichier avec un buffer
- **Important** : Toujours fermer les flux (close()) après utilisation

## 15. 🌟 Programmation avancée en détail

### Les Génériques en profondeur

Les génériques sont un concept fondamental en Java qui permet d'écrire du code qui fonctionne avec différents types de données. Imaginons une boîte qui peut contenir n'importe quel type d'objet :

```java
// Création d'une boîte qui peut contenir n'importe quel type
public class Boite<T> {
    private T contenu;
    
    public void mettre(T item) {
        this.contenu = item;
    }
    
    public T recuperer() {
        return contenu;
    }
}

// Utilisation avec différents types
Boite<String> boiteTexte = new Boite<>();
boiteTexte.mettre("Hello");

Boite<Integer> boiteNombre = new Boite<>();
boiteNombre.mettre(42);
```

Cette approche offre plusieurs avantages :

- ✓ Sécurité du type à la compilation
- ✓ Réutilisation du code
- ✓ Évite les conversions explicites (casting)

### Expressions Lambda expliquées

Les expressions lambda sont une façon moderne d'écrire des fonctions anonymes. Elles sont particulièrement utiles pour :

```java
// Avant Java 8
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clic !");
    }
});

// Avec Lambda
button.addActionListener(e -> System.out.println("Clic !"));

// Exemples plus complexes
List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");

// Tri simple
noms.sort((a, b) -> a.compareTo(b));

// Filtrage avec predicat
noms.removeIf(nom -> nom.length() > 5);
```

### Stream API en détail

L'API Stream offre une approche déclarative pour manipuler les collections. Voici un exemple complet :

```java
List<Personne> personnes = Arrays.asList(
    new Personne("Alice", 25),
    new Personne("Bob", 30),
    new Personne("Charlie", 35)
);

// Exemple complet de manipulation
double ageMoyen = personnes.stream()
    .filter(p -> p.getAge() > 20)           // Filtre les personnes > 20 ans
    .map(Personne::getAge)                  // Extrait l'âge
    .mapToInt(Integer::intValue)            // Convertit en int
    .average()                              // Calcule la moyenne
    .orElse(0.0);                          // Valeur par défaut si vide

// Collecte dans une nouvelle structure
Map<String, Integer> mapPersonnes = personnes.stream()
    .collect(Collectors.toMap(
        Personne::getNom,    // Clé
        Personne::getAge     // Valeur
    ));
```

### Optional en pratique

Optional est une solution élégante pour gérer les valeurs potentiellement nulles :

```java
// Création et utilisation d'Optional
public class Service {
    public Optional<Utilisateur> trouverUtilisateur(String id) {
        Utilisateur user = database.findById(id);
        return Optional.ofNullable(user);
    }
}

// Utilisation
Service service = new Service();
service.trouverUtilisateur("123")
    .filter(u -> u.getAge() > 18)
    .map(Utilisateur::getNom)
    .ifPresentOrElse(
        nom -> System.out.println("Utilisateur trouvé : " + nom),
        () -> System.out.println("Utilisateur non trouvé")
    );
```

Bonnes pratiques pour l'utilisation d'Optional :

- ✓ Ne jamais retourner null pour un Optional
- ✓ Utiliser orElse() ou orElseGet() pour fournir une valeur par défaut
- ✓ Éviter Optional.get() sans vérification
- ✓ Ne pas utiliser Optional comme paramètre de méthode

### Cas d'utilisation pratiques

Ces concepts avancés sont particulièrement utiles dans les scénarios suivants :

- 🔹 Génériques : Collections personnalisées, services génériques, caches
- 🔹 Lambda : Callbacks, événements, filtrage de données
- 🔹 Streams : Traitement de grandes collections, analyses de données
- 🔹 Optional : APIs robustes, traitement des résultats de recherche

### 16. 🔄 Enums
public enum Niveau {
    DEBUTANT,
    INTERMEDIAIRE,
    AVANCE
}

Niveau monNiveau = Niveau.INTERMEDIAIRE;
System.out.println(monNiveau); // INTERMEDIAIRE

### 17. 🧱 Design Patterns (aperçu)

### Design Patterns (aperçu)

#### Singleton : pour une instance unique

Le pattern Singleton garantit qu'une classe n'a qu'une seule instance et fournit un point d'accès global à cette instance.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

#### Factory : pour créer des objets sans exposer la logique de création

Le pattern Factory permet de créer des objets sans avoir à spécifier leur classe concrète.

```java
public interface Animal {
    void parler();
}

public class Chien implements Animal {
    public void parler() {
        System.out.println("Wouf !");
    }
}

public class Chat implements Animal {
    public void parler() {
        System.out.println("Miaou !");
    }
}

public class AnimalFactory {
    public static Animal getAnimal(String type) {
        return switch (type) {
            case "chien" -> new Chien();
            case "chat" -> new Chat();
            default -> null;
        };
    }
}

// Utilisation
Animal animal = AnimalFactory.getAnimal("chien");
animal.parler(); // "Wouf !"
```

#### Observer : pour réagir à des événements

Le pattern Observer permet à un objet (le sujet) de notifier automatiquement ses observateurs lorsqu'un changement d'état se produit.

```java
import java.util.ArrayList;
import java.util.List;

public class Sujet {
    private List<Observateur> observateurs = new ArrayList<>();

    public void ajouterObservateur(Observateur o) {
        observateurs.add(o);
    }

    public void notifier() {
        for (Observateur o : observateurs) {
            o.mettreAJour();
        }
    }
}

public interface Observateur {
    void mettreAJour();
}

public class ObservateurConcret implements Observateur {
    public void mettreAJour() {
        System.out.println("Notification reçue !");
    }
}

// Utilisation
Sujet sujet = new Sujet();
Observateur obs = new ObservateurConcret();
sujet.ajouterObservateur(obs);
sujet.notifier(); // "Notification reçue !"
```

Ces patterns sont des solutions éprouvées pour résoudre des problèmes courants en conception logicielle. Ils améliorent la maintenabilité, la réutilisabilité et la clarté du code.

### 18. 📡 Programmation réseau (Sockets)

```
import java.net.Socket;
import java.io.PrintWriter;

Socket socket = new Socket("localhost", 8080);
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
out.println("Hello serveur !");
```

### 19. ✅ Tests unitaires avec JUnit

```
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    public void testDoubler() {
        assertEquals(10, MathUtil.doubler(5));
    }
}
```
