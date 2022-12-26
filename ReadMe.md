
<!--- inspirer de https://gist.githubusercontent.com/JulienRAVIA/1cc6589cbf880d380a5bb574baa38811/raw/4b124956b45d4bdacf338da137e9c53b392f1560/README-Template.md) --->

# Outil BINECO

--**POUR EXECUTER L'APPLICATION SIMPLEMENT RUN LA FONCITON MAIN DANS LA BRANCHE MAIN!**--

----
## IMPORTANT
> *Ne pas mettre d'espace dans le nom d'utilisateur

> *Si on arrive pas à quitter la session avec "99" , il faut stopper manuelement le code (Sign in et Log in) et vider les fichiers passConsommateur.txt et passResident.txt.

Toujours quitter l'application par le input 99, sinon les fichiers contenant les informations de connection ne sont pas effacés et cela pourrait creer des problemes pour les connections suivantes!

----

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

Pour utiliser l'application | il vous faut exécuter la commande suivante: `java App` (ou autre commande).
Étant un prototype | nous avons inclus un jeu de données afin de tester l'application.
À l'ouverture | vous devez vous connecter en tant que résident ou consommateur. Ceci vous donnera accès au menu principal propre au rôle.

### Données incluses dans l'application
lots de déchets:
- l00,recyclage,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l01,composte,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l02,ordures,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l03,recyclage,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l04,composte,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l05,ordures,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l06,recyclage,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l07,composte,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l08,ordures,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25
- l09,recyclage,YYYY-MM-DD,YYYY-MM-DD,statut_actuel,1000,750,0.25

### Connexion

Pour se connecter à l'application | veuillez utiliser un des identifiants suivants:

- Rôle du résident (3 résidents)
  - Username: xlap| email: x.laperriere@gmail.com| password: mdp123 | statut: VALIDE
  - Username:tyff |email: kim@gmail.com | password: mdp100 | statut: VALIDE
  - Username: lala| email: flory@gmail.com | password: mdp00 | statut: SUSPENDU

- Rôle du consommateur (10 consommateurs)
  - Code: c00 | Nom: SCOURY | Activités: recyclage:2000; composte:1000 | Email: scoury@gmail.com | Adresse: 3225 rue wally | telephone : 5143333331
  - Code: c01 | Nom: POLISHY | Activités: recyclage:2000; composte:500 | Email:polishy@hotmail.com | Adresse: 555 rue westmount | telephone: 43333332
  - Code:  c02 | Nom: RINSY | Activités: recyclage:1000; composte:1500 | Email: rinsy@yahoo.fr | Adresse: 115 rue laurent | telephone :5143333333
  - Code: c03 | Nom:FLUSHY | Activités: recyclage:2000; composte:1000 |dechets:2000 | Email: flushy@gmail.com | Adresse: 3333 rue durant | telephone : 5143333334
  - Code: c04 | Nom: UNSTAINY | Activités: recyclage:1500; composte:500 | Email: unstainy@gmail.com | Adresse: 255 rue cochondufresne  | telephone: 43333335
  - Code: c05 | Nom: WIPPY | Activités: recyclage:750; composte:1000;dechets:5000 | Email: wippy@hotmail.com | Adresse: 1556 rue simon | telephone: 43333336
  - Code: c06 | Nom: CRUBBY | Activités: recyclage:2000 | Email: scrubby@yahoo.ca | Adresse: 444 rue didi | telephone : 5143333337
  - Code: c07 | Nom: CYCLE |Activités: recyclage:2000; composte:1000;dechets:1500 | Email: cycle@outlook.com | Adresse: 666 rue duCode: diable | telephone : 5143333338
  - Code: c08 | Nom: CLEANY |Activités: composte:1750 | Email: cleany@outlook.ca | Adresse: 69 rue ducharme | telephone : 5143333339
  - Code: c09 | Nom: JEDCO | Activités: recyclage:1000; composte:1000 |dechets:1000 | Email:jedco@hotmail.ca |Adresse: 25 rue christmas | telephone: 5143333330

### Menu principal (Résident)

À partir du menu principal | dans le rôle du résident | vous pouvez choisir l'une des options suivantes en tapant le chiffre correspondant.

- [1]: Mes bacs :
  - [1]: Enregistrer un bac
  - [2]: Supprimer un bac
  - [3]: Etat de mes bacs
  - [4]: Trouver un bac
  - [5]: Voir l'historique de mes bacs
- [2]: Trouver un ou plusieurs consommateurs:
  - [1]: Liste des consommateurs
  - [2]: Trouver un consommateur
