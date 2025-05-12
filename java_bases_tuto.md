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
8. [🧩 Interface](#8-🧩-interface)  
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
20. [🏗️ Architecture](#20-🏗️-architecture)





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
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour age
    public int getAge() {
        return age;
    }

    // Setter pour age
    public void setAge(int age) {
        this.age = age;
    }
}
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

Une **interface** en Java est un contrat qui définit un ensemble de méthodes que les classes implémentant cette interface doivent obligatoirement fournir. Contrairement à une classe, une interface ne contient pas d'implémentation concrète (jusqu'à Java 8 où des méthodes par défaut peuvent être ajoutées).

### Exemple d'interface

```java
public interface Animal {
    void parler(); // Méthode abstraite
    void manger();
}
```

### Implémentation d'une interface

Une classe peut implémenter une ou plusieurs interfaces en utilisant le mot-clé `implements`.

```java
public class Chien implements Animal {
    @Override
    public void parler() {
        System.out.println("Wouf !");
    }

    @Override
    public void manger() {
        System.out.println("Le chien mange.");
    }
}
```

### Différences entre une classe et une interface

| Aspect | Classe | Interface |
| --- | --- | --- |
| Héritage | Une seule classe par héritage | Plusieurs interfaces peuvent être implémentées |
| Contenu | Attributs et méthodes concrètes | Méthodes abstraites (et par défaut depuis Java 8) |
| Utilisation | Décrit un comportement complet | Définit un contrat ou des capacités spécifiques |

Les interfaces sont particulièrement utiles pour définir des comportements communs à des classes qui n'ont pas de lien hiérarchique direct. Par exemple, une interface `Volant` peut être implémentée à la fois par une classe `Avion` et une classe `Oiseau`.

### Exemple pratique

```java
public interface Volant {
    void voler();
}

public class Avion implements Volant {
    @Override
    public void voler() {
        System.out.println("L'avion vole dans le ciel.");
    }
}

public class Oiseau implements Volant {
    @Override
    public void voler() {
        System.out.println("L'oiseau bat des ailes.");
    }
}
```

Les interfaces permettent ainsi de structurer le code et de garantir que certaines classes respectent un ensemble de règles ou de comportements.

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

## 16. 🔄 Enums
public enum Niveau {
    DEBUTANT,
    INTERMEDIAIRE,
    AVANCE
}

Niveau monNiveau = Niveau.INTERMEDIAIRE;
System.out.println(monNiveau); // INTERMEDIAIRE

## 17. 🧱 Design Patterns (aperçu)

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

## 18. 📡 Programmation réseau (Sockets)

```Java
import java.net.Socket;
import java.io.PrintWriter;

Socket socket = new Socket("localhost", 8080);
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
out.println("Hello serveur !");
```

## 19. ✅ Tests unitaires avec JUnit

```Java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    public void testDoubler() {
        assertEquals(10, MathUtil.doubler(5));
    }
}
```

## 20. 🏗️ Architecture

```
java_week_1/
│
└── Challenge10/                            ← Dossier principal de ton challenge
    ├── Main.java                           ← Point d'entrée du programme, exécute la logique principale
    │
    ├── models/                             ← Contient les classes représentant les objets métiers
    │   ├── Vehicle.java                    ← Classe de base représentant un véhicule
    │   ├── Car.java                        ← Classe représentant une voiture, hérite de Vehicle
    │   └── Truck.java                      ← Classe représentant un camion, hérite de Vehicle
    │
    ├── services/                           ← Contient des services ou de la logique métier
    │   └── VehicleService.java             ← Service pour gérer la logique des véhicules (ex : gestion de la flotte)
    │
    ├── utils/                              ← Contient des classes utilitaires ou des méthodes de soutien
    │   └── Printer.java                    ← Classe utilitaire pour afficher les informations des véhicules
    │
    ├── exceptions/                         ← Contient les classes d'exceptions spécifiques à ton application
    │   └── VehicleNotFoundException.java   ← Exception levée lorsque l'on ne trouve pas un véhicule
    │
    ├── config/                             ← Contient des configurations spécifiques de ton projet
    │   └── DatabaseConfig.java             ← Configuration de la connexion à la base de données
    │
    ├── tests/                              ← Contient les tests unitaires ou d'intégration de ton application
    │   └── VehicleTest.java                ← Test unitaire pour la classe Vehicle (par exemple vérifier le nombre de roues)
    │
    └── resources/                          ← Contient les fichiers de ressources (fichiers externes, configurations)
        └── application.properties         ← Fichier de configuration (ex : pour les variables de connexion)
```
## 21. 🌀 Stream API en Java

