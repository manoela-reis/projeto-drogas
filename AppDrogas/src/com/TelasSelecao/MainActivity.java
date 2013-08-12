package com.TelasSelecao;

import java.util.ArrayList;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;

// Menu Inicial do projeto drogas.
public class MainActivity extends Activity 
{

	public final String TAG = "MainActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    Menu menu = new Menu(this);
		setContentView(menu);		
	}
	
/*	 public void onBackPressed() 
	 {
		 finish();
		 super.onBackPressed();
	 }*/
}