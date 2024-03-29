package com.TelasSelecao;

import java.io.InputStream;

import com.Cigarro.MenuCigarro;
import com.Skank.MenuSkank;

import Gerenciadores.ImageManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class EscolherDrogas extends View implements Runnable
{
	private Bitmap background;
	private Bitmap skank;
	private Bitmap cigarro;
	private Bitmap somOn;
	
	private Rect rectSkank;
	private Rect rectCigarro;
	private Rect rectCreditos;
	private Rect rectBackground;
	
	ImageManager img;
	Paint paint;
	Activity activity;
	public static final String TAG = "MenuInicial";
	
	View menuCigarro;
	View menuSkank;

	public EscolherDrogas(Context context) 
	{	
		super(context);
		
		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		
		paint = new Paint();

		activity = (Activity) context;
		img = new ImageManager();
		rectSkank = new Rect();
		rectCigarro = new Rect();
		rectCreditos = new Rect();
		rectBackground = new Rect();
		
		// Carregando as imagens.
		background = img.ImageManager("Drogas_base.png", context);		
		cigarro = img.ImageManager("Drogas_Cigarro.png", context);
		skank = img.ImageManager("Drogas_skank.png", context);
				
		// TODO Auto-generated constructor stub
	}
	protected void onSizeChanged(int w, int h, int oldw, int oldh) 
	{
		super.onSizeChanged(w, h, oldw, oldh);
		
		rectBackground.set(0,0,getWidth(),getHeight());
		rectCigarro.set((int)(getWidth()/1.5f), (int)(getHeight()/5),(int)(getWidth()/1.2),(int)(getHeight()/2.1));
		//rectCigarro.set((int)(getWidth()/1.6), (int)(getHeight()/3.75),(int)(getWidth()/1.35),(int)(getHeight()/2.12));
		rectSkank.set((int)(getWidth()/1.5), (int)(getHeight()/1.8),(int)(getWidth()/1.2),(int)(getHeight()/1.26));	
		
	}
	public void draw(Canvas canvas)
	{
		super.draw(canvas);		

		canvas.drawBitmap(background, null, rectBackground, paint);
		canvas.drawBitmap(cigarro, null, rectCigarro, paint);
		canvas.drawBitmap(skank, null, rectSkank, paint);
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

			// Cigarro
			if(rectCigarro.contains(a,b))
			{
				Log.i(TAG, "Escolhi cigarro!! ");
				menuCigarro = new MenuCigarro(activity);
				activity.setContentView(menuCigarro);	
			}
			
			// Skank
			if(rectSkank.contains(a,b))
			{
				Log.i(TAG, "Escolhi skank! ");
				menuSkank = new MenuSkank(activity);
				activity.setContentView(menuSkank);	
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