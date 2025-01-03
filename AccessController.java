package com.centredetri;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class AccessController {

    private TriApplication logicApp;

    // Injecte la logique principale
    public void setLogicApp(TriApplication logicApp) {
        this.logicApp = logicApp;
    }

    // Méthodes pour chaque bouton de navigation
    @FXML
    private void afficherListeDepots(ActionEvent event) {
        System.out.println("Navigation vers la page des dépôts...");
        chargerNouvellePage("ListeDepots.fxml", "Liste des Dépôts", event);
    }

    @FXML
    private void afficherHistoriquePoints(ActionEvent event) {
        System.out.println("Navigation vers la page de l'historique des points...");
        chargerNouvellePage("HistoriquePoints.fxml", "Historique des Points", event);
    }

    @FXML
    private void afficherHistoriqueAchats(ActionEvent event) {
        System.out.println("Navigation vers la page de l'historique des achats...");
        chargerNouvellePage("HistoriqueAchats.fxml", "Historique des Achats", event);
    }

    @FXML
    private void afficherListeCommerces(ActionEvent event) {
        System.out.println("Navigation vers la page des commerces...");
        chargerNouvellePage("ListeCommerces.fxml", "Liste des Commerces", event);
    }

    @FXML
    private void afficherEmplacementsPoubelles(ActionEvent event) {
        System.out.println("Navigation vers la page des emplacements des poubelles...");
        chargerNouvellePage("EmplacementsPoubelles.fxml", "Emplacements des Poubelles", event);
    }

    @FXML
    private void afficherQuantitePoubelle(ActionEvent event) {
        System.out.println("Navigation vers la page des quantités des poubelles...");
        chargerNouvellePage("QuantiteDechets.fxml", "Quantité des Poubelles", event);
    }

    @FXML
    private void afficherCompte(ActionEvent event) {
        System.out.println("Navigation vers la page du compte...");
        chargerNouvellePage("Profils.fxml", "Profil", event);
    }

    @FXML
    private void afficherParametres(ActionEvent event) {
        System.out.println("Navigation vers la page des paramètres...");
        chargerNouvellePage("Parametres.fxml", "Paramètres", event);
    }

    @FXML
    private void deconnexion(ActionEvent event) {
        System.out.println("Déconnexion...");
        chargerNouvellePage("Pagedeconnexion.fxml", "Déconnexion", event);
    }

    // Nouvelle méthode ajoutée pour "Nombre de Bons d'Achat"
    @FXML
    private void afficherNombreBons(ActionEvent event) {
        System.out.println("Affichage du nombre de bons d'achat...");
        // Logique supplémentaire si nécessaire
        // Exemple : afficher une alerte ou rediriger vers une autre page.
    }

    private void chargerNouvellePage(String fxmlFile, String title, ActionEvent event) {
        try {
            // Chemin du fichier FXML
            String cheminFxml = "/com/centredetri/" + fxmlFile;
            System.out.println("Chargement du fichier FXML : " + cheminFxml);

            // Chargement du fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(cheminFxml));
            Parent root = loader.load();

            // Obtenir la scène actuelle et afficher la nouvelle
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement du fichier : " + fxmlFile);
        }
    }
    @FXML
    private Label labelPointsTotal;

    @FXML
    private Label labelNombreBons;

    private Menage menageActuel;
    private CentreDeTri centreDeTri;
    
    public void updateData() {
        if (menageActuel != null) {
            labelPointsTotal.setText("Points disponibles : " + menageActuel.getTotalPoints());
        }

        if (centreDeTri != null) {
            long nbBons = centreDeTri.getListeBonAchats().stream()
                                      .filter(bon -> bon.getMenage().equals(menageActuel))
                                      .count();
            labelNombreBons.setText("Nombre de bons : " + nbBons);
        }
    }

    public void setMenageActuel(Menage menage) {
        this.menageActuel = menage;
    }

}


