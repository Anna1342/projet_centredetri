package com.centredetri;

import java.time.LocalDate;

public final class Contrat {
	private LocalDate dateDebut = LocalDate.now(); 
	private LocalDate dateFin;
	private String categorieProduits;
	private String commerce;

	public Contrat(LocalDate dateFin, String categorieProduits) {
		this.dateFin = dateFin;
		this.categorieProduits = categorieProduits;
		this.dateDebut = LocalDate.now();	
		}

    
    // Getters et setters
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	
	
	public String getCommerce() {
		return commerce;
	}


	public void setCommerce(String commerce) {
		this.commerce = commerce;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	
	public LocalDate getDateFin() {
		return dateFin;
	}
	
	
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	public String getCategorieProduit() {
		return categorieProduits;
	}
	

	public void setCategorieProduit(String categorieProduit) {
		this.categorieProduits = categorieProduit;
	}}
