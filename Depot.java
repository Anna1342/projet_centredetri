package com.centredetri;

import java.time.LocalDate;

public class Depot {
    private LocalDate heureDepot;
    private TypeDechet typeDechet; 
    private Float poids;
    private Float ptGagne;
    private Menage menage;
    private Poubelle poubelle;

    // Getters et setters
    public LocalDate getHeureDepot() { /*depot effecuté dans un ménage, par une poubelle*/
        return heureDepot;
    }

    public void setHeureDepot(LocalDate heureDepot) { /*va enregistrer la date du depot effectué, dans l'appli qd le menage a accès à sa liste des dépots ils sont classés par date */
        this.heureDepot = heureDepot;
    }

    public Float getPoids() { /*pour chaque dépot son poids, le type du dechet (plastique etc grace à l'énum) */
        return poids;
    }

    public void setPoids(Float poids) {
        this.poids = poids;
    }

    public Float getPtGagne() {
        return ptGagne;
    }

    public void setPtGagne(Float ptGagne) { /*et si le point est gagné ou perdu pour ce depot*/
        this.ptGagne = ptGagne;
    }

    public Menage getMenage() { /*il y a toujours le ménage ayant effectué le dépot*/
        return menage;
    }

    public void setMenage(Menage menage) {
        this.menage = menage;
    }

    public Depot(Float poids, TypeDechet typeDechet, Menage menage, Poubelle poubelle, Float ptGagne) { /*poubelle ds lequel le depot a été effectué*/
        this.poids = poids;		/*on initialise le depot par le constructeur*/
        this.typeDechet = typeDechet;
        this.heureDepot = LocalDate.now(); /*date actuelle au moment de l'instancation*/
    }

    // Nouvelle méthode getDescription
    public String getDescription() {
        return "Dépôt de " + poids + " kg de " + typeDechet + " par " + (menage != null ? menage.getUsername() : "inconnu") + ", points gagnés: " + ptGagne;
    }
}

