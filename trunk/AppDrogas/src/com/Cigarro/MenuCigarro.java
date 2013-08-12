package com.Cigarro;

import java.io.InputStream;

import com.example.appdrogas.Creditos;

import Gerenciadores.ImageManager;
import Gerenciadores.Sprite;
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
	private Bitmap campanhas;
	private Bitmap doencas;
	private Bitmap saibaMais;
	
	private Rect rectSaibaMais;
	private Rect rectDoencas;
	private Rect rectCampanhas;
	private Rect rectBackground;
	
	ImageManager img;
	Paint paint;
	Activity activity;
	public static final String TAG = "MenuInicial";
	
	Sprite spriteSaibaMais;
	Sprite spriteDoencas;
	Sprite spriteCampanhas;
	
	
	Boolean opcaoSaibaMais = false; 
	Boolean opcaoDoencas = false; 
	Boolean opcaoCampanhas = false; 
	
	
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
		saibaMais = img.ImageManager("saibaMais.png", context);
		campanhas = img.ImageManager("campanhas.png", context);
		doencas = img.ImageManager("doencas.png", context);
				
		spriteSaibaMais = new Sprite(saibaMais, 2, 1);
		spriteDoencas = new Sprite(doencas, 2, 1);
		spriteCampanhas = new Sprite(campanhas, 2, 1);
		
		this.spriteSaibaMais.Modificar(0);
		this.spriteDoencas.Modificar(0);
		this.spriteCampanhas.Modificar(0);
		
		// TODO Auto-generated constructor stub
	}
	protected void onSizeChanged(int w, int h, int oldw, int oldh) 
	{
		super.onSizeChanged(w, h, oldw, oldh);
		
		rectBackground.set(0,0,getWidth(),getHeight());
		rectSaibaMais.set((int)(getWidth()/6),(int)(getHeight()/3.4),(int)(getWidth()/2.5),(int)(getHeight()/1.4f));
		rectDoencas.set((int)(getWidth()/2.3),(int)(getHeight()/3.4),(int)(getWidth()/1.55),(int)(getHeight()/1.4f));
		rectCampanhas.set((int)(getWidth()/1.5),(int)(getHeight()/3.4),(int)(getWidth()/1.14),(int)(getHeight()/1.4f));

	}
	public void draw(Canvas canvas)
	{
		super.draw(canvas);		

		canvas.drawBitmap(background, null, rectBackground, paint);

		this.spriteSaibaMais.Draw(canvas, rectSaibaMais);
		this.spriteDoencas.Draw(canvas, rectDoencas);
		this.spriteCampanhas.Draw(canvas, rectCampanhas);
		
	}
	
	public boolean onTouchEvent(MotionEvent event) 
	{	
		if (event.getAction() == MotionEvent.ACTION_DOWN) 
		{
			Log.i(TAG, "Entrou no action down");
			
			int a = (int)event.getRawX();
			int b = (int)event.getRawY();
			
			if (rectSaibaMais.contains(a,b))
			{				
				spriteSaibaMais.Modificar(1);
				opcaoSaibaMais = true;
			}
			
			if (rectDoencas.contains(a,b))
			{				
				spriteDoencas.Modificar(1);
				opcaoDoencas = true;
			}
			
			if (rectCampanhas.contains(a,b))
			{				
				spriteCampanhas.Modificar(1);
				opcaoCampanhas = true;
			}						
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
			
			// Doenças
			if(rectDoencas.contains(a,b))
			{
				Log.i(TAG, "Escolhi doenças!! ");

				Intent intent = new Intent(activity, Flipper_Cigarro_Doencas.class);
				activity.startActivity(intent);
				activity.finish();
			}
			

			// Campanhas
			if(rectCampanhas.contains(a,b))
			{
				Intent intent = new Intent(activity, Flipper_Cigarro_Campanhas.class);
				activity.startActivity(intent);
				activity.finish();
			}
			
			if (rectSaibaMais.contains(a, b)) 
			{
				if (opcaoSaibaMais == true)
				{
					Intent mod = new Intent((Context)activity,Flipper_Cigarro_Saiba.class);
					activity.startActivity(mod);
					opcaoSaibaMais = false;
				} 
//				opcaoSaibaMais = false;
			}
			
	//		else 
	//		{
	//			spritePlay.Modificar(0);
	//		}
		
		}
		return super.onTouchEvent(event);
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(1);

			}

			catch (Exception e) {
				Log.e("Deu erro", "Quem sabe mete o pe");
			}
			update();

			postInvalidate();
		}
		// TODO Auto-generated method stub
	}

	public void update() 
	{
	/*	if (!opcaoSaibaMais) 
		{
			spritePlay.Modificar(1);
		}*/
		
/*		if (opcaoSaibaMais == false)
		{
			spritePlay.Modificar(0);
		}*/
	}
	
}