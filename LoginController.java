package com.centredetri;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private Label errorLabel;

    private CentreDeTri centreDeTri; // Référence au centre de tri

    @FXML
    public void initialize() {
        // Initialiser le contrôleur avec l'objet CentreDeTri
        centreDeTri = new CentreDeTri("epita", "6 rue du faubourg st george");
    }

    @FXML
    private void handleLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs.");
            return;
        }

        // Vérifier les informations de connexion
        boolean success = centreDeTri.login(username, password);
        if (success) {
            errorLabel.setText("Connexion réussie !");
            errorLabel.setStyle("-fx-text-fill: green;");

            // Charger la scène après une connexion réussie
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("page2Projet.fxml")); // Fichier FXML de la page suivante
                Parent root = loader.load();

                // Passer le `CentreDeTri` au `AccessController`
                AccessController accessController = loader.getController();
                accessController.setLogicApp(new TriApplication(centreDeTri));

                // Obtenir la scène actuelle et la remplacer
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600)); // Taille de la nouvelle page
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                errorLabel.setText("Erreur lors du chargement de la page suivante.");
                errorLabel.setStyle("-fx-text-fill: red;");
            }
        } else {
            errorLabel.setText("Nom d'utilisateur ou mot de passe incorrect.");
            errorLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleCreateAccountClick() {
        try {
            // Charger le fichier FXML de la page de création de compte
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PageCreationCompte.fxml"));
            Parent root = loader.load();

            // Passer l'objet CentreDeTri au contrôleur
            CreationCompteController creationController = loader.getController();
            creationController.setCentreDeTri(centreDeTri);

            // Afficher la page de création de compte dans une nouvelle fenêtre
            Stage stage = new Stage();
            stage.setTitle("Créer un compte");
            stage.setScene(new Scene(root, 400, 300)); // Taille de la fenêtre de création de compte
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Erreur lors de l'ouverture de la page de création de compte.");
            errorLabel.setStyle("-fx-text-fill: red;");
        }
    }
}

