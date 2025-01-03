package com.centredetri;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreationCompteController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button createAccountButton;

    @FXML
    private Label errorLabel;

    private CentreDeTri centreDeTri;

    public void setCentreDeTri(CentreDeTri centreDeTri) {
        this.centreDeTri = centreDeTri;
    }

    @FXML
    private void handleCreateAccountClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs.");
            return;
        }

        boolean usernameExists = centreDeTri.getListeMenages()
                                            .stream()
                                            .anyMatch(menage -> menage.getUsername().equals(username));
        if (usernameExists) {
            errorLabel.setText("Nom d'utilisateur déjà utilisé.");
            return;
        }

        centreDeTri.ajouterMenage(username, password);
        errorLabel.setText("Compte créé avec succès !");
        errorLabel.setStyle("-fx-text-fill: green;");

        // Fermer la fenêtre après la création
        Stage stage = (Stage) createAccountButton.getScene().getWindow();
        stage.close();
    }
}


