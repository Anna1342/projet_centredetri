package com.centredetri;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CentreDeTri {

    private String nom;
    private String adresse;
    private List<Menage> listeMenages = new ArrayList<Menage>();
    private List<Contrat> listeContratsPasses = new ArrayList<Contrat>();
    private List<Contrat> listeContratsEnCours = new ArrayList<Contrat>();
    private List<Poubelle> listePoubelles = new ArrayList<Poubelle>();
    private List<Poubelle> listePoubellesPleines = new ArrayList<Poubelle>();
    
    // Constructeur
    public CentreDeTri(String nom, String adresse) {	
        this.nom = nom;
        this.adresse = adresse;
    }
    
 // Méthodes pour gérer la liste des ménages
    public List<Menage> getListeMenages() {
        return listeMenages;
    }
    
    public void ajouterPoubellepleine(Poubelle poubelle) {
    	this.listePoubellesPleines.add(poubelle);
    }
    
    public void ajouterMenage(String username, String password) {
    	Menage menage = new Menage(listeMenages.size(), username, password);//TODO : Problems of ids collisions
        this.listeMenages.add(menage);
        System.out.println(menage.getUsername());
    }

    // Méthode pour ajouter une poubelle
    public void ajouterPoubelle(List<TypeDechet> listeTypesDechets, String emplacement) {
    	Poubelle poubelle = new Poubelle(listePoubelles.size(), listeTypesDechets, emplacement, this);  //TODO : Problems of ids collisions
        this.listePoubelles.add(poubelle);
    }

    // Méthode pour retirer une poubelle
    public void retirerPoubelle(Poubelle poubelle) {
        //this.listePoubelles.removeIf(poubelle -> poubelle[0].equals(String.valueOf(idPoubelle)));
    	this.listePoubelles.remove(poubelle); 
    	poubelle.setCentredetri(null);// don't forget to unlink the trash in the object
    }

	// Méthode pour collecter les déchets
    public void collecterDechets(){
    	for (Poubelle poubelle : this.listePoubellesPleines)
    	{
    		poubelle.vider();
    	}
    	this.listePoubellesPleines.clear();
    }

    public void StatNbPoints() {
        int totalPoints = 0;
    	for (Menage menage : listeMenages)
    	{
    		totalPoints += menage.getTotalPoints();
    	}
    	System.out.println("Nombre total de points :" + totalPoints);
    }

    public void StatNbMenages() {
        if (listeMenages.size() == 0)
        {
        	System.out.println("Le centre de tri ne compte aucun ménage.");
        }
        else
        {
        	System.out.println("Le centre de tri compte " + listeMenages.size() + " ménage(s).");
        }
    }

    // Méthodes pour gérer les commerces partenaires
    
    public void ajouterContratEnCours(LocalDate dateFin, String categorieProduits) {
    	Contrat contrat = new Contrat(dateFin, categorieProduits); 
    	this.listeContratsEnCours.add(contrat);
    }
    
    public void ajouterContratPasse(Contrat contrat) {
    	this.listeContratsPasses.add(contrat);
    }
    
    public void supprimerContratEnCours(Contrat contrat) {
    	this.listeContratsEnCours.remove(contrat);
    }
    
    
    // Method to have a list of depots of a menage 
    
    
    public List<Depot> afficherListeDepotsMenage(Menage menage){
    	List<Depot> listeDepots = new ArrayList<Depot>();
    	for (Poubelle poubelle: listePoubelles) {
    		for (Depot depot: poubelle.getListeDepots()) {
    			if (depot.getMenage().equals(menage)) {
    				listeDepots.add(depot); 
    			}
    		}
    	} return listeDepots;
    }
    public boolean login(String username, String password) {
        for (Menage menage : listeMenages) {
            if (menage.getUsername().equals(username) && menage.getPassword().equals(password)) {
                return true; // Connexion réussie
            }
        }
        return false; // Connexion échouée
    }

	public List<Contrat> getListeContratsPasses() {
		return listeContratsPasses;
	}

	public void setListeContratsPasses(List<Contrat> listeContratsPasses) {
		this.listeContratsPasses = listeContratsPasses;
	}

	public List<Contrat> getListeContratsEnCours() {
		return listeContratsEnCours;
	}

	public void setListeContratsEnCours(List<Contrat> listeContratsEnCours) {
		this.listeContratsEnCours = listeContratsEnCours;
	}


// Méthodes pour obtenir et modifier le nom
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

// Méthodes pour obtenir et modifier l'adresse
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}	
	
    public List<Poubelle> getListePoubelles() {
		return listePoubelles;
	}

	public void setListePoubelles(List<Poubelle> listePoubelles) {
		this.listePoubelles = listePoubelles;
	}

	public List<Poubelle> getListePoubellesPleines() {
		return listePoubellesPleines;
	}

	public void setListePoubellesPleines(List<Poubelle> listePoubellesPleines) {
		this.listePoubellesPleines = listePoubellesPleines;
	}
}

