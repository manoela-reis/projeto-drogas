package com.example.appdrogas;

import com.TelasSelecao.Menu;
import com.example.appdrogas.R;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ViewFlipper;

public class Galeria extends Activity

{

	ViewFlipper flippy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    setContentView(R.layout.nsei);
	}	
}
