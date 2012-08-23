package com.ingeniousafrica.android.client.metier;

import java.io.Serializable;
import java.util.ArrayList;


public class DataRecupClientVoiture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<InfosClient> client;
	private ArrayList<InfosVoiture> voiture;
	
	public ArrayList<InfosClient> getClient() {
		return client;
	}
	
	public void setClients(ArrayList<InfosClient> client) {
		this.client = client;
	}
	
	
	public ArrayList<InfosVoiture> getVoiture() {
		return voiture;
	}
	public void setVoiture(ArrayList<InfosVoiture> voiture) {
		this.voiture = voiture;
	}
	
	
	

}