- [3]: Faire un suivi ecologique:
  - [1]: Etat traitement dechets municipaux
  - [2]: Metriques ecologiques municipales
- [4]: Signaler un probleme à la ville:
  - [1]: Remplacement d'un bac
  - [2]: Demande d'un nouveau bac
- [5]: Mon profil:
  - [1]: Modifier le mot de passe
  - [2]: Modifier courriel
  - [3]: Modifier numero de telephone
  - [4]: Voir mes infos
- ...
- [0] retour au menu
- [99] Quitter

### Menu principal (Consommateur)

À partir du menu principal | dans le rôle du résident | vous pouvez choisir l'une des options suivantes en tapant le chiffre correspondant.
Suivez les instructions à l'écran pour compléter la tache.

- [1]: Trouver un ou plusieurs consommateurs :
  - [1]: Liste des consommateurs
  - [2]: Trouver un consommateur
- [2]: Faire un suivi ecologique:
  - [1]: Etat traitement dechets municipaux
  - [2]: Metriques ecologiques municipales
- [3]: Mon profil:
  - [1]: Modifier le mot de passe
  - [2]: Modifier courriel
  - [3]: Modifier numero de telephone
  - [4]: Voir mes infos
-[4]: Notifier
- [0]: retour au menu
- [99] Quitter

--- 

## À NOTER :
Lorsqu'on recherche des bacs, des consommateurs ou des lots, utiliser les numeros/codes définies ci dessous. Ce sont les données que nous avons générées!

	
### Pour les bacs :
	
Numero des bacs existant (emis par la ville)
- *numerosBac* = {"r00", "r01","r02","d00","d01","d02","co00","co01","co02"}

Informations sur ces bacs (Hash Map) -> (code , {adresse, date emission})

### Pour les consommateurs :

Code des consommateurs existant
- *listeCons* = {"c00","c01","c02","c03","c04","c05","c06","c07","c08","c09"}

Code des consommateurs disponibles au signUp
- *listeConsDispo* = {"c10","c11","c12","c13","c14","c15","c16","c17","c18","c19"}

Information sur les consommateurs (Hash Map) -> (code, {activité1:capacité, activité2:capacité}
- Noter qu'un consommateur peut avoir de 1 a 3 activités

### Pour les lots :
	
Liste des lots existants (premier caractere est L, pas 1)
- *listeLots* = {"l00","l01","l02","l03","l04","l05","l06","l07","l08","l09"}
    
----
## Instructions

À chaque fois que vous exécuter le programme,
### 1. S'inscrire à la page Sign In en tant que résident ou consommateur
```
Resident :
		-Enregistrement du bac : numeros valide sont r00,r01,r02,d00,d01,d02,co00,co01,co02
		-Si le numero ne correspond pas on vous demande de re entrer le numero

Consommateur :
		-Code : les codes valides seront c10,c11......c19.
		-Les codes c00...c09 sont 'deja enregistrés' dans notre systeme (fausses donnees)
```
### 2. Entrer vos informations:
1. **Important:** VOTRE MOT DE PASSE DOIT CONTENIR DES *LETTRES* **ET** DES *CHIFFRES*

   - Non valide:

    ![](images/notAccepted.jpg)
    ![](images/notAccepted(1).jpg)
    ![](images/notAccepted(2).jpg)

   - Valide:

    ![](images/accepted.jpg)
### 3. Se connecter avec le ***même*** nom d'utilisateur et mot de passe. 
Si les infos ne correspondent pas, on revoie le formulaire de connection
### 4. Choisir les options menus.
   - À NOTER:
        ```
        MENU RESIDENT: 
            **Appuyer sur 0 pour revenir au MENU a tout moment (apres les formulaires).
            -Au bas de la page sont vos bacs deja enregistrés


        MENU CONSOMMATEUR :
            -Moins de fonctionnalités puisque il n'y en avait pas vraiment de définies.

        ```
    
### 5. *Quitter le programme en appuyer 99*.
---
## Échéancier
![Echeancier](/images/echeancier.JPG )

---
## Site mapping
![](images/pageAccueil.jpg)
![](images/menuConsommateur.jpg)
![](images/menuResident.jpg)

---
## P.S
-A cause du manque de temps, le prototype ne suit pas le diagramme de classe et les diagrammes de séquences.

---
## Auteurs

- Kim Trinh (20215539)
- Xavier Laperriere (20157146)
- Eed Flory Jean-Baptiste (20168335)
- Miliya Ai (20180783)



