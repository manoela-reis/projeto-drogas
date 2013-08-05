package TestesActivity;

import com.example.appdrogas.R;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MenuActivity extends Activity
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
//		Intent intent = new Intent(this, Creditos.class);
//		startActivity(intent);		
	}


}
