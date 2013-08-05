package com.TelasSelecao;

import java.io.InputStream;


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

public class Menu extends View implements Runnable
{
	private Bitmap background;
	private Bitmap play;
	private Bitmap creditos;

	private Rect rectPlay;
	private Rect rectCreditos;
	private Rect rectBackground;
	
	ImageManager img;
	Paint paint;
	Activity activity;
	public static final String TAG = "Menu";
	
	View opcaoPlay;
	View opcaoCreditos;
	
	public Menu(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		paint = new Paint();

		activity = (Activity) context;
		img = new ImageManager();
		rectPlay = new Rect();
		rectCreditos = new Rect();
		rectBackground = new Rect();
		
		// Carregando as imagens.
		background = img.ImageManager("TelaMenu.png", context);		
		play = img.ImageManager("play.png", context);
		creditos = img.ImageManager("credits.png", context);
			
		// TODO Auto-generated constructor stub
	}
	protected void onSizeChanged(int w, int h, int oldw, int oldh) 
	{
		super.onSizeChanged(w, h, oldw, oldh);
		
		rectBackground.set(0,0,getWidth(),getHeight());
		rectPlay.set((int)(getWidth()/1.5f), (int)(getHeight()/5),(int)(getWidth()/1.2),(int)(getHeight()/2.1));		
		rectCreditos.set((int)(getWidth()/1.5), (int)(getHeight()/1.8),(int)(getWidth()/1.2),(int)(getHeight()/1.26));		
		
	}
	public void draw(Canvas canvas)
	{
		super.draw(canvas);		

		canvas.drawBitmap(background, null, rectBackground, paint);
		canvas.drawBitmap(play, null, rectPlay, paint);
		canvas.drawBitmap(creditos, null, rectCreditos, paint);
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
			
			// Play
			if(rectPlay.contains(a,b))
			{
				Log.i(TAG, "Escolhi o play! ");
				opcaoPlay = new EscolherDrogas(activity);
				activity.setContentView(opcaoPlay);	
			}
			
			// Créditos
			if(rectCreditos.contains(a,b))
			{
				Log.i(TAG, "Escolhi créditos!! ");
				opcaoCreditos = new CreditosView(activity);
				activity.setContentView(opcaoCreditos);	
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