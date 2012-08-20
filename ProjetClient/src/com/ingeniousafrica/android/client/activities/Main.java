package com.ingeniousafrica.android.client.activities;

import com.ingeniousafrica.android.client.R;
import com.ingeniousafrica.android.client.metier.InfosClient;
import com.ingeniousafrica.android.client.metier.InfosVoiture;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Main extends Activity implements OnClickListener{
	
	// Définition des variables globales pour contenir nos controles
	EditText nom;
	EditText prenom;
	Spinner sp_couleur;
	Spinner sp_vitesse;
	Button button;
	
	
	String couleur;
	String vitesse;
	
	 /** Creation de tableau du choix pour les options */
    private static final String Scouleurs [] = {"Blanche", "Noire", "Bleue", "Verte", "Rouge"};
    private static final String Svitesses [] = {"Automatique", "Mécanique"};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     // creation des accesseurs vers nos controles
        nom = (EditText) findViewById(R.id.editText1);
        prenom = (EditText) findViewById(R.id.activity_main_editext_prenom);
        button = (Button)findViewById(R.id.activity_main_button_valider);

		/** Mettons en place un ecouteur d evenement sur notre controle button */
		button.setOnClickListener(this);
        
        sp_couleur = (Spinner) findViewById(R.id.activity_main_spinner_couleur);
		ArrayAdapter<String> color_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Scouleurs);
		color_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_couleur.setAdapter(color_adapter);
        sp_couleur.setOnItemSelectedListener(new OnItemSelectedListener() {
        	public void onItemSelected(
					AdapterView<?> parent, View view, int position, long id) {
				int item = sp_couleur.getSelectedItemPosition();
				couleur = Scouleurs[item];
				
				showToast("La couleur choisie est : " + couleur);
			
				//showToast("La vitesse choisie est : " + choix_couleur);
				//showToast("Spinner2: position=" + position + " id=" + id);
			}

			public void onNothingSelected(AdapterView<?> parent) {
				//showToast("Spinner2: unselected");
			}
        	
		});
        
        sp_vitesse = (Spinner) findViewById(R.id.activity_main_spinner_boite_de_vitesse);
        ArrayAdapter<String> vitesse_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Svitesses);
        vitesse_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_vitesse.setAdapter(vitesse_adapter);
        sp_vitesse.setOnItemSelectedListener(new OnItemSelectedListener() {
        	public void onItemSelected(
        			AdapterView<?> parent, View view, int position, long id){
        		int item = sp_vitesse.getSelectedItemPosition();
				vitesse = Svitesses[item];
				
				showToast("La vitesse choisie est : " + vitesse);
        		
        	}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
       
    }
    
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_main_button_valider:
			
			//Creation d un objet de type Bundle
			Bundle objetbunble = new Bundle();

			//Instancions un objet client pour les infos du client
			InfosClient client = new InfosClient();
			
			//Instancions un objet voiture pour les infos de la nouvelle voiture
			InfosVoiture voiture = new InfosVoiture();

			//
			client.setNom(nom.getText().toString());
			client.setPrenom(prenom.getText().toString());
			
			//
			voiture.setCouleur(couleur);
			voiture.setVitesse(vitesse);
    		

			//Mettons les objets client et voiture dans l'objet bundle afin de pouvoir le recuperer dans l'autre activity
			objetbunble.putSerializable("client", client);
			objetbunble.putSerializable("voiture", voiture);

			Intent intent = new Intent(this, FabricVoiture.class);
			//Nom metons l objet de type bundle dans l'intent
			intent.putExtras(objetbunble);
			startActivity(intent);
			
			break;

		}
		
		
	}
	
	protected void showToast(String message) {
		
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

	} 
	/** Fonction appelée Lorsque l activité de visible a l user */
	@Override
	protected void onStart() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("","onStart");
		super.onStart();
	}

	/** Fonction appelée lorsque l activité devien reellemet active et en cours d utilisation par l user */
	@Override
	protected void onResume() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onResume");
		super.onResume();
	}

	/** Fonction appelée lorsque l activité est en pause */
	@Override
	protected void onPause() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onPause");
		super.onPause();
	}

	/** Fonction appelée lorsque l activité est stopé par un autre programme du systeme */
	@Override
	protected void onStop() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onStop");
		super.onStop();
	}


	/** Fonction appelée a la fin de notre activity */
	@Override
	protected void onDestroy() {
		/** Ajoutons un "log" pour voir si cette fonction a été appelée et a quel moment */
		Log.i("", "onDestroy");
		super.onDestroy();
	}
}