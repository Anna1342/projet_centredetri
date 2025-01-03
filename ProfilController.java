package com.centredetri;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfilController {

    @FXML
    private Label nomLabel;

    @FXML
    private Label adresseLabel;

    @FXML
    private Label pointsLabel;

    @FXML
    private Label bonsLabel;

    private TriApplication logicApp;

    @FXML
    public void initialize() {
        // Les données seront passées via setLogicApp
    }

    public void setLogicApp(TriApplication logicApp) {
        this.logicApp = logicApp;

        // Charger les informations utilisateur
        Menage menage = logicApp.getMenageActuel();
        if (menage != null) {
            nomLabel.setText("Nom : " + menage.getNom());
            adresseLabel.setText("Adresse : " + menage.getAdresse());
            pointsLabel.setText("Points totaux : " + menage.getTotalPoints());
            bonsLabel.setText("Bons d'achat : " + menage.getNbBons());
        }
    }

    @FXML
    private void retour() {
        System.out.println("Retour à la page principale.");
        // Ajouter la logique pour revenir à l'écran précédent
    }
}
