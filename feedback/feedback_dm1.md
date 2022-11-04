# Feedback DM1

> **KFE**  
> Kim TRINH (20215539)  
> Miliya AI (20180783)  
> Eed Flory JEAN-BAPTISTE (20168335)  
> Xavier LAPERRIERE (20157146)  

## Cadre du projet

- Le cadre du projet est défini de façon sommaire
  - Aucune mention des objectifs
  - Aucune mention de Bineco
- L'échéancier est bien organisé et présente suffisamment d'informations pour le jalon 1, mais ne s'étend sur toute la durée prévue du projet.
  - Les éléments connus ou planifiés à date pour les jalons futurs doivent aussi être présentés
- Les fonctionnalités sont bien priorités dans l'ensemble
  - *Afficher les métriques écologiques* est une fonctionnalité essentielle
  - *Trouver un consommateur* est une fonctionnalité importante
  - *Voir l’était de traitement des déchets municipaux* est une fonctionnalité nécessaire

## Compréhension du domaine

Les questions de compréhension devraient être dans cette section

### Glossaire

Bonne couverture des termes clés du domaine, mais certaines définitions manquent de détails contextuels.

- **Résident** devrait être défini avec plus de précision (les consommateurs sont aussi des utilisateurs)
- **Consommateur** est une entité exploitant les déchets et un utilisateur de Bineco
- **Ville de Montréal** est le système administratif municipal traitant les déchets. Elle fournit tout le matériel nécessaire (poubelles, capteurs, données de suivi)
- **Activités** pourraient être plus détaillés
- **Capteurs** n'est pas mentionné

## Modélisation du domaine

### Cas d'utilisation

- Résident et Consommateur peuvent être généralisés pour la connexion
- Acteur de base bien identifié, mais il manque les capteurs
  - Capteur: les capteurs communiquent directement avec le système pour envoyer les données du contenu des bacs
- CU manquant: Supprimer un bac, Modification du profil du résident ou consommateurs
- CU *S'inscrire comme résident* pourrait faire un include avec *Enregistrer mes bac*

### Scénarios

- Les scénarios ne correspondant pas (tous) aux CUs déclarés dans le diagramme
  - Page d'accueil de l'outil BINECO
  - S'inscrire
  - Enregistrer des bacs
- Aucune précondition ou postcondition n'est présentée
  - Pour la majorité des CUs, l'utilisateur doit être connecté
  - Pour le CU *Signaler un problème*, il faut s'assurer que le message a bien été transmis (postcondition)
- De nombreux CUs manquent de détails (trop simple)
  - Signaler un problème à la ville
    - Choix du type de problème
    - Confirmation du système (il faut décrire ce que l'acteur perçoit dans son interaction)
  - Voir les activités que je maintiens
    - Navigation à travers les activités
    - Affichage des détails d'une activité
  - Voir l'état de traitement des déchets municipaux
    - Que se passe-t-il lorsqu'on choisit une des options (a, b, c)
- Les étapes doivent alterner entre le système et les acteurs. Éviter d'avoir plus de 2 étapes successives pour le même acteur.

## Analyse

Une bonne analyse, mais un peu sommaire.

### Risques

Les risques sont clairs et bien argumentés. Il faut aussi penser à ce qui pourrait entraver le projet lui-même (loi sur l'exploitation des données au Québec, temps alloué pour réaliser le projet).

### Exigences non-fonctionnelles

Les exigences non-fonctionnelles sont assez précises, mais manque de justification et d'attache à un aspect (caractéristique, qualité) de l'application (sécurité, performance, utilisabilité, fiabilité...)

- **Base de donnée encrypter**: Quelles informations personnelles? Est-ce pertinent ici d'encrypter ces informations?
- **Temps de réponse rapide avec l’api**: Donnez un ordre de grandeur (que veux dire rapide?)
- 3 et 5 se rapportent à l'utilisabilité

### Ressources

- Très sommaire.
  - Que veux dire appareil dans la liste des matériels nécessaires?
  - La solution de stockage devrait être plus élaborée. Il y a toujours une base de données dans un système. Quelles sont les particularités de celle-ci?

### Contraintes

- Assez court, mais correcte.
- Typo: Contraintes *physiques* -> Contraintes *conceptuelles*
- Les contraintes ne sont pas suffisamment expliquées. Quels rôles jouent-elles dans le contexte de l'application?

### Proposition et choix de métriques

#### Niveau résidentiel (usage des bacs)

- **Poids de chaque activité (kg) dans un intervalle de temps défini**
  - Le poids pourrait être une base de calcul pour une métrique, mais ne constitue pas une métrique à lui seul. 
  - La métrique doit être facile d'interprétation. Ici on pourrait présenter l'interprétation du poids relatif de chaque activité.
- **Pourcentage de chaque activité (compostage, recyclage, ordures) par rapport à une autre selon l’intervalle de temps défini**
  - Oui, celle-ci pourrait être complémentée par les préférences du résident pour plus de personnalisation
- **Portions de matière recyclés/compostés/jetés comparés**
  - Pas certain de comprendre cette métrique. Est-ce différent du pourcentage de chaque activité?

#### Niveau municipal (traitement des déchets)

- **Proportion de chaque activité (compostage, recyclage, ordures) par rapport à la ville**
  - OK
- **Pourcentage de déchets envoyés dans le site d'enfouissement/incinération, de produits recyclés, matériel composté**
  - Ajoutez des éléments d'interprétation, comme des paliers.
- **Portions de matières recyclées/compostées/jetés comparés**
  - Similaire à la proportion de chaque activité.

### Prototype

Bien, mais manque de diversification.

- Aucune vue ne montre les métriques.
- Aucune vue propre au consommateur.
- Montrer le rôle de l'utilisateur actif. J'assume ici que le prototype se concentre sur la vue du résident.

## Rapport

- Bon rapport avec quelques problèmes de style
  - Évitez les trois petits points `...` ou `etc`
  - Assurez-vous de commencer vos phrases par une majuscule.
- Manque parfois de phrase complète et de justifications.
- Un rapport est aussi votre synthèse du travail, donc vous pouvez y ajouter vos recommandations.

## Git

Très bon usage de Git jusqu'à présent.
