# README

Cette application appelé BINCEO est un prototype en ligne de commande permettant  à tout résident de:
- Faire le suivi des recyclables
- Faire le suivi des déchets organiques (résidus alimentaires).
- Visualiser l'efficacité des activités de recyclages et compostages.
- Signaler un problème à la ville.
- Trouver un consommateur de déchets organiques ou matières recyclables.


## Fonctionnalités 

- Se connecter en tant que résident/consommateur
  - créér un compte
  - Modifier son profil
- Gestion des bacs
  - Enregistrer un bac
  - Supprimer un bac
  - Afficher l'état des bacs
- Afficher l'état du traitement d'un lot de déchets.
- Consulter les métriques.
- Signaler un problème à MunicipInfo.
- Trouver un consommateur
- Gestion des activités:
  - Noter une activité.
  - Ajouter une activité.
  - Modifier une activité.
  - Supprimer une activité.
- Notifier les résidents au besoin.

## Manuel d'utilisation

Pour utiliser l'application, il vous faut exécuter la commande suivante: `java App` (ou autre commande).
Étant un prototype, nous avons inclus un jeu de données afin de tester l'application.
À l'ouverture, vous devez vous connecter en tant que résident ou consommateur. Ceci vous donnera accès au menu principal propre au rôle.

### Données incluses dans l'application

- Article
  - 000001;Learning from Code Repositories to Recommend Model Classes;...;2021-11-05;4;mde,ai;2,3
  - 000002;Code Sophistication: From Code Recommendation to Logic Recommendation;...;2021-12-02;2;ai,code;1,2
- Outil
  - 000001;ATomPM;AToMPM (A Tool for Multi-Paradigm Modeling) is the modeling tool we are developing at the University of Montreal;...;graphical-editor,language-workbench;2
  - 000002;Gentleman;Gentleman is a lightweight web-based projectional editor that aims to make modeling more accessible to domain experts and practitioners;...;projectional-editing,mde;2
- Projet
  - 000001;From domain-specific languages to domain-specific environments;...;2021;2025;4;mde,ai;2,3
  - 000002;Artificial intelligence for and by software engineering;...;2018;2023;ai,code;1,2
- Membre
  - 202010250001;cortez;juan;1990-01-13;juan.cortez@gmail.com;5147836802
  - 202004280010;hannoune;isabelle;1994-10-06;isa.hannoune@gmail.com;4382835821
- ...

### Connexion

Pour se connecter à l'application, veuillez utiliser un des identifiants suivants:

- Rôle du résident
  - email: jessie.galasso-carbonnel@umontreal.ca | password: jessie#pass | statut: VALIDE
  - email: oussama.ben.sghaier@umontreal.ca | password: oussama#pass | statut: VALIDE
  - email: aurelien.ducoin@umontreal.ca | password: aurelien#pass | statut: SUSPENDU
  - email: meriem.ben.chaaben@umontreal.ca | password: meriem#pass | statut: EN_ATTENTE
- Rôle du consommateur
  - email: syriani@iro.umontreal.ca | password: syriani#pass | statut: VALIDE
  - email: sahraouh@iro.umontreal.ca | password: sahraouh#pass | statut: EN_ATTENTE

### Menu principal (Résident)

À partir du menu principal, dans le rôle du résident, vous pouvez choisir l'une des options suivantes en tapant le chiffre correspondant.

- [1] Trouver un membre: Accédez à la liste des résidents ou effectuer une recherche.
- [2] Trouver un article: Accédez à la liste des articles ou effectuer une recherche.
- [3] Trouver un outil: Accédez à la liste des articles ou effectuer une recherche.
- [4] Trouver un projet: Accédez à la liste des articles ou effectuer une recherche.
- [5] Gérer mes activités: Accédez à la liste de vos activités et ajouter, modifier ou supprimer une activité.
- [6] Gérer mes inscriptions: Accédez à la liste de vos inscriptions et ajouter, modifier ou supprimer une inscription.
- [7] Consulter mes notifications: Voir mes notifications
- ...
- [0] Quitter

#### Gestion de mes activités

Dans cette section, vous pouvez accéder à vos activités en cours et passées, et en créer de nouvelles.
Suivez les instructions à l'écran pour compléter la tache.

- [a1] Créer un article | [a2] Modifier un article | [a3] Supprimer un article
- [o1] Créer un outil | [o2] Modifier un outil | [o3] Supprimer un outil
- [p1] Créer un projet | [p2] Modifier un projet | [p3] Supprimer un projet
- [4] Voir les activités en cours
- [5] Voir les activités suivies
- ...
- [0] Revenir au menu principal

### Menu principal (Consommateur)


