package com.centredetri;

import java.util.Objects;

public class Menage {		/*id user, nom adresse*/
    private int idUser;
    private String nom;
    private String adresse;
    private Float totalPoints;
    private String username;
    private String password;
    private float quantiteDechets; // Nouveau champ pour la quantité de déchets
    private int nbBons; // Nouveau champ pour le nombre de bons

    // Constructeurs
    public Menage(int idUser, String username, String password) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.totalPoints = 0f;
        this.quantiteDechets = 0f;
        this.nbBons = 0;
    }

    public Menage(String username, String password) { /*initialise le ménage*/
        this.username = username;
        this.password = password;
        this.totalPoints = 0f;
        this.quantiteDechets = 0f;
        this.nbBons = 0;
    }

    // Getters et setters existants
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Float getTotalPoints() {
        return totalPoints;
    }

    public void addPoints(Float points) {
        this.totalPoints += points;
    }

    // Nouveau getter pour les bons
    public int getNbBons() {
        return nbBons;
    }

    // Nouveau getter pour la quantité de déchets
    public float getQuantiteDechets() {
        return quantiteDechets;
    }

    // Méthode pour calculer les bons à partir des points de fidélité
    public int calculerBons() {
        int bons = (int) (totalPoints / 50); // Exemple : 1 bon = 50 points
        this.nbBons += bons;
        this.totalPoints -= bons * 50; // Réduire les points utilisés quand un bon est crée 
        return bons;
    }

    // Méthode pour ajouter des déchets déposés 
    public void ajouterDechets(float quantite) { /*ajoute les quantités déposés par le menage*/
        this.quantiteDechets += quantite;
    }

    // Vérification des identifiants
    public boolean equals(String username, String password) {
        return this.username.equals(username) && this.password.equals(password); /*Compare les identifiants fournis avec ceux enregistrés pour vérifier si le ménage est valid*/
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Menage other = (Menage) obj;
        return Objects.equals(password, other.password) && Objects.equals(username, other.username);
    }
}


