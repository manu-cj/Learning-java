# 📖 **TABLE DES MATIÈRES**

## 🏁 **Introduction générale**

### 1. 🌟 **Introduction générale**
### 2. 🧩 **Types primitifs & objets (Integer, Long, Boolean…)**
### 3. 🛠️ **Les méthodes des différents types de données en Java**
### 4. 📦 **Classes utilitaires indispensables**
### 5. 🌀 **Génériques — comprendre T, U, R comme un pro**
### 6. ✅ **TDD & Tests unitaires (JUnit + Mockito)**
### 7. 🏗️ **Design Patterns essentiels en Java backend**
### 8. 🏛️ **Architecture — comprendre Clean Architecture**
### 9. 📂 **Les Collections en Java**
### 10. 🚀 **Les Streams en Java**
### 11. 🧮 **Lambda et Programmation Fonctionnelle**
### 12. ⏳ **Dates & Temps (LocalDate, Instant, etc.)**

---

# 🔥 **1. INTRODUCTION GÉNÉRALE**

Java est un langage :

- **orienté objet**
- **fortement typé**
- **compilé**
- **robuste**
- **utilisé par les grandes entreprises**  
  *(banques, assurances, médical, institutions… )*

---

### 🎯 **Objectif de ce tutoriel**

Ce tutoriel vise à t'apporter une vision complète et professionnelle, pas juste un apprentissage scolaire.

Tu vas apprendre à :

- ✔️ Écrire du Java propre
- ✔️ Comprendre les types
- ✔️ Manipuler les collections
- ✔️ Écrire des streams lisibles et performants
- ✔️ Maîtriser le null-safe avec `Optional`
- ✔️ Gérer l’argent sans erreurs (`BigDecimal`)
- ✔️ Structurer une application comme un pro (**Clean Architecture**)
- ✔️ Penser comme un développeur backend Java en entreprise

--------------------------------------------------------------
# 2. 🔥 **Types primitifs & objets (Integer, Long, Boolean…)**

Java fait la distinction entre :

### ⚡ **Types primitifs** (performants, simples)

- `int`
- `long`
- `double`
- `float`
- `boolean`
- `char`
- `byte`
- `short`

### 🔥 **Types objets** (wrappers)

- `Integer`
- `Long`
- `Double`
- `Float`
- `Boolean`
- etc.

## 2.1 **Pourquoi cette distinction existe ?**

- 👉 Les **primitifs** sont rapides, utilisés dans les calculs.
- 👉 Les **objets** peuvent être `null`, ont des méthodes, et sont utilisés dans les collections.


## 2.2 Les primitives vs objets — tableau récapitulatif
| Primitif | Objet     | Peut être null ? | Méthodes ? | Utilisable dans List/Map ? |
| -------- | --------- | ---------------- | ---------- | -------------------------- |
| `int`    | `Integer` | ❌                | ❌          | ❌                          |
| —        | ✔️        | ✔️               | ✔️         |                            |

## 2.3 Méthodes importantes des wrappers
📌 **Conversion String → Nombre**
- `int age = Integer.parseInt("24");`
- `Long id = Long.parseLong("9541278");`
- `double price = Double.parseDouble("19.99");`


### 🌟 **Cas métier :**

- **JSON d’Angular** : Les nombres sont reçus sous forme de chaînes, il faut les convertir.
- **Fichier CSV** : Contient des numéros à traiter.

---

### 📌 **Comparaison correcte :**

```java
Integer a = 10;
Integer b = 15;

a.compareTo(b); // Résultat : -1
Objects.equals(a, b); // Comparaison null-safe
```
### 📌 **Valeurs limites**
```java
Integer.MAX_VALUE;
Long.MIN_VALUE;
Double.POSITIVE_INFINITY;
```
## 2.4 Les erreurs fréquentes à éviter

❌ Mauvais : risque de NullPointerException
```java
Integer x = null;
int y = x; // 💥 NullPointerException (unboxing)
```
✔️ Bon
```java
Integer x = null;
int y = (x != null) ? x : 0;
```
--------------------------------------------------------------

# 🔥 3 Les méthodes des diffèrents types de données en Java

## 3.1. **Les String**

**String** est la structure la plus utilisée en backend.

⚠️ **Important**

➡️ *String* est **immuable** → chaque modification crée un **nouvel objet**.

### 3.1.1 **Méthodes essentielles**

- **`length()`**  
  Retourne le nombre de caractères dans la chaîne.

- **`isEmpty()` / `isBlank()`**
  - `isEmpty()` → Vérifie si la chaîne a une longueur de 0.
  - `isBlank()` → Vérifie si la chaîne est vide ou ne contient que des espaces.

- **`charAt(index)`**  
  Retourne le caractère à l'index spécifié.

- **`substring(startIndex)` / `substring(startIndex, endIndex)`**  
  Extrait une sous-chaîne à partir d'indices donnés.

- **`indexOf(char)` / `indexOf(String)`**  
  Retourne l'index de la première occurrence d'un caractère ou d'une sous-chaîne.

- **`lastIndexOf(char)` / `lastIndexOf(String)`**  
  Retourne l'index de la dernière occurrence d'un caractère ou d'une sous-chaîne.

- **`contains(CharSequence)`**  
  Vérifie si la chaîne contient une sous-chaîne donnée.

- **`startsWith(String)` / `endsWith(String)`**  
  Vérifie si la chaîne commence ou se termine par une sous-chaîne donnée.

- **`replace(char, char)` / `replace(CharSequence, CharSequence)`**  
  Remplace toutes les occurrences d'un caractère ou d'une sous-chaîne par une autre.

- **`replaceAll(regex, replacement)` / `replaceFirst(regex, replacement)`**  
  Remplace toutes ou la première occurrence correspondant à une expression régulière.

- **`split(String)` / `split(String, limit)`**  
  Découpe la chaîne en un tableau selon un délimiteur.

- **`toLowerCase()` / `toUpperCase()`**  
  Convertit la chaîne en minuscules ou majuscules.

- **`trim()`**  
  Supprime les espaces au début et à la fin de la chaîne.

- **`strip()` / `stripLeading()` / `stripTrailing()`**  
  Supprime les espaces en utilisant Unicode (plus complet que `trim()`).

- **`equals(Object)` / `equalsIgnoreCase(String)`**  
  Compare deux chaînes pour vérifier leur égalité, avec ou sans sensibilité à la casse.

- **`compareTo(String)` / `compareToIgnoreCase(String)`**  
  Compare deux chaînes lexicographiquement, avec ou sans sensibilité à la casse.

- **`matches(String regex)`**  
  Vérifie si la chaîne correspond à une expression régulière.

- **`join(CharSequence delimiter, CharSequence... elements)`**  
  Concatène plusieurs chaînes avec un délimiteur.

- **`repeat(int count)`**  
  Répète la chaîne un nombre spécifié de fois.

- **`format(String format, Object... args)`**  
  Retourne une chaîne formatée (similaire à `printf`).

- **`valueOf(Object)`**  
  Convertit un objet en chaîne.

- **`intern()`**  
  Retourne une version canonique de la chaîne depuis le pool de chaînes.

- **`getBytes()`**  
  Convertit la chaîne en tableau d'octets.

- **`toCharArray()`**  
  Convertit la chaîne en tableau de caractères.

## 3.1.2 Cas métiers importants

✔️ Nettoyer une entrée utilisateur
```java
String email = input.trim().toLowerCase();
```
✔️ Valider un numéro de téléphone avec regex
```java
boolean valid = phone.matches("\\d{10}");
```
✔️ Extraire le nom de fichier d’un path
```java
String file = path.substring(path.lastIndexOf('/') + 1);
```

