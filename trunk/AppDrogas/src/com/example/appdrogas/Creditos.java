package com.example.appdrogas;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Creditos extends ListActivity {

	ArrayList<ListaDeNomes_Base> integrantes;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
/*		// Sem Activity e em modo Fullcreen.
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		integrantes = new ArrayList<ListaDeNomes_Base>();
		
		setIntegrantes();
		
		setListAdapter(new ListaDeNomes_Adapter(this, integrantes));
		
//		setContentView(R.layout.activity_creditos);
	*/	
	}

	private void setIntegrantes(){
		
		ListaDeNomes_Base ldb1 = new ListaDeNomes_Base();
		ldb1.setIntegrantes("Filipe Zanella");
		ldb1.setFuncao("Programador");
		
		ListaDeNomes_Base ldb2 = new ListaDeNomes_Base();
		ldb2.setIntegrantes("Manoela Barreto");
		ldb2.setFuncao("Programador");
		
		ListaDeNomes_Base ldb3 = new ListaDeNomes_Base();
		ldb3.setIntegrantes("Thyago Ziderich");
		ldb3.setFuncao("Programador");
		
		ListaDeNomes_Base ldb4 = new ListaDeNomes_Base();
		ldb4.setIntegrantes("Vitória Oliveira");
		ldb4.setFuncao("Programador");
		
		ListaDeNomes_Base ldb5 = new ListaDeNomes_Base();
		ldb5.setIntegrantes("A procura de um artista...");
		ldb5.setFuncao("Programador");		
				
		integrantes.add(ldb1);
		integrantes.add(ldb2);
		integrantes.add(ldb3);
		integrantes.add(ldb4);
		integrantes.add(ldb5);

	}
}