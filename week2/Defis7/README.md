# Challenge 7: Check the difference of trade in 2019 and 2020 using maps and a month. (hard challenge)

- Repository: `java_week_2`

- Type of Challenge: `Learning`

- Team challenge : `solo`

## The Mission

C'est un défi de taille. À partir du même fichier CSV, écrivez un programme qui comparera les valeurs d'exportation des mois de 2019 à 2020. Le pays est l'Union européenne. Utilisez HashMaps et la Collectors.groupingByfonction de Collectorsl'API Streams. La fonction « key » doit être le mois et la fonction « value » doit être la somme des valeurs d'exportation pour ce mois.

Astuce : vous ne pouvez pas effectuer cette opération avec un seul flux. Vous devrez créer deux flux, un pour l'année 2019 et un pour l'année 2020. Le résultat de ces opérations sera deux HashMaps : un pour l'année 2019 et un pour l'année 2020.

La carte pour l'année 2019 pourrait ressembler à ceci :

| key     | value       |
| ------- | ----------- |
| 01/2010 | 190 000 000 |
| 02/2010 | 345 000 000 |
| 03/2010 | 210 000 000 |

Astuce : filtrez avant d'utiliser la Collectors.groupingByfonction.

**Le résultat attendu est une impression de chaque mois des deux années, comparant les valeurs.**
