package com.ingeniousafrica.android.client.activities;



import java.util.ArrayList;

import com.ingeniousafrica.android.client.R;
import com.ingeniousafrica.android.client.metier.DataRecupClientVoiture;
import com.ingeniousafrica.android.client.metier.InfosClient;
import com.ingeniousafrica.android.client.metier.InfosVoiture;
import com.ingeniousafrica.android.client.metier.SerialisationClientVoiture;
import com.ingeniousafrica.android.client.metier.VoitureAdapter;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class ParcVoiture extends Activity implements OnClickListener{
	
	ListView list_new_voiture;
	ListView list_voiture;
	TextView nom_cli;
	TextView prenom_cli;
	Button button_retour_client;
	DataRecupClientVoiture data;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parc_voiture);
        
        Bundle objetbunble  = this.getIntent().getExtras();
        
        // Recupèrons l objet client 
        InfosClient client = (InfosClient)objetbunble.getSerializable("client");
        
        nom_cli = (TextView)findViewById(R.id.activity_parc_voiture_client_nom);
        
        prenom_cli = (TextView)findViewById(R.id.activity_parc_voiture_client_prenom);
        
        nom_cli.setText(client.getNom());
        
        prenom_cli.setText(client.getPrenom());
        
     // Recupèrons l objet voiture 
        InfosVoiture voiture = (InfosVoiture)objetbunble.getSerializable("voiture");
        ArrayList<InfosVoiture> item_nouveau_voiture = new ArrayList<InfosVoiture>();
        
        item_nouveau_voiture.add(voiture);
        
        VoitureAdapter newAdapter = new VoitureAdapter(this,R.layout.item_nouveau_voiture,item_nouveau_voiture);
        
        list_new_voiture = (ListView)findViewById(R.id.activity_parc_voiture_listview);
        
        list_new_voiture.setAdapter(newAdapter);
        
        button_retour_client = (Button) findViewById(R.id.activity_parc_voiture_button_retour);
        button_retour_client.setOnClickListener(this);
        
        data = (DataRecupClientVoiture) SerialisationClientVoiture.readData(this, "Donnees");
        
        // Verification 
        if(data != null){
        	
        	VoitureAdapter adapter = new VoitureAdapter(this,R.layout.item_nouveau_voiture,data.getVoiture());
        	
        	list_voiture = (ListView)findViewById(R.id.activity_parc_voiture_listview);
        	
        	list_voiture.setAdapter(adapter);

        	data.getVoiture().add(voiture);
	        
	        SerialisationClientVoiture.saveData(this, "Donnees", data, false);
        }else{
        	data = new DataRecupClientVoiture();
        	
	        data.setVoiture(item_nouveau_voiture);
	        
	        SerialisationClientVoiture.saveData(this, "Donnees", data, false);
        }
     
        
    }


	public void onClick(View v) {
		switch(v.getId()){
		case R.id.activity_parc_voiture_button_retour:
			Intent intent = new Intent(this, Main.class);
    		startActivity(intent);
			finish();
			break;
		}

	}
	
	
}
