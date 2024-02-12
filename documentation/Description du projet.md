# Projet 3A Gradle/Spring Boot par Diafat Samy


## Comment lancer le projet ?

Pour lancer le projet, il suffit de lancer la fonctionnalité bootRun de Gradle 


## Déploiement d'une API REST



Voici les différentes méthodes disponibles sur mon API disponible en local sur le port 8080 :

    POST /player?name=NAME

Permet d'ajouter un joueur dans la base de données. Celle-ci est persistante et il y a déjà 3 joueurs enregistrés.

    GET : /player/:id (exemple /player/1)

Renvoie simplement l'id d'un joueur

    POST /play?player1Id=ID1&player2Id=ID2&handPlayer1=HAND1&handPlayer2=HAND2 (le résultat devra etre persisté)

Permet de faire jouer deux personnes, le résultat est stocké dans une table. En cas de match nul, null est renseignée dans la table.

Egalement, les variables HAND1 et HAND2 peuvent être renseignées en majuscule ou minuscle, cela n'aura pas d'incidence.

    GET /game-stats?playerId1=ID1 (donne les statistiques de jeu (parties gagnées, perdues, pire player ennemi)) 

En fonction de l'id du joueur, la méthode renvoie le nombre de parties jouées, le nombre de victoires, et la bête noire du joueur (avec le nombre de défaites contre celui-ci)

## Découverte de deux design patterns : Visitor et Composite

Dans le dossier domain du projet se trouve trois dossiers correspondant aux trois design patterns étudiés :

- PierreFeuilleCiseaux : vu en cours


- Visitor : implementé à travers un exemple d'entreprise (Airbus) ayant plusieurs services (Informatique et RH), et ces services ont eux-mêmes plusieurs projets (Planning, MobileApp et Website). Ces projets ont à leur tour des employés. Le visiteur va alors parcourir toutes les classes concretes implementées à travers les interfaces concrètes pour finalement s'arrêter à la classe correspondant aux employés et récupérer leurs salaires pour en calculer la somme.


- Composite : Exemple simple encore une fois à partir d'une entreprise ayant des départements et des employés.

Enfin, trois tests sont disponibles pour tester les trois design patterns.