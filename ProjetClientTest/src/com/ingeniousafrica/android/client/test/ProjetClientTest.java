package com.ingeniousafrica.android.client.test;

import java.security.PublicKey;

import com.ingeniousafrica.android.client.activities.Main;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;


public class ProjetClientTest extends ActivityInstrumentationTestCase2<Main> {

	// Ajout des variables a appeler
	private Main mActivity;
	private TextView mView;
	private String resourceString;


	//Ajout du constructeur de la test case
	public ProjetClientTest(Class<Main> activityClass) {
		//Mettons en paremetre les informations sur l application atester
		super("com.ingeniousafrica.android.client.activities", Main.class);
	}

	//Ajout de la methode setUP() que le frmework JUnit appelle en premier pour chaque methode de test

	/**Utilisons cette methode pour initialiser  nos valeurs et preparons l environnement de test */ 
	@Override
	protected void setUp() throws Exception {

		super.setUp();
		mActivity = this.getActivity();
		mView = (TextView)mActivity.findViewById(com.ingeniousafrica.android.client.R.id.activity_main_textview_Testcase);
		resourceString = mActivity.getString(com.ingeniousafrica.android.client.R.string.activity_main_textview_Testcase);
	}

	// Verifions les conditions initiales de lancement de l application avant l execution des autres tests

	/**Cette methode est lancée qu une seule fois*/
	public void testPreconditions(){
		//Verifions l existence de l objet mView
		assertNotNull(mView);
	}
	
	//Ajout de text unitaire

	public void testTest() {
		// Verifions avec la methode assertEquals si le texte afficher a l ecran est celu voulu
		assertEquals(resourceString, (String)mView.getText().toString());	
	}


}
