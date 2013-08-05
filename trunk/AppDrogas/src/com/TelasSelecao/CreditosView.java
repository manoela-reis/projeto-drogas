package com.TelasSelecao;

import Gerenciadores.ElMatador;
import Gerenciadores.ImageManager;
import Gerenciadores.Killable;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.CrossProcessCursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class CreditosView extends View implements Runnable, Killable {
	private Bitmap[] creditos1 = new Bitmap[5];
	private Bitmap creditos2;
	private Rect rectCreditos1 = new Rect();
	private ImageManager picture;
	private Paint paint;
	private View fase01;
	private View menu;
	Activity activity;
	static int counter = 0;
	static int period = 1;
	String TAG = "Creditos";
	int pos = 0;
	Thread processo;
	public static long deltaTime;
	public long lastTimeCount;
	public boolean ativo = true;
	private View opcaoPlay;
	public CreditosView(Context context) {
		super(context);

		setFocusableInTouchMode(true);
		setClickable(true);
		setLongClickable(true);
		period = 1;
		pos = 0;
		picture = new ImageManager();
		paint = new Paint();

		ativo=true;
		activity = (Activity) context;

		Log.i(TAG, "Entrou no construtor");
		creditos1[0] = picture.ImageManager("creditos1.png",super.getContext());
		creditos1[1] = picture.ImageManager("creditos2.png",super.getContext());

		// Thread
		this.processo = processo;
		processo = new Thread(this);
		processo.start();

		ElMatador.getInstance().add(this);

		// TODO Auto-generated constructor stub
	}

	public void start() {

		processo = new Thread(this);
		processo.start();
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {

		super.onSizeChanged(w, h, oldw, oldh);

		rectCreditos1.set(getWidth() / 22, 0, getWidth(),
				(int) (getHeight() / 1.08f));

	}

	public void draw(Canvas canvas) {
		super.draw(canvas);

		canvas.drawBitmap(creditos1[pos], null, rectCreditos1, paint);
	}

	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.i(TAG, "Entrou no action down");
		}

		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			Log.i(TAG, "Entrou no action move");
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			Log.i(TAG, "Entrou no action up");
			int a = (int) event.getX();
			int b = (int) event.getY();

			if (rectCreditos1.contains(a, b)) {
				if (pos == 0) {
					pos++;
				} else {
					if (pos == 1) {
//						activity.finish();
						opcaoPlay = new Menu(activity);
						activity.setContentView(opcaoPlay);	
					}

				}
			}

		}

		return super.onTouchEvent(event);
	}

	public void update() {

		this.deltaTime = System.currentTimeMillis() - this.lastTimeCount;
		this.lastTimeCount = System.currentTimeMillis();
		if (period != 0) {
			counter++;
		}

		if (counter == 1000) {
			period++;
			counter = 0;
		}
		if (period >= 5) {

			pos = 1;
		}
		if (period == 9) {

			//activity.finish();
			opcaoPlay = new Menu(activity);
			activity.setContentView(opcaoPlay);	
		}
	}

	public void run() {
		while (ativo) {
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
	public void ativar() {
		processo = new Thread(this);
		processo.start();

		ativo = true;

	}

	public void killMeSoftly() {
		ativo = false;

	}
}
