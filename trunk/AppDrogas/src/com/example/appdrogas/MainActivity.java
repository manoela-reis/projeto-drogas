package com.example.appdrogas;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends Activity 
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setVolumeControlStream(AudioManager.STREAM_MUSIC);

//		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

	    setContentView(R.layout.activity_menu);
	}
	
	
/*
	ImageView img = (ImageView) findViewById(R.id.creditos);
	img.setOnClickListener(new OnClickListener() {
	    public void onClick(View v) {
			Intent intent = new Intent();
	//		intent.setClass(this, Creditos.class);
			startActivity(intent);		
	       
	    }
	});
	*/
	public void creditos (View v)
	{
//		Intent intent = new Intent(this, Creditos.class);
//		startActivity(intent);		
		
	}
	
	public void skank (View v)
	{
		Intent i = new Intent();
		i.setClass(this, Creditos.class);
		startActivity(i);		
	}

}
