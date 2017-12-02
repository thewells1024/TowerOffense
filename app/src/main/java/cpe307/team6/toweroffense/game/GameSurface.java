package cpe307.team6.toweroffense.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import cpe307.team6.toweroffense.R;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
   private GameThread gameThread;
   private Map map;
   private ChibiCharacter chibi;

   private static int xPos = 100;
   private static int yPos = 50;

   public GameSurface(final Context context) {
      super(context);

      // Make Game Surface focusable so it can handle events. .
      this.setFocusable(true);

      // Sét callback.
      this.getHolder().addCallback(this);
   }

   public void update() {
      this.chibi.update();
   }

   @Override
   public void draw(final Canvas canvas) {
      super.draw(canvas);
      this.map.draw(canvas);
      this.chibi.draw(canvas);
   }

   // Implements method of SurfaceHolder.Callback
   @Override
   public void surfaceCreated(SurfaceHolder holder) {
      Bitmap mapBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiles);
      Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.chibi);
      this.map = new Map(this, mapBitmap);
      this.chibi = new ChibiCharacter(this, chibiBitmap1, xPos, yPos);
      this.gameThread = new GameThread(this, holder);
      this.gameThread.setRunning(true);
      this.gameThread.start();
   }

   // Implements method of SurfaceHolder.Callback
   @Override
   public void surfaceChanged(final SurfaceHolder holder, final int format, final int width, final int height) {

   }

   // Implements method of SurfaceHolder.Callback
   @Override
   public void surfaceDestroyed(final SurfaceHolder holder) {
      boolean retry = true;
      while (retry) {
         try {
            this.gameThread.setRunning(false);

            // Parent thread must wait until the end of GameThread.
            this.gameThread.join();
         } catch (InterruptedException eException) {
            eException.printStackTrace();
         }

         retry = true;
      }
   }

}