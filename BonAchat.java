package com.centredetri;

import java.time.LocalDate;

public class BonAchat {

	private String nom; 
	private Integer valeur;
	private Menage menage; 
	private LocalDate date;
	private String commerce;
	
	public BonAchat(String nom, Menage menage, String commerce, Integer valeur) {
		this.nom = nom; 
		this.valeur = valeur; 
		this.menage = menage; 
		this.commerce = commerce; 
		this.date = LocalDate.now(); 
	}
	

	
	
	// Getter et setter 

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	public Menage getMenage() {
		return menage;
	}

	public void setMenage(Menage menage) {
		this.menage = menage;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCommerce() {
		return commerce;
	}

	public void setCommerce(String commerce) {
		this.commerce = commerce;
	}
	
	
}