✔️ Vérifier si une chaîne est un palindrome
```java
String reversed = new StringBuilder(input).reverse().toString();
boolean isPalindrome = input.equalsIgnoreCase(reversed);
```

✔️ Concaténer des chaînes efficacement
```java
String fullName = String.join(" ", firstName, lastName);
```
✔️ Compter les occurrences d’un caractère
```java
long count = input.chars().filter(ch -> ch == 'a').count();
```

## 🌟 **3.2 Le type Integer / int**

### 3.2.1 **Rôle métier**

Utilisé pour :

- **IDs**
- **Compteurs**
- **Choix utilisateur**
- **Tailles de listes**
- **Valeurs discrètes** (âge, quantités, niveaux)

### 3.2.2 **Méthodes importantes de Integer**
### **Conversion**

- `Integer.parseInt(String)` Cette méthode convertit une chaîne de caractères en un type primitif int.
- `Integer.valueOf(String)` Cette méthode convertit une chaîne de caractères en un objet Integer.

### **Comparaison**

- `Integer.compare(a, b)` Cette méthode compare deux entiers.
- `equals(Object)` Cette méthode compare deux objets Integer pour vérifier leur égalité.

### **Calcul utilitaire**

- `Integer.max(a, b)` Cette méthode retourne la plus grande valeur entre deux entiers.
- `Integer.min(a, b)` Cette méthode retourne la plus petite valeur entre deux entiers.
- `Integer.sum(a, b)` Cette méthode retourne la somme de deux entiers.

### **Représentation**

- `toString()` Cette méthode convertit un entier en une chaîne de caractères.
- `Integer.toHexString(int)` Cette méthode convertit un entier en une chaîne de caractères représentant sa valeur en hexadécimal.
- `Integer.toBinaryString(int)` Cette méthode convertit un entier en une chaîne de caractères représentant sa valeur en binaire.

### 3.2.3 **Cas métiers**

✔️ **Lire un paramètre d’URL** (`?id=42`)

```java
int id = Integer.parseInt(request.getParameter("id"));
// Utiliser l’ID pour récupérer une ressource
```


✔️ **Comparer deux IDs de BDD**

```java
if (Integer.compare(userId, otherId) == 0) {
    // Les IDs sont égaux
}
```


✔️ **Transformer un ID en HEX pour logs**

```java
String logId = Integer.toHexString(userId);
// Convertit l'ID utilisateur en une chaîne hexadécimale
// Exemple : si userId = 42, logId sera "2a"
// Utiliser logId dans les messages de log
```

## 🌟 **3.3 Le type Double / double**

### **3.3.1 Rôle métier**
- **Prix**
- **Montants financiers** (⚠️ *arrondis* → préférer `BigDecimal`)
- **Pourcentages**
- **Calculs physiques**

### **3.3.2 Méthodes essentielles**
- `Double.parseDouble(String)` Cette méthode convertit une chaîne de caractères en un type primitif double.
- `Double.valueOf(String)` Cette méthode convertit une chaîne de caractères en un objet Double.
- `Double.isNaN(double)` Cette méthode vérifie si un nombre de type double est "Not a Number" (NaN).
- `Double.isInfinite(double)` cette méthode vérifie si un nombre de type double est infini.
- `Double.compare(a, b)` Cette méthode compare deux nombres de type double.
- `Double.sum(a, b)` Cette méthode retourne la somme de deux nombres de type double.

### **3.3.3 Cas métiers**

✔️ **Calcul d’une réduction**

```java
double finalPrice = price - (price * discount);/ 100;
// Applique une réduction en pourcentage au prix initial
// price : prix initial
// discount : pourcentage de réduction
// ex: si price = 100.0 et discount = 15.0, finalPrice sera 85.0
```


✔️ **Vérifier une division douteuse**
```java
boolean invalid = Double.isNaN(result);
// Vérifie si le résultat d'une division est "Not a Number" (NaN)
```

## 🌟 **3.4 Le type Float / float**

### **3.4.1 Caractéristiques**
- Moins précis que `Double`
- Plus léger
- Utilisé en **IA**, **graphisme**, et **calcul scientifique**

### **3.4.2 Méthodes essentielles**
- `Float.parseFloat(String)` Cette méthode convertit une chaîne de caractères en un type primitif float.
- `Float.valueOf(String)` Cette méthode convertit une chaîne de caractères en un objet Float.
- `Float.isNaN(float)` Cette méthode vérifie si un nombre de type float est "Not a Number" (NaN).
- `Float.compare(float, float)` Cette méthode compare deux nombres de type float.

### **3.4.3 Cas métiers**
✔️ **Lire des données de capteurs**  
✔️ **Sérialiser des données volumineuses**

## 🌟 **3.5 Le type Long / long**

### **3.5.1 Rôle métier**

- **Timestamps** (`System.currentTimeMillis()`)
- **IDs longs** (sécurité)
- **Compteurs** pour des volumes importants
- **Entiers supérieurs à 2 milliards**

### **3.5.2 Méthodes essentielles**

- `Long.parseLong(String)` Cette méthode convertit une chaîne de caractères en un type primitif long.
- `Long.valueOf(String)` Cette méthode convertit une chaîne de caractères en un objet Long.
- `Long.compare(a, b)` Cette méthode compare deux nombres de type long.
- `Long.max(a, b)` Cette méthode retourne la plus grande valeur entre deux nombres de type long.
- `Long.min(a, b)` Cette méthode retourne la plus petite valeur entre deux nombres de type long.
- `Long.toHexString(long)` Cette méthode convertit un nombre de type long en une chaîne de caractères représentant sa valeur en hexadécimal.

### **3.5.3 Cas métiers**

✔️ **Lire un identifiant UUID tronqué**  
✔️ **Manipuler un timestamp UNIX**  
✔️ **Générer un identifiant technique**

## 🌟 **3.6 Le type Short / short**

### **3.6.1 Rôle métier**

Le type `short` est peu utilisé, mais il est pertinent dans certains cas spécifiques :

- **Optimisations mémoire** : utile lorsque l'espace est limité.
- **Protocoles réseau** : pour des échanges de données compacts.
- **Données serrées** : comme dans les buffers ou les fichiers binaires.

### **3.6.2 Méthodes essentielles**

- `Short.parseShort(String)` : Convertit une chaîne de caractères en un type primitif `short`.
- `Short.valueOf(String)` : Convertit une chaîne de caractères en un objet `Short`.
- `Short.compare(a, b)` : Compare deux valeurs de type `short`.

### **Cas métiers**

✔️ **Analyse de fichiers binaires** : traitement de données compactes.  
✔️ **Protocoles IoT / embarqué** : communication efficace dans des environnements contraints.

## 🌟 **3.7 Le type Byte / byte**

### **3.7.1 Rôle métier**

Le type `byte` est le type le plus bas niveau avec `char`.

**Utilisations courantes** :
- Buffers réseau
- Lecture/écriture de fichiers binaires
- Cryptographie
- Compression

### **3.7.2 Méthodes essentielles**

- **`Byte.parseByte(String)`** : Convertit une chaîne de caractères en un type primitif `byte`.
- **`Byte.valueOf(String)`** : Convertit une chaîne de caractères en un objet `Byte`.
- **`Byte.compare(a, b)`** : Compare deux valeurs de type `byte`.

### **3.7.3 Cas métiers**

✔️ **Lire un fichier**
```java
byte[] data = Files.readAllBytes(path);
// Lit le contenu d'un fichier en un tableau de bytes
// path : chemin du fichier à lire
// data : tableau de bytes contenant le contenu du fichier
// Utiliser data pour traiter le contenu du fichier
```


✔️ **Hash cryptographique**
```java
MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(input.getBytes());
// Calcule le hash SHA-256 d'une entrée donnée
```
✔️ **Répondre à un protocole réseau bas niveau**

```java
byte[] packet = new byte[128];
// Initialise un tableau de bytes pour un paquet réseau de taille fixe
// Utiliser ce tableau pour construire ou analyser des paquets réseau
```

🌟 **3.8 Le type Character / char**

### **3.8.1 Rôle métier**
- **Parsing** : Analyse de texte caractère par caractère.
- **Validation** : Vérification des entrées utilisateur caractère par caractère.
- **Lecture de flux texte** : Traitement des données textuelles.

### **3.8.2 Méthodes essentielles via `Character`**
- `Character.isDigit()` : Vérifie si un caractère est un chiffre.
- `Character.isLetter()` : Vérifie si un caractère est une lettre.
- `Character.isWhitespace()` : Vérifie si un caractère est un espace blanc.
- `Character.toUpperCase()` : Convertit un caractère en majuscule.
- `Character.toLowerCase()` : Convertit un caractère en minuscule.

### **3.8.3 Cas métiers**
✔️ **Vérifier le format d’une entrée utilisateur**
```java
if (!Character.isDigit(c)) {
    throw new InvalidFormatException();
}
// Vérifie si le caractère 'c' est un chiffre
// Si ce n'est pas le cas, lance une exception de format invalide
```

🌟 **3.9 Le type Boolean / boolean**

### **3.9.1 Rôle métier**
- **Flags** : Indicateurs simples pour des états binaires.
- **Validation** : Vérification de conditions ou d'entrées.
- **États métier** : Suivi d'états comme *paid*, *active*, *verified*.

### **3.9.2 Méthodes essentielles**
- **`Boolean.parseBoolean(String)`** : Convertit une chaîne en valeur primitive `boolean`.
- **`Boolean.valueOf(String)`** : Convertit une chaîne en objet `Boolean`.
- **`Boolean.logicalAnd(boolean, boolean)`** : Effectue un ET logique entre deux valeurs.
- **`Boolean.logicalOr(boolean, boolean)`** : Effectue un OU logique entre deux valeurs.
- **`Boolean.logicalXor(boolean, boolean)`** : Effectue un OU exclusif logique entre deux valeurs.

### **3.9.3 Cas métiers**
✔️ **Lire un paramètre boolean d'une API**

```java
boolean active = Boolean.parseBoolean(queryParam);
// Convertit le paramètre de requête en une valeur boolean
// queryParam = "true" ou "false"
```


✔️ État tri-state (true/false/null) avec Boolean

```java
Boolean emailVerified = user.getEmailVerified();
if (emailVerified == null) {
System.out.println("Email non renseigné");
} else if (emailVerified) {
System.out.println("Email vérifié");
} else {
System.out.println("Email non vérifié");
}
```

##🌟 **3.10 Le type BigDecimal**

### **3.10.1 Pourquoi utiliser BigDecimal ?**
Le type `BigDecimal` est le seul type fiable pour :
- **Montants financiers** : éviter les erreurs d'arrondi.
- **Calculs de TVA** : précision garantie.
- **Calculs exacts** : idéal pour les opérations nécessitant une haute précision.

### **3.10.2 Méthodes essentielles**
- **`add(BigDecimal)`** : Additionne deux valeurs.
- **`subtract(BigDecimal)`** : Soustrait une valeur.
- **`multiply(BigDecimal)`** : Multiplie deux valeurs.
- **`divide(BigDecimal, RoundingMode)`** : Divise deux valeurs avec un mode d'arrondi.
- **`compareTo(BigDecimal)`** : Compare deux valeurs.
- **`setScale(int, RoundingMode)`** : Définit le nombre de décimales avec un mode d'arrondi.

### **3.10.3 Cas d'utilisation**
✔️ **Calcul précis d'un prix TTC**
```java
BigDecimal priceTTC = priceHT.multiply(tva).setScale(2, RoundingMode.HALF_UP);
// priceHT : prix hors taxes
// tva : taux de TVA
// Exemple : si priceHT = 100.00 et tva = 0.21, priceTTC = 121.00
```

##🌟 **3.11 Le type BigInteger**

### **3.11.1 Pourquoi utiliser BigInteger ?**
Le type `BigInteger` est utilisé pour manipuler des entiers de très grande taille qui dépassent la capacité des types primitifs comme `long`. Il est particulièrement utile dans :
- **Cryptographie** : gestion de clés et d'algorithmes nécessitant des nombres très grands.
- **Blockchain** : manipulation d'identifiants ou de montants très élevés.
- **Calculs scientifiques** : opérations mathématiques complexes avec des entiers gigantesques.
- **Factorielles ou puissances** : calculs impliquant des valeurs exponentielles.

### **3.11.2 Méthodes essentielles**
- **`add(BigInteger)`** : Additionne deux nombres.
- **`subtract(BigInteger)`** : Soustrait un nombre.
- **`multiply(BigInteger)`** : Multiplie deux nombres.
- **`divide(BigInteger)`** : Divise deux nombres.
- **`mod(BigInteger)`** : Calcule le reste d'une division (modulo).
- **`pow(int)`** : Calcule une puissance.
- **`gcd(BigInteger)`** : Calcule le plus grand commun diviseur (PGCD).

### **3.11.3 Cas d'utilisation**
✔️ **Calcul de clés RSA en cryptographie**
```java
BigInteger p = new BigInteger("15485863");
BigInteger q = new BigInteger("32452843");
BigInteger n = p.multiply(q); // Produit des deux nombres premiers
```

✔️ **Calcul de factorielles**
```java
BigInteger factorial = BigInteger.ONE;
for (int i = 1; i <= 100; i++) {
    factorial = factorial.multiply(BigInteger.valueOf(i));
}
System.out.println("100! = " + factorial);
```

✔️ **Opérations modulaires**
```java
BigInteger base = new BigInteger("5");
BigInteger exponent = new BigInteger("3");
BigInteger modulus = new BigInteger("13");
BigInteger result = base.modPow(exponent, modulus); // (5^3) % 13
System.out.println("Résultat : " + result);
```

🌟 **3.12 Le type UUID**

### **3.12.1 Pourquoi utiliser UUID ?**

Le type `UUID` (Universally Unique Identifier) est utilisé pour :
- **Identifiants non prédictibles** : idéal pour des systèmes distribués où les collisions doivent être évitées.
- **Sécurité** : empêche les attaques basées sur des identifiants séquentiels.
- **Tracking** : suivi unique d'objets, d'événements ou de sessions.

### **3.12.2 Méthodes essentielles**

- **`UUID.randomUUID()`** : Génère un identifiant unique aléatoire.
- **`UUID.fromString(String)`** : Convertit une chaîne de caractères en un objet `UUID`.
- **`UUID.toString()`** : Convertit un objet `UUID` en une chaîne de caractères.

### **3.12.3 Cas métiers**

✔️ **Générer un identifiant unique pour une ressource**
```java
UUID resourceId = UUID.randomUUID();
System.out.println("Nouvel identifiant unique : " + resourceId);
```
✔️ **Valider et convertir un identifiant reçu**
```java
try {
    UUID uuid = UUID.fromString(input);
    System.out.println("UUID valide : " + uuid);
} catch (IllegalArgumentException e) {
    System.out.println("UUID invalide !");
}
```
✔️ **Stocker un UUID dans une base de données**
```java
String uuidString = UUID.randomUUID().toString();
// Enregistrer uuidString dans la colonne correspondante
```

✔️ **Utiliser un UUID pour le suivi d'une session utilisateur**
```java
UUID sessionId = UUID.randomUUID();
System.out.println("Session ID : " + sessionId);
```

🌟 **3.13 Le type Optional (Java 8+)**

### **3.13.1 Pourquoi utiliser Optional ?**
Le type `Optional` permet d’éviter les `NullPointerException` en encapsulant une valeur qui peut être présente ou absente.

### **3.13.2Méthodes essentielles**
- **`isPresent()`** : Vérifie si une valeur est présente.
- **`orElse()`** : Retourne la valeur si elle est présente, sinon une valeur par défaut.
- **`orElseGet()`** : Retourne la valeur si elle est présente, sinon une valeur calculée par un fournisseur.
- **`orElseThrow()`** : Retourne la valeur si elle est présente, sinon lève une exception.
- **`map()`** : Applique une fonction à la valeur si elle est présente.
- **`flatMap()`** : Applique une fonction qui retourne un `Optional`.

### **3.13.3Cas métiers**
✔️ **Retour d’un repository**
```java
Optional<User> user = repository.findById(id);
```


✔️ **Raccourcir un code de vérification**
```java
User user = optUser.orElseThrow(UserNotFound::new);
```

--------------------------------------------------------------



# 4. 🔥 Classes utilitaires indispensables

Java propose plusieurs classes utilitaires essentielles pour simplifier les opérations courantes. Voici un aperçu des principales classes et de leurs usages.

## 4.1 **Objects** — Manipulation sécurisée des objets

### ✔️ Comparaison null-safe
Utilisez `Objects.equals(a, b)` pour comparer deux objets tout en évitant les erreurs dues à des valeurs `null`.

Exemple :
```java
Objects.equals(user1, user2); // Évite les NullPointerException
```

✔️ Vérification des arguments
La méthode `Objects.requireNonNull()` permet de s'assurer qu'un argument n'est pas null. Si l'argument est null, une exception est levée.

Exemple :
```java
Objects.requireNonNull(email, "email must not be null");
```


Cas métier : Validation des entrées dans une API REST, un DTO ou un service.

## 4.2 Collections

Méthodes courantes :
`Collections.sort(list)` : Trie une liste.
`Collections.reverse(list)` : Inverse l'ordre des éléments d'une liste.
`Collections.unmodifiableList(list)` : Rend une liste non modifiable.

Exemple :
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Collections.sort(names); // Trie par ordre alphabétique
Collections.reverse(names); // Inverse l'ordre
List<String> unmodifiableNames = Collections.unmodifiableList(names); // Liste non modifiable
```

Cas métier : renvoyer une liste non modifiable depuis un service.

## 4.3 Arrays
`Arrays.sort(array)` : Trie un tableau.
`Arrays.toString(array)` : Convertit un tableau en chaîne de caractères.
`Arrays.stream(array)` : Transforme un tableau en un Stream pour des opérations fonctionnelles.

Exemple :
```java
int[] numbers = {5, 3, 8, 1};
Arrays.sort(numbers); // Trie le tableau
System.out.println(Arrays.toString(numbers)); // Affiche : [1, 3, 5, 8]
```

Cas métier : traitement d’un tableau de résultats SQL bruts.


--------------------------------------------------------------

# 5. 🔥 Génériques — comprendre T, U, R comme un pro

Les génériques permettent d’écrire du code réutilisable.

## 5.1 Exemple simple
```java
public class Box<T> {
private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

Usage :
```java
Box<String> b = new Box<>();
b.set("Hello");
```

## 5.2 Les wildcards
- **?** — *Type inconnu*  
  Utilisé lorsque le type exact n'est pas spécifié.  
  Exemple : `List<?> list;`

- **? extends T** — *Lecture uniquement*  
  Permet de lire des éléments d'un type qui hérite de `T`.  
  Exemple : `List<? extends Number> nums;`

- **? super T** — *Écriture uniquement*  
  Permet d'écrire des éléments d'un type qui est un supertype de `T`.  
  Exemple : `List<? super Integer> ints;`

## 5.3 Cas métiers

✔️ **Créer une API REST générique pour gérer tous les types de données.**  
✔️ **Développer un convertisseur réutilisable pour transformer un DTO en entité.**  
✔️ **Concevoir un repository générique pour centraliser les opérations.**

--------------------------------------------------------------

# 6. 🔥 TDD & Tests unitaires (JUnit + Mockito)
🎯 **TDD (Test-Driven Development)**

➡️ **Principe** : Écrire les tests **avant** le code.  
➡️ **Mantra** : *Test First → Code After*.

## 6.1 Structure d’un test JUnit
```java
@Test
void shouldCalculateTotal() {
Cart cart = new Cart();
cart.addItem(new Item("PC", 1000));

    assertEquals(1000, cart.getTotal());
}
```

## 6.2 Mockito — simuler des dépendances
```java
when(repo.findById(1L)).thenReturn(Optional.of(user));
```

## 6.3 Cas métier

✔️ **Simuler une base de données**  
✔️ **Tester un service métier**  
✔️ **Garantir qu’un mail est envoyé**  
✔️ **Tester un service REST**  
✔️ **Bloquer les régressions**

--------------------------------------------------------------

# 7. 🔥 Design Patterns essentiels en Java backend
## 7.1 Builder
```java
User u = User.builder()
.name("Manu")
.age(25)
.build();
```

Cas métier :

**Entités complexes**

**Objects immuables**

**DTO**

## 7.2 DTO (Data Transfer Object)
```java
public record UserDTO(String name, int age) {}
```

Cas métier :

✔️ **Séparer clairement le domaine des données reçues (ex. depuis Angular)**  
✔️ **Garantir une meilleure sécurité des données**

## 7.3 Factory
```java
User user = UserFactory.createFrom(type);
```

Cas métier :

✔️ **Instancier un objet selon un rôle ou type d’utilisateur**

## 7.4 Singleton

Attention → souvent mal utilisé.

```java
public class Config {
private static final Config INSTANCE = new Config();
public static Config getInstance() { return INSTANCE; }
}
```

**Points importants :**

**✔️ Avantages :**
- Contrôle strict sur l'instance unique.
- Réduction de la consommation mémoire dans certains cas.
- Utilisé pour des ressources partagées comme des configurations, des journaux, ou des connexions.

**⚠️ Inconvénients :**
- Peut poser des problèmes dans les environnements multi-thread si mal implémenté.
- Peut rendre les tests unitaires plus complexes (difficile de simuler ou remplacer l'instance).

**📌 Cas d'utilisation :**
- Gestion de la configuration d'une application.
- Gestionnaire de connexion à une base de données.
- Gestionnaire de logs.

--------------------------------------------------------------

# 8. 🔥 Architecture — comprendre Clean Architecture

🎯 **Objectifs :**
- ✅ Séparer ton code en **couches claires**
- ✅ Rendre ton application **testable**, **maintenable**, et **scalable**

## 8.1 Structure typique d’une app Java pro
```
/domain
  /model
  /service
/application
  /usecases
/infrastructure
  /repository
  /controller
  /config
```

## 8.2 Principes
💡 **1. Le domaine ne dépend de rien**  
*(ni Spring, ni web, ni base de données)*

💡 **2. Les use-cases orchestrent le métier**  
💡 **3. L’infrastructure adapte la technique**  
*(Spring, SQL, HTTP…)*

## 8.3 Exemple métier : créer un utilisateur

**Domaine** : `User`, `Password`, `règles métier`

**Application** : `CreateUserUseCase`

**Infrastructure** : `UserController`, `UserRepositoryJpa`

--------------------------------------------------------------

# 9. 🗂️ Les Collections en Java

Les collections sont au cœur de 80 % du code backend Java.  
Maîtriser parfaitement les `List`, `Set`, `Map` et leurs variantes te rendra immédiatement plus solide en tant que développeur Java.

### Cette section couvre :

- **Les interfaces clés**
- **Les implémentations les plus utilisées**
- **Les méthodes importantes**
- **Des cas d’usages réels en entreprise**
- **Des schémas mentaux pour choisir la bonne collection**
- **Des pièges et bonnes pratiques**
- **Des exemples concrets avec Java 21**

📌 **On commence !**

## 9.1 🔑 Les 3 familles principales

Avant de rentrer dans les détails, retiens ceci :

**Collection** :
- **List** → Ordonnée, indexée, doublons autorisés
- **Set** → Non ordonnée (sauf exceptions), pas de doublons
- **Map** → Paire clé/valeur (clé unique)

Ces trois abstractions sont la base sur laquelle tout repose.


## 9.2 📝 LIST — Quand tu veux préserver l’ordre

✔️ **Une List est utilisée dans les cas suivants :**

- **L’ordre des éléments est important.**
- **Tu veux accéder aux éléments via un index.**
- **Les doublons sont acceptés.**
- **Tu souhaites trier, filtrer ou manipuler les éléments avec un Stream.**

### 9.2.1 Implémentations principales
🔹 **ArrayList**

- **Usage principal** : La plus utilisée en entreprise.

- **Avantages** :
  - Rapide pour les accès par index.
  - Très performant pour les lectures.
- **Exemple** :
-
```java
List<String> names = new ArrayList<>();
names.add("Manu");
names.add("Ivar");
```

🔹 **LinkedList**

**Usage principal** : Ajouts/suppressions très rapides.

**Avantages** :
- Idéal pour les structures FIFO (queues) ou LIFO (stacks).
- Inconvénients :
- Moins performant que ArrayList pour les accès par index.
  **Exemple** :
 ```java
Queue<String> queue = new LinkedList<>();
queue.add("task1");
queue.add("task2");
```

### 9.2.2 Méthodes essentielles de List
| **Méthode**         | **Explication**            | **Exemple**               |
|----------------------|----------------------------|---------------------------|
| `.add(E e)`         | Ajoute un élément          | `list.add("Java");`       |
| `.addAll(...)`      | Ajoute une collection complète | `list.addAll(List.of("Java", "Python"));` |
| `.get(int index)`   | Lecture par index          | `String lang = list.get(0);` |
| `.set(index, element)` | Remplace un élément      | `list.set(0, "Kotlin");`  |
| `.remove(index)` / `.remove(obj)` | Supprime     | `list.remove(0);` ou `list.remove("Java");` |
| `.contains(obj)`    | Vérifie présence           | `boolean exists = list.contains("Java");` |
| `.isEmpty()`        | Liste vide ?               | `boolean empty = list.isEmpty();` |
| `.clear()`          | Vide toute la liste        | `list.clear();`           |
| `.size()`           | Nombre d’éléments          | `int count = list.size();` |

**Exemple :**

```java
List<Integer> scores = List.of(10, 20, 30);
int first = scores.get(0); // 10
```

### 9.2.3 Cas d’usage réel : inventaire utilisateur
```java
public class User {
private List<String> roles = new ArrayList<>();

    public void addRole(String role) {
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }
}
```

## 9.3 🟩 SET — Quand tu veux des éléments uniques

✔️ **Un Set est idéal dans les cas suivants :**

- **Éviter les doublons** dans une collection.
- **Vérifier rapidement la présence** d'un élément.
- **Gérer des données uniques** comme des tags, permissions ou emails.

### 9.3.1 Implémentations
🔸 **HashSet**

- **Usage principal** : La plus courante.
- **Avantages** :
  - Très rapide pour les opérations de recherche.
  - Idéal pour les collections sans doublons.
- **Inconvénients** :
  - Non ordonné (l'ordre d'insertion n'est pas garanti).

```java
Set<String> emails = new HashSet<>();
emails.add("manu@mail.com");
emails.add("manu@mail.com"); // ignoré
```

🔸 **LinkedHashSet**

- **Description** : Comme `HashSet`, mais conserve l’ordre d’insertion.
- **Utilisation** : Idéal pour les cas où l’ordre des éléments est important tout en évitant les doublons.

🔸 **TreeSet**

- **Description** : Tri automatique des éléments.
- **Avantages** : Maintient les éléments triés selon leur ordre naturel ou un comparateur personnalisé.
- **Inconvénients** : Moins performant que `HashSet` pour les opérations courantes.
- **Remarque** : Nécessite un comparateur si les éléments ne sont pas comparables.

```java
Set<Integer> ordered = new TreeSet<>(List.of(3,1,2));
```

### 9.3.2 Méthodes essentielles
| **Méthode**   | **Explication**           | **Exemple**                  |
|---------------|---------------------------|------------------------------|
| `.add()`      | Ajoute un élément unique  | `set.add("Java");`           |
| `.contains()` | Vérifie la présence       | `boolean exists = set.contains("Java");` |
| `.remove()`   | Supprime un élément       | `set.remove("Java");`        |
| `.size()`     | Retourne le nombre d’éléments | `int count = set.size();`   |
| `.isEmpty()`  | Vérifie si le Set est vide | `boolean empty = set.isEmpty();` |
| `.clear()`    | Vide complètement le Set  | `set.clear();`               |

### 9.3.3 Cas d’usage réel : Permissions utilisateur
```java
Set<String> permissions = new HashSet<>();
permissions.add("USER_READ");
permissions.add("USER_WRITE");
permissions.add("USER_READ"); // ignoré
```

## 9.4 🗺️ MAP — Paire Clé / Valeur

### 🗺️ **MAP — Paire Clé / Valeur**

La structure la plus puissante du backend Java.

#### **Utilisations courantes :**
- 🔹 **Caches** pour des données fréquemment utilisées.
- 🔹 **Index rapides** pour des recherches efficaces.
- 🔹 **Stockage des utilisateurs par ID**.
- 🔹 **Association de paramètres** à des clés spécifiques.
- 🔹 **Comptage des occurrences** dans une collection.
- 🔹 **Construction d’objets** à partir d’un JSON.

### 9.4.1 Implémentations
🔸 **HashMap**

- **Usage principal** : La plus utilisée.
- **Avantages** :
  - Accès rapide.
  - Très performant pour les recherches.
- **Inconvénients** :
  - Non ordonnée (l'ordre d'insertion n'est pas garanti).

```java
Map<Integer, String> users = new HashMap<>();
users.put(1, "Manu");
users.put(2, "Ivar");
```

🔸 **LinkedHashMap**

- **Caractéristique principale** : Conserve l’ordre d’insertion des éléments.
- **Avantages** :
  - Idéal pour les cas où l’ordre des éléments est important.
  - Très utile pour les API qui nécessitent un JSON ordonné.

**Exemple :**
```java
Map<String, Object> payload = new LinkedHashMap<>();
payload.put("id", 1);
payload.put("name", "Manu");
payload.put("tech", List.of("Java", "Angular"));

System.out.println(payload);
// Résultat : {id=1, name=Manu, tech=[Java, Angular]}
```

🔸 **TreeMap**

- **Clés triées automatiquement** selon l'ordre naturel ou un comparateur personnalisé.
- **Usage principal** : Idéal pour les statistiques ou les données nécessitant un tri constant.
- **Avantages** : Maintient les éléments triés, utile pour des rapports ou des analyses.
```java
Map<Integer, Integer> count = new TreeMap<>();
count.put(10, 5);
count.put(2, 1);
// Clés triées : 2, 10
```

### 9.4.2 Méthodes essentielles
| **Méthode**           | **Explication**                     |
|------------------------|-------------------------------------|
| `.put(key, value)`     | Ajoute ou remplace une paire clé/valeur |
| `.get(key)`            | Retourne la valeur associée à une clé |
| `.containsKey(key)`    | Vérifie si une clé existe           |
| `.containsValue(value)`| Vérifie si une valeur existe        |
| `.remove(key)`         | Supprime une paire clé/valeur       |
| `.size()`              | Retourne le nombre d’éléments       |
| `.isEmpty()`           | Vérifie si la `Map` est vide        |
| `.putIfAbsent(k, v)`   | Ajoute une paire clé/valeur si la clé est absente |
| `.computeIfAbsent(k, fn)` | Construit et ajoute une valeur si la clé est absente |
| `.forEach((k,v)->{})`  | Itère sur les paires clé/valeur     |

### 9.4.3 Exemple réel : Compter des occurrences
```java
Map<String, Integer> counter = new HashMap<>();

for (String word : words) {
counter.put(word, counter.getOrDefault(word, 0) + 1);
}
```

## 9.5 🧠 Schéma mental — Comment choisir sa collection ?
### 🧠 Comment choisir la bonne collection ?

1. **Dois-tu préserver l’ordre ?**
- ✔️ Oui → **List**
- ❌ Non

2. **Dois-tu éviter les doublons ?**
- ✔️ Oui → **Set**
- ❌ Non

3. **As-tu besoin d’une clé pour accéder ?**
- ✔️ Oui → **Map**
- ❌ Non → **List** ou **Set**

## 13.6 🧨 Pièges fréquents
❌ **Utiliser `List` pour vérifier la présence rapide**

✔️ **`Set` est 1000× plus efficace**

❌ **Utiliser `HashMap` pour garder l'ordre**

✔️ **`LinkedHashMap` est plus adapté**

❌ **Utiliser `TreeMap` ou `TreeSet` inutilement**

✔️ **Tri = coût**  
N’utilise que si absolument nécessaire.

## 9.7 🧪 Cas réel Spring Boot
🔒 **Stocker les rôles d’un utilisateur sans doublon**
```java
public class User {
private Set<String> roles = new HashSet<>();

    public void addRole(String r) {
        roles.add(r);
    }
}
```

### 🌟 Construire une `Map` pour un JSON

```java
Map<String, Object> payload = new LinkedHashMap<>();
payload.put("id", 1);
payload.put("name", "Manu");
payload.put("tech", List.of("Java", "Angular"));
```
--------------------------------------------------------------

# 🔥 10. Les Streams en Java

Les Streams permettent de :

- **Transformer des données**
- **Filtrer**
- **Mapper**
- **Grouper**
- **Agréger**
- **Compter**
- **Réduire**
- **Paralléliser des traitements**
- **Nettoyer du code impératif illisible**

#### **Avantages des Streams :**

- ✅ Écriture de code **plus lisible**
- ✅ Code **plus court**
- ✅ Syntaxe **plus expressive**
- ✅ **Facilité de test**
- ✅ Programmation **plus fonctionnelle**

## 10.1 💡 Le principe d’un Stream

Un Stream, c’est :

- **Données** → **Pipeline d’opérations** → **Résultat**

### Principes clés :
- 👉 Toujours **chaîné**
- 👉 Toujours **non modifiant** la structure d’origine
- 👉 Toujours terminé par une **opération terminale**

#### Exemple simple :
```java
List<String> names = List.of("Manu", "Ivar", "Loki");

names.stream()
.filter(n -> n.startsWith("I"))
.forEach(System.out::println);
// Affiche : Ivar
```

## 10.2 📌 Les 3 types d’opérations
1. **Opérations intermédiaires**  
   Ces opérations transforment un `Stream` en un autre `Stream`.

   **Exemples courants** :
- `filter`
- `map`
- `sorted`
- `limit`
- `skip`
- `distinct`

2. **Opérations terminales**  
   Ces opérations ferment le `Stream` et retournent un résultat.

   **Exemples courants** :
- `collect`
- `toList`
- `reduce`
- `findFirst`
- `anyMatch`
- `forEach`

3. **Opérations de création**  
   Ces opérations permettent de créer un `Stream`.

**Exemples courants** :
- `List<String> names = List.of("Alice", "Bob");`  
  `Stream<String> namesStream = names.stream();`  
  // Crée une liste immuable et génère un Stream à partir de celle-ci

- `Stream<String> specificStream = Stream.of("A", "B", "C");`  
  // Crée un Stream contenant les éléments "A", "B", et "C"

- `Stream<Object> emptyStream = Stream.empty();`  
  // Crée un Stream vide de type Object

- `IntStream intStream = Arrays.stream(new int[]{1, 2, 3});`  
  // Crée un Stream d'entiers à partir d'un tableau

# 10.3 🛠️ Les opérations intermédiaires (détaillées)

### 🌟 Les méthodes les plus importantes

- **Explication** : Description claire de chaque méthode.
- **Schéma visuel** : Représentation graphique pour mieux comprendre.
- **Cas d’usage réel** : Exemple concret tiré du monde professionnel.
- **Exemple complet** : Code prêt à l’emploi.

### 10.3.1 filter(predicate)
✔️ **Utilité** :

Permet de conserver uniquement les éléments qui respectent une condition donnée.

🎯 **Cas d’usage réel** :

- Filtrer les utilisateurs actifs.
- Sélectionner les produits disponibles.
- Identifier les logs d’erreur.

**Exemple :**
```java
List<Integer> scores = List.of(10, 50, 80, 30);

List<Integer> high = scores.stream()
.filter(s -> s > 40)
.toList();
// high = [50, 80]
```

### 10.3.2 map(function)
✔️ **Utilité** :

Transformer les éléments d'une collection ou d'un flux.

🎯 **Cas d’usage** :

- Convertir un `User` → `UserDTO`.
- Extraire un champ spécifique (ex. `user.name`).
- Transformer un `String` → `Integer`.

**Exemple :**
```java
List<String> nums = List.of("1", "2", "3");

List<Integer> result = nums.stream()
    .map(Integer::parseInt)
    .toList();
// result = [1, 2, 3]
```

### 10.3.3 flatMap()
✔️ **Sert à :**

Aplatir des listes imbriquées.

🎯 **Cas d’usage :**

Tu as une `List<List<String>>`  
Tu veux une `List<String>`

**Exemple :**
```java
List<List<String>> names = List.of(
    List.of("Manu", "Ivar"),
    List.of("Anna", "Loki")
);

List<String> flat = names.stream()
    .flatMap(List::stream)
    .toList();
// flat = [Manu, Ivar, Anna, Loki]
```

### 10.3.4 sorted()
✔️ **Utilité** :

Permet de **trier** les éléments d’un `Stream`.

**Exemple** :
```java
users.stream()
    .sorted(Comparator.comparing(User::getAge))
    .toList();
// Trie les utilisateurs par âge croissant
```

### 10.3.5 distinct()
✔️ **Utilité** :

Permet de **supprimer les doublons** dans une collection.

### **Exemple :**
```java
List<Integer> unique = List.of(1, 2, 2, 3, 3, 3)
    .stream()
    .distinct()
    .toList();
// unique = [1, 2, 3]
```

# 10.4 🎯 Les opérations terminales essentielles
### 10.4.1 toList() (Java 16+)
✔️ **Utilité** :

Permet de **convertir un Stream en une liste IMMUTABLE**.

### **Exemple :**
```java
List<String> names = stream.toList();
```

### 10.4.2 collect(Collectors.toList())
✔️ **Utilisation** :

- Ancienne méthode → Produit une **liste mutable**.

### **Quand l'utiliser ?**

- Lorsque vous avez besoin de **modifier** la liste après sa création.

### 10.4.3 findFirst() / findAny()
✔️ **Utilité** :

Permet de **retourner un élément optionnel**.

**Exemple** :

```java
import java.util.Optional;

Optional<User> user = users.stream()
        .filter(u -> u.isActive())
        .findFirst();
// Retourne le premier utilisateur actif

Optional<User> anyUser = users.stream()
        .filter(u -> u.isActive())
        .findAny();
// Retourne un utilisateur actif quelconque
```

### 10.4.4 anyMatch, allMatch, noneMatch
✔️ **Vérification logique**

**Exemple :**

```java
boolean anyBad = products.stream()
    .anyMatch(p -> p.isExpired());
// true si au moins un produit est expiré
boolean allActive = users.stream()
    .allMatch(u -> u.isActive());
// true si tous les utilisateurs sont actifs
boolean noneNull = items.stream()
    .noneMatch(i -> i == null);
// true si aucun item n'est null
```

### 10.4.5 reduce()

✔️ **Utilité** : Combine les éléments d’un `Stream` pour produire une seule valeur.

🎯 **Cas d’usage** :
- Calculer une somme, un produit ou une moyenne.
- Réduire une collection à une valeur unique (ex. total, maximum).

**Exemple :**

```java
int sum = List.of(1, 2, 3)
    .stream()
    .reduce(0, (a, b) -> a + b);
// sum = 6
```

# 10.5 🏗️ Collectors avancés

#### 10.5.1 `groupingBy` — Grouper

🎯 **Exemple réel** : Grouper des utilisateurs par rôle.

```java
Map<String, List<User>> usersByRole = users.stream()
    .collect(Collectors.groupingBy(User::getRole));
// usersByRole = {
//   "ADMIN": [User1, User2],
//   "USER": [User3, User4]
}
```

### 10.5.2 counting() — compter

```java
Map<String, Long> countByType = events.stream()
.collect(Collectors.groupingBy(
Event::type,
Collectors.counting()
));
// countByType = {
//   "LOGIN": 5,
//   "LOGOUT": 3
//}
```


### 10.5.3 joining() — concaténer des String

```java
String csv = List.of("Manu", "Ivar", "Loki")
.stream()
.collect(Collectors.joining(","));
// csv = "Manu,Ivar,Loki"
```

### 10.5.4 mapping() — transformer dans un groupingBy

🎯 **Cas d’usage avancé et fréquent :** Simplifie la transformation des données tout en les regroupant.

```java
Map<String, List<String>> namesByRole = users.stream()
.collect(Collectors.groupingBy(
User::getRole,
Collectors.mapping(User::getName, Collectors.toList())
));
// namesByRole = {
//   "ADMIN": ["Manu", "Ivar"],
//   "USER": ["Loki", "Anna"]
}
```
# 10.6 🧨 Les pièges du Stream API

❌ **1. Ne jamais réutiliser un Stream**

Un Stream consommé est **consommable une seule fois**. Une fois utilisé, il est **mort**.

✔️ Exemple :
```java
Stream<String> stream = List.of("A", "B", "C").stream();
stream.forEach(System.out::println); // OK
stream.forEach(System.out::println); // 💥 IllegalStateException
```

❌ **2. Ne pas mettre de logique métier dans un Stream**

👉 **Règle d'or** : Les Streams servent à **transformer les données**, pas à **prendre des décisions métier**.
```java
List<User> users = userRepository.findAll();
List<UserDTO> dtos = users.stream()
    .map(user -> new UserDTO(user.getName(), user.getEmail())) // Transformation
    .toList();
```

❌ **3. Ne jamais utiliser `.forEach()` dans un `.map()`**

Cela crée un code confus et inefficace. Utilisez `.forEach()` uniquement comme **opération terminale**.
```java
List<String> names = List.of("Alice", "Bob", "Charlie");

// Mauvais
names.stream()
    .map(name -> {
        System.out.println(name); // 💥 Confus
        return name.toUpperCase();
    })
    .toList();

// Bon
names.stream()
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

❌ **4. Éviter les Streams parallèles (`parallelStream`) sans raison**

Les Streams parallèles sont **coûteux** en termes de ressources et peuvent entraîner des **problèmes de concurrence**.
Utilisez-les uniquement lorsque vous traitez de **grandes quantités de données** et que vous avez **besoin d'optimisation**.
```java
List<Integer> numbers = IntStream.range(1, 1000).boxed().toList();

// Mauvais
numbers.parallelStream()
    .forEach(System.out::println); // 💥 Risque de concurrence inutile

// Bon
numbers.stream()
    .forEach(System.out::println);
```

# 10.7 🧠 Cas réels utilisés en entreprise

1. **Transformer `List<User>` → `Map<id, name>`**
   ```java
   Map<Long, String> map = users.stream()
       .collect(Collectors.toMap(User::getId, User::getName));
   // map = {1L: "Manu", 2L: "Ivar"}
   ```  


2. **Extraire les emails uniques**
```java
List<String> emails = users.stream()
    .map(User::getEmail) // Extraction des emails
    .distinct()          // Suppression des doublons
    .toList();           // Conversion en liste
```

3. **Compter les produits par catégorie**
   ```java
   Map<String, Long> productCount = products.stream()
   .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    // productCount = {"Electronics": 5, "Books": 3}
   ```

3. **Pipeline avancé pour transformer les utilisateurs actifs en UserDTO triés par date de création**
```java
List<UserDTO> results = users.stream()
.filter(User::isActive) // Filtrer uniquement les utilisateurs actifs
.sorted(Comparator.comparing(User::getCreatedAt)) // Trier par date de création
.map(UserDTO::new) // Transformer en UserDTO
.toList(); // Collecter les résultats dans une liste immuable
```

# 10.8 🧠 Schéma mental expert — Choisir l’opération Stream
### 🧠 Schéma mental expert — Choisir l’opération Stream

- **Réduire le nombre d’éléments** :  
  → `filter`, `distinct`, `limit`, `skip`

- **Transformer les données** :  
  → `map`, `flatMap`

- **Trier les éléments** :  
  → `sorted`

- **Agréger les données** : Combine plusieurs éléments pour produire une valeur unique (ex. somme, moyenne, regroupement).
- → `reduce`, `groupingBy`, `counting`

- **Convertir en une structure** :  
  → `collect`

- **Itérer sur les éléments** *(avec précaution)* :  
  → `forEach`

# 10.9 🏆 Résumé visuel de tout le Stream API
**Pipeline d’un Stream :**

1. **Source des données** : `collection`
2. **Création du Stream** : `stream()`
3. **Filtrage** : `filter()`
4. **Transformation** : `map()`
5. **Suppression des doublons** : `distinct()`
6. **Tri des éléments** : `sorted()`
7. **Collecte des résultats** : `collect()`

**Résultat final** : `résultat`
```java
List<ResultType> result = collection.stream()
    .filter(...)      // Étape de filtrage
    .map(...)         // Étape de transformation
    .distinct()       // Suppression des doublons
    .sorted(...)      // Tri des éléments
    .collect(...);    // Collecte des résultats
```

--------------------------------------------------------------

# #️⃣ **11. Lambda et Programmation Fonctionnelle**

💡 La programmation fonctionnelle en Java est essentielle pour maîtriser les **Streams**, les **Collections modernes**, les **API réactives**, et pour écrire du code **propre**, **court** et **lisible**.

## 11.1. Qu’est-ce qu’une Lambda ?

Une *lambda* est une fonction anonyme, sans nom, que l'on peut passer comme valeur.

### Forme générale :
- `(paramètres) -> expression`
- `(paramètres) -> { bloc de code }`

### Exemple simple :
```java
Runnable r = () -> System.out.println("Hello");
```

La ligne sélectionnée explique qu’une *lambda* permet de créer un objet `Runnable` sans utiliser une classe anonyme. Cela signifie que vous pouvez définir le comportement d’une méthode directement, sans avoir à créer une classe interne ou anonyme.

Dans cet exemple, la lambda `() -> System.out.println("Hello")` remplace la classe anonyme. Cela rend le code plus concis et lisible.
## 11.2. Pourquoi utiliser des Lambdas ?

- ✔️ **Code plus concis**
- ✔️ **Plus lisible**
- ✔️ **Parfait pour les Streams**
- ✔️ **Remplace les classes anonymes**
- ✔️ **Favorise la programmation déclarative**
- ✔️ **Indispensable pour le tri, le filtrage, le mapping, la transformation**

## 11.3. Interfaces Fonctionnelles

Une *lambda* ne fonctionne que pour une interface avec une seule méthode abstraite (**SAM** — *Single Abstract Method*).

### Les principales interfaces fonctionnelles :

| **Interface**      | **Méthode**            | **Usage**                  |
|---------------------|------------------------|----------------------------|
| `Predicate<T>`      | `boolean test(T t)`    | Filtrer                    |
| `Function<T,R>`     | `R apply(T t)`         | Transformer                |
| `Consumer<T>`       | `void accept(T t)`     | Appliquer une action       |
| `Supplier<T>`       | `T get()`              | Fournir une valeur         |
| `Comparator<T>`     | `int compare(T t1, T t2)` | Tri                      |

### Exemple concret (backend) :
```java
Predicate<User> isAdmin = user -> user.getRole().equals("ADMIN");
Function<User, UserDTO> toDTO = user -> new UserDTO(user.getName(), user.getEmail());
// Utilisation
List<UserDTO> admins = users.stream()
    .filter(isAdmin)
    .map(toDTO)
    .toList();
```

## 11.4. Utilisation en Streams
✔️ **Filtrer** :
```java
var adults = users.stream()
    .filter(user -> user.getAge() >= 18)
    .toList();
// Récupère les utilisateurs majeurs
```

✔️ **Transformer** :
```java
// Transformer les utilisateurs en une liste de noms
List<String> names = users.stream()
        .map(User::getName)
        .distinct() // Évite les doublons dans les noms
        .sorted() // Trie les noms par ordre alphabétique
        .toList();
```

✔️ **Trier** :

```java
users.sort(Comparator.comparing(User::getAge));
// Trie les utilisateurs par âge croissant
```

## 11.5. Composition fonctionnelle

✨ **La composition fonctionnelle permet de combiner plusieurs fonctions pour créer un pipeline d'opérations. Cela est utile pour appliquer des transformations successives à une donnée de manière claire et lisible.**

```java
// Composition de fonctions
Function<Integer, Integer> doubler = x -> x * 2;
Function<Integer, Integer> ajouterTrois = x -> x + 3;

// Pipeline : d'abord doubler, puis ajouter trois
Function<Integer, Integer> pipeline = doubler.andThen(ajouterTrois);

System.out.println(pipeline.apply(4)); // Résultat : 11
```

## 11.6. Méthode de référence
### **Formes de références de méthode :**

- **Classe::méthodeStatique**
- **instance::méthode**
- **Classe::new**
- **Classe::méthodeDInstance**

#### **Exemple :**

```java
list.forEach(System.out::println);
```

## 11.7. Schéma visuel
**Lambda** → Fonction anonyme  
⬇  
**S’attache à** → Interface fonctionnelle (**SAM**)  
⬇  
**Utilisation** → Streams, tri, filtrage, mapping  
⬇  
**Bénéfices** → Code court, lisible, performant

# #️⃣ 12. Dates & Temps (LocalDate, Instant, etc.)

Java moderne utilise `java.time`, qui est **précis**, **clair** et **IMMUTABLE** (important).

### Cette API remplace totalement :
- `Date`
- `Calendar`
- `SimpleDateFormat`

## 12.1. Les types principaux
| **Type**           | **Utilité**                              |
|---------------------|------------------------------------------|
| `LocalDate`         | Date sans heure *(ex. 2025-10-12)*      |
| `LocalTime`         | Heure seule *(ex. 14:55)*               |
| `LocalDateTime`     | Date + heure *(ex. 2025-10-12 14:55)*   |
| `Instant`           | Timestamp UTC                           |
| `OffsetDateTime`    | Date + offset                           |
| `ZonedDateTime`     | Date + fuseau horaire                   |
| `Duration`          | Durée en heures/minutes/secondes        |
| `Period`            | Durée en années/mois/jours              |
## 12.2. LocalDate
### Création :
- `LocalDate now = LocalDate.now();`
- `LocalDate date = LocalDate.of(2025, 3, 14);`

### Lecture :
- `int year = date.getYear();`
- `int month = date.getMonthValue();`
- `int day = date.getDayOfMonth();`

### Opérations :
- `date.plusDays(10);`
- `date.minusMonths(2);`
- `date.withDayOfMonth(1);`

### Comparaison :
- `date.isBefore(otherDate);`
- `date.isAfter(otherDate);`
- `date.equals(otherDate);`

### Formatage :
- `DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");`
- `String s = date.format(f);`

## 12.3. LocalDateTime
LocalDateTime dt = LocalDateTime.now();
dt = dt.plusHours(3).minusDays(1);

### Utilisations courantes :

- **Logs** : Enregistrer des événements avec des horodatages précis.
- **Audit** : Suivre les modifications et les accès.
- **Timestamps lisibles** : Fournir des dates/horaires compréhensibles.
- **Validation métier** : Vérifier les contraintes temporelles.

## 12.4. Instant (UTC absolu)

### **Instant (UTC absolu)**

Le type le plus précis, utilisé pour :

- **Audits backends**
- **Timestamps DB**
- **Génération de tokens**
- **Comparaison temporelle fiable**

#### **Exemple :**
```java
Instant now = Instant.now();
```

**Convertir Instant → LocalDateTime :**

```java
LocalDateTime dt = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
```

## 12.5. Duration (secondes, minutes, heures)
#### **Exemple :**
```java
Duration d = Duration.between(start, end); // Calcul de la durée entre deux instants
long seconds = d.getSeconds(); // Nombre total de secondes
```

### Indispensable pour :

- **Mesurer une durée d’exécution**
- **Timeout**
- **Rate limiting**

## 12.6. Period (jours, mois, années)
```java
Period p = Period.between(date1, date2); // Calcul de la période entre deux dates
int years = p.getYears(); // Nombre d'années
```


### Indispensable pour :

- **Âge** : Calculer l'âge d'une personne ou d'un objet.
- **Délais légaux** : Gérer les échéances juridiques ou administratives.
- **Échéances financières** : Suivre les paiements ou les échéances de prêts.

## 12.7. Formatage avancé
```java
DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Format personnalisé
String text = LocalDateTime.now().format(f); // "2025-10-12 14:55:30"
```

## 12.8. Parsing
```java
LocalDate d = LocalDate.parse("2025-12-25"); // ISO 8601
LocalDateTime t = LocalDateTime.parse("2025-12-25T10:15:30"); // ISO 8601
```
## 12.9. Fuseaux horaires
```java
ZonedDateTime z = ZonedDateTime.now(ZoneId.of("Europe/Brussels"));
```
## 12.10. Schéma mental (très important)
- **LocalDate** : Date simple
- **LocalTime** : Heure simple
- **LocalDateTime** : Date + heure
- **Instant** : Temps absolu UTC
- **ZonedDateTime** : Date + heure + fuseau
- **Duration** : Secondes / Minutes / Heures
- **Period** : Jours / Mois / Années
