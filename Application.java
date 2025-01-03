package com.centredetri;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	private CentreDeTri centreDeTri;
	private Menage menageActuel;
	public static Integer pointsParKg = 10;
	private List<BonAchat> listeBonAchats = new ArrayList<>();
	private final Scanner scanner; // Scanner partagé à l'échelle de la classe

	// Constructor
	public Application(CentreDeTri centreDeTri) {
		this.centreDeTri = centreDeTri;
		this.scanner = new Scanner(System.in); // Initialisation du scanner
	}

	// Créer un compte
	public void creerCompte() {
		System.out.print("You choose to create your Account!\nEnter your username: ");
		String username = scanner.nextLine();
		List<Menage> listeMenages = this.centreDeTri.getListeMenages();

		// Vérifier que le nom d'utilisateur n'existe pas déjà
		for (Menage menage : listeMenages) {
			if (menage.getUsername().equals(username)) {
				System.out.println("ERROR: Your chosen username already exists");
				return;
			}
		}

		// Demander le mot de passe de l'utilisateur
		System.out.print("Enter your password: ");
		String password = scanner.nextLine();
		centreDeTri.ajouterMenage(username, password);
		System.out.println("Account created successfully!");
	}

	// Connexion
	public void login() {
		System.out.print("Enter your username: ");
		String username = scanner.nextLine();

		// Demander le mot de passe de l'utilisateur
		System.out.print("Enter your password: ");
		String password = scanner.nextLine();

		List<Menage> listeMenages = this.centreDeTri.getListeMenages();

		for (Menage menage : listeMenages) {
			if (menage.equals(username, password)) {
				this.menageActuel = menage;
				System.out.println("You are successfully logged in!");
				return;
			}
		}

		System.out.println("ERROR: Invalid username or password");
	}

	// Déconnexion
	public void logout() {
		this.menageActuel = null;
		System.out.println("You are successfully logged out");
	}

	public float consulterPointsTotal() {
		return this.menageActuel.getTotalPoints();
	}

	// Méthode pour afficher la liste des dépôts du ménage connecté
	public List<Depot> afficherListeDepots() {
		return this.centreDeTri.afficherListeDepotsMenage(this.menageActuel);
	}

	public List<String> afficherListeCommerces() {
		List<String> listeCommerces = new ArrayList<>();
		for (Contrat contrat : this.centreDeTri.getListeContratsEnCours()) {
			if (contrat.getDateFin().isBefore(LocalDate.now())) {
				this.centreDeTri.ajouterContratPasse(contrat);
				this.centreDeTri.supprimerContratEnCours(contrat);
			} else if (contrat.getDateFin().isAfter(LocalDate.now())) {
				listeCommerces.add(contrat.getCommerce());
			}
		}
		return listeCommerces;
	}

	public BonAchat convertirPointsEnBon(String commerce) {
		Float nbPoints = this.menageActuel.getTotalPoints();

		if (nbPoints >= 50) {
			Integer valeurBon = Math.round(nbPoints / 50);

			this.menageActuel.addPoints(Float.valueOf(-valeurBon * 50));

			String nomBonAchat = "Voucher for " + commerce + " - " + valeurBon * 10 + "$";
			BonAchat bonAchat = new BonAchat(nomBonAchat, this.menageActuel, commerce, valeurBon * 10);

			this.listeBonAchats.add(bonAchat);

			System.out.println("Voucher created successfully!");
			return bonAchat;
		} else {
			System.out.println(
					"ERROR: You don't have enough points to generate a voucher. Points available: " + nbPoints);
			return null;
		}
	}

	public List<BonAchat> afficherNbBonAchat() {
		List<BonAchat> listeBonAchatsMenage = new ArrayList<>();
		for (BonAchat bonAchat : this.listeBonAchats) {
			if (bonAchat.getMenage().equals(this.menageActuel)) {
				listeBonAchatsMenage.add(bonAchat);
			}
		}
		return listeBonAchatsMenage;
	}

	public Menage getMenageActuel() {
		return menageActuel;
	}

	public void setMenageActuel(Menage menageActuel) {
		this.menageActuel = menageActuel;
	}

	// Méthode pour fermer le Scanner proprement si nécessaire
	public void closeScanner() {
		scanner.close();
		System.out.println("Scanner closed.");
	}
}
