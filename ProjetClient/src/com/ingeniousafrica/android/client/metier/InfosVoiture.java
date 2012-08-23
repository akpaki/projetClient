package com.ingeniousafrica.android.client.metier;

import java.io.Serializable;

public class InfosVoiture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Creation des variables locales
	private String marque;
	private String couleur;
	private String vitesse;
    private String a;
	
	public InfosVoiture() {
	}

	public InfosVoiture(String marque, String couleur, String vitesse) {
		this.marque = marque;
		this.couleur = couleur;
		this.vitesse = vitesse;
	}
	
	public InfosVoiture(String a, String marque, String couleur, String vitesse) {
		super();
		this.marque = marque;
		this.couleur = couleur;
		this.vitesse = vitesse;
	}

	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public String getVitesse() {
		return vitesse;
	}


	public void setVitesse(String vitesse) {
		this.vitesse = vitesse;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	

}