L'API Stream en Java (introduite à partir de Java 8) permet de traiter des collections de manière fonctionnelle, déclarative et souvent plus lisible. Elle est très utile pour filtrer, transformer, regrouper, compter, etc., sans écrire de boucles explicites.

### 📦 Qu’est-ce qu’un Stream ?
Un Stream est une vue d’une séquence de données (souvent des collections), sur laquelle on peut enchaîner des opérations intermédiaires (comme filter, map, sorted, etc.) et terminer par une opération terminale (comme collect, count, forEach, etc.).

Un Stream ne modifie jamais la source, et il est consommé après une opération terminale.

#### 🔁 Cycle de vie d’un Stream
Création : à partir d’une collection ou d’un tableau (.stream())

Opérations intermédiaires : transformations (lazy)

Opération terminale : déclenche l’exécution

Exemple simple :


```Java
List<String> noms = List.of("Alice", "Bob", "Charlie");

List<String> resultat = noms.stream()
    .filter(n -> n.startsWith("C"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());

System.out.println(resultat); // [CHARLIE]
```
### 🛠️ Principales opérations intermédiaires
| Méthode                            | Description                    |
| ---------------------------------- | ------------------------------ |
| `filter(Predicate)`                | Filtre selon une condition     |
| `map(Function)`                    | Transforme chaque élément      |
| `flatMap(Function)`                | Aplati une structure imbriquée |
| `sorted()` ou `sorted(Comparator)` | Trie les éléments              |
| `distinct()`                       | Supprime les doublons          |
| `limit(n)` / `skip(n)`             | Limite ou saute les n premiers |

### ✅ Opérations terminales

| Méthode                                              | Description                                          |
| ---------------------------------------------------- | ---------------------------------------------------- |
| `collect(...)`                                       | Récupère les résultats (ex: en `List`, `Set`, `Map`) |
| `forEach(...)`                                       | Exécute une action pour chaque élément               |
| `count()`                                            | Compte les éléments                                  |
| `reduce(...)`                                        | Combine les éléments                                 |
| `anyMatch(...)` / `allMatch(...)` / `noneMatch(...)` | Tests logiques                                       |
| `findFirst()` / `findAny()`                          | Trouve un élément                                    |

### 🧪 Exemple plus complet
```Java
List<Integer> nombres = List.of(1, 2, 3, 4, 5, 6);

int sommePairs = nombres.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * 2)
    .reduce(0, Integer::sum);

System.out.println(sommePairs); // 24 (2*2 + 4*2 + 6*2)
```

### 📂 Collectors utiles

```
List<String> noms = List.of("Alice", "Bob", "Charlie", "David");

Map<Character, List<String>> parInitiale = noms.stream()
    .collect(Collectors.groupingBy(n -> n.charAt(0)));

System.out.println(parInitiale);
// {A=[Alice], B=[Bob], C=[Charlie], D=[David]}
```

Autres collecteurs :

- Collectors.toList()

- Collectors.toSet()

- Collectors.joining(", ")

- Collectors.partitioningBy(...)

- Collectors.summingInt(...)


### ⚠️ À savoir
- Un Stream ne peut être utilisé qu’une seule fois.

- Les opérations sont paresseuses : elles ne s’exécutent qu’à l’appel d’une opération terminale.

- Évitez les effets de bord dans les opérations (forEach, map...) pour rester fonctionnel.

### 📚 À retenir
- L’API Stream permet de manipuler des collections de manière fluide.

- Elle favorise un code plus expressif et souvent plus performant.

- Couplée à l’API des Optional ou au Pattern Matching, elle devient très puissante.