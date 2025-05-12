# Générateur de Fichiers CSV

Ce programme génère des fichiers CSV contenant des informations aléatoires selon les spécifications suivantes :

## Champs du fichier CSV

1. **Prénom (firstname)** :  
    Choisi aléatoirement parmi un ensemble de 30 prénoms.

2. **Nom de famille (lastname)** :  
    Choisi aléatoirement parmi un ensemble de 40 noms de famille.

3. **Raison (reason)** :  
    Valeur aléatoire parmi deux options :  
    - `Appointment` (rendez-vous)  
    - `Visit` (visite)

4. **Département (department)** :  
    Choisi parmi 5 options :  
    - Cardiology  
    - Radiology  
    - Pediatrics  
    - Geriatrics  
    - Pulmonology  
    Ce champ est rempli uniquement si la raison est `Appointment`.

5. **Date de la visite (date of the visit)** :  
    Générée aléatoirement dans un mois spécifique de l’année en cours.

## Instructions

- Le nombre de lignes/entrées dans le fichier peut être défini, mais doit rester raisonnable (20 à 30 lignes suffisent pour cet exercice).
- Aucune interaction utilisateur ou interface n’est nécessaire. Le programme génère simplement un fichier CSV.

## Classes à Implémenter

1. **`RandomPicker`** :  
    Une classe (ou équivalent) permettant de choisir un élément aléatoire dans une liste.

2. **`VisitEntry` ou `PersonEntry`** :  
    Une classe représentant une ligne du CSV avec tous les champs.

3. **`CSVGenerator`** :  
    Une classe générant plusieurs entrées et écrivant dans un fichier CSV.

## Bibliothèques Recommandées

- `csv`  
- `random`  
- `datetime`  

## Limites

- Le nombre de lignes est limité à 20 ou 30 pour cet exercice.
- Le programme doit être autonome et ne nécessite pas d’interaction utilisateur.
