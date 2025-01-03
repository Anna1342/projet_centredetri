
# Gestion de Tri Sélectif

## Description du Projet

Ce projet a pour objectif de développer un système de gestion de tri sélectif, impliquant des poubelles intelligentes, 
des utilisateurs récompensés pour leur tri correct, et des partenariats avec des commerces pour un impact écologique positif.

---

## Grandes Lignes du Projet

1. **Tri Sélectif Intégré :**
   - Poubelles connectées pour séparer les déchets : verre, plastique, carton, métal.
   - Accès contrôlé par des comptes utilisateur.

2. **Récompenses Utilisateur :**
   - Attribution de points pour le tri correct.
   - Conversion des points en bons d'achat ou réductions.

3. **Partenariats :**
   - Collaboration avec des commerces pour échanger les points contre des bon d'achats ou réductions.

4. **Analyse Statistique :**
   - Suivi et prédiction des dépôts pour optimiser la gestion logistique.

---

## Fonctionnalités des Classes

### Classes Principales

1. **CentreDeTri**
   - Gestion des poubelles et collecte des déchets.
   - Génération de statistiques et rapports.
   - Connaissance de la liste des dépots de chaque ménage 

2. **PoubelleIntelligente**
   - Identifie les utilisateurs.
   - Mesure la quantité des déchets déposés et la qualité du tri.
   - Notifie le centre lorsqu'elle est pleine.

3. **Utilisateur**
   - Possède un compte pour visualiser les points.
   - Historique des dépôts disponibles.
   - Historique des bons d'achats disponibles 
   - Possibilité de convertir ses points en bons d'achats 

4. **Commerce**
   - Réalise un contrat avec le centre de tri.
   - Propose des réductions aux utilisateurs.

5. **Dechets**
   - Catégorisation (plastique, verre, carton, métal).

### Tests
- Classes de test pour valider les fonctionnalités : **MainTest.java**.

---

## Guide d'Utilisation

Pré-requis au lancement du projet: instanciation d'un centre de tri et d'une application 

Afin de lancer les tests, lancer la classe `Main.java`. 


### Pré-requis
- **Java 18** ou supérieur.

---

## Licence

Ce projet est sous licence [MIT](LICENSE).

---

## Auteurs

- **ANTOGNELLI Pauline**
- **FARCHAK Marouane**
- **TESTART Léandre**
- **SZWARCBART Anna**

