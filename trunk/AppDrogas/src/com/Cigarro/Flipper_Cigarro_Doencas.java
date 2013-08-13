package com.Cigarro;

import com.TelasSelecao.Menu;
import com.example.appdrogas.R;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ViewFlipper;

public class Flipper_Cigarro_Doencas extends Activity implements OnClickListener

{

	ViewFlipper flippy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);
	    setContentView(R.layout.flipper_cigarro_doencas);
	    flippy = (ViewFlipper) findViewById(R.id.viewFlipper1);
	    flippy.setOnClickListener(this);
//	    flippy.setFlipInterval(500);
//	    flippy.startFlipping();
	}

	public void onClick(View v) 
	{
		flippy.showNext();
		
		
	}

	
}
