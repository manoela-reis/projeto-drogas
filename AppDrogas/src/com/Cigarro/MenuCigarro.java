package com.Cigarro;

import java.io.InputStream;

import com.example.appdrogas.Creditos;

import Gerenciadores.ImageManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Camera.Area;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class MenuCigarro extends View implements Runnable
{
	private Bitmap background;
	private Bitmap skank;
	private Bitmap cigarro;
	private Bitmap somOn;
	
	private Rect rectSaibaMais;
	private Rect rectDoencas;
	private Rect rectCampanhas;
	private Rect rectBackground;
	
	ImageManager img;
	Paint paint;
	Activity activity;
	public static final String TAG = "MenuInicial";
	
	public MenuCigarro(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		paint = new Paint();

		activity = (Activity) context;
		img = new ImageManager();
		rectSaibaMais = new Rect();
		rectDoencas = new Rect();
		rectCampanhas = new Rect();
		rectBackground = new Rect();
		
		// Carregando as imagens.
		background = img.ImageManager("TelaMenu.png", context);		
/*		skank = img.ImageManager("Drogas_Cigarro.png", context);
		cigarro = img.ImageManager("Drogas_skank.png", context);
*/				
		// TODO Auto-generated constructor stub
	}
	protected void onSizeChanged(int w, int h, int oldw, int oldh) 
	{
		super.onSizeChanged(w, h, oldw, oldh);
		
		rectBackground.set(0,0,getWidth(),getHeight());
		rectSaibaMais.set((int)(getWidth()/10),(int)(getHeight()/4),(int)(getWidth()/1.2),(int)(getHeight()/2.5f));
		rectDoencas.set((int)(getWidth()/10),(int)(getHeight()/2),(int)(getWidth()/1.2),(int)(getHeight()/1.5f));
		rectCampanhas.set((int)(getWidth()/10),(int)(getHeight()/1.3),(int)(getWidth()/1.2),(int)(getHeight()/1.1f));

	}
	public void draw(Canvas canvas)
	{
		super.draw(canvas);		

		canvas.drawBitmap(background, null, rectBackground, paint);
	
		canvas.drawRect(rectSaibaMais, paint);
		canvas.drawRect(rectDoencas, paint);
		canvas.drawRect(rectCampanhas, paint);		
	}
	
	public boolean onTouchEvent(MotionEvent event) 
	{	
		if (event.getAction() == MotionEvent.ACTION_DOWN) 
		{
			Log.i(TAG, "Entrou no action down");
			
			int a = (int)event.getRawX();
			int b = (int)event.getRawY();
		}
		
		if (event.getAction() == MotionEvent.ACTION_MOVE) 
		{
//			Log.i(TAG, "Entrou no action move");
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP) 
		{
			Log.i(TAG, "Entrou no action up");
			
			int a = (int)event.getX();
			int b = (int)event.getY();

			// Saiba +
			if(rectSaibaMais.contains(a,b))
			{
				// Chamar aqui o view flipper 
				
//				loadPeloOutro = new PeloOutro(activity);
//				activity.setContentView(loadPeloOutro);	
				
				Intent intent = new Intent(activity, Flipper_Cigarro.class);
				activity.startActivity(intent);
				activity.finish();
			}
			
			// Doenças
			if(rectDoencas.contains(a,b))
			{
				Log.i(TAG, "Escolhi doenças!! ");

				Intent intent = new Intent(activity, Flipper_Cigarro.class);
				activity.startActivity(intent);
				activity.finish();
			}
			

			// Campanhas
			if(rectCampanhas.contains(a,b))
			{
				Intent intent = new Intent(activity, Flipper_Cigarro.class);
				activity.startActivity(intent);
				activity.finish();
			}
		}
		
		return super.onTouchEvent(event);
	}
	

	
	public void run() 
	{
		while(true)
		{
			try
			{	
				Thread.sleep(1);
			}
			
			catch(Exception e)
			{
				Log.e("Deu erro", "Quem sabe mete o pe");
			}
			
			postInvalidate();
		}
		// TODO Auto-generated method stub
	}
	
}