package com.centredetri;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger la page de connexion
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pagedeconnexion.fxml"));
            Parent root = loader.load();

            // Configuration de la scène
            primaryStage.setTitle("Connexion");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();

            // Initialiser les données métier
            initialiserDonnees();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialiserDonnees() {
        // Initialisation de la logique métier
        CentreDeTri centreDeTri = new CentreDeTri("epita", "6 rue du faubourg st george");

        // Créer un compte
        Menage menage = new Menage("user1", "password1");
        centreDeTri.ajouterMenage(menage.getUsername(), menage.getPassword());
        System.out.println("Compte créé pour : " + menage.getUsername());

        // Connexion au compte
        boolean loginSuccess = centreDeTri.login(menage.getUsername(), menage.getPassword());
        if (loginSuccess) {
            System.out.println("Connexion réussie pour : " + menage.getUsername());
        } else {
            System.out.println("Échec de la connexion.");
        }

        // Ajouter une poubelle
        List<TypeDechet> listeDechets = new ArrayList<>();
        listeDechets.add(TypeDechet.PLASTIQUE);
        centreDeTri.ajouterPoubelle(listeDechets, "rue St Lazarre");

        // Ajouter un contrat
        String dateStr = "04/12/2027";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
        centreDeTri.ajouterContratEnCours(parsedDate, "Machine à pain");

        // Effectuer des dépôts
        Poubelle poubelle = centreDeTri.getListePoubelles().get(0);
        poubelle.ajouterDepot(menage, 1f, TypeDechet.PAPIER);
        System.out.println("Points après premier dépôt : " + menage.getTotalPoints());

        poubelle.ajouterDepot(menage, 190f, TypeDechet.PLASTIQUE);
        poubelle.ajouterDepot(menage, 200f, TypeDechet.PLASTIQUE);

        // Afficher les points finaux
        System.out.println("Points totaux après tous les dépôts : " + menage.getTotalPoints());
    }

    public static void main(String[] args) {
        launch(args); // Lancer JavaFX
    }
}


