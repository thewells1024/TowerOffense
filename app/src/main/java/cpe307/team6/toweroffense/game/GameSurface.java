package cpe307.team6.toweroffense.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import cpe307.team6.toweroffense.R;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
   private static final int X_POS = 0;
   private static final int Y_POS = 0;

   private GameThread gameThread;
   private MapView mapView;
   private ChibiCharacter chibi;
   private AngelCharacter angel;

   private final List<AngelCharacter> angelList = new ArrayList<AngelCharacter>();
   private final List<Explosion> explosionList = new ArrayList<Explosion>();

   public GameSurface(final Context context) {
      super(context);

      // Make Game Surface focusable so it can handle events. .
      this.setFocusable(true);

      // Sét callback.
      this.getHolder().addCallback(this);
   }

   public void update() {
      for (AngelCharacter angel : angelList) {
         angel.update();
      }

      for (Explosion explosion : this.explosionList) {
         explosion.update();
      }

      final Iterator<Explosion> iterator = this.explosionList.iterator();

      while (iterator.hasNext()) {
         final Explosion explosion = iterator.next();

         if (explosion.isFinish()) {
            // If explosion finish, Remove the current element from the iterator & list.
            iterator.remove();
            continue;
         }
      }
      this.chibi.update();
      // this.angel.update();
   }

   @Override
   public boolean onTouchEvent(final MotionEvent event) {
      if (event.getAction() == MotionEvent.ACTION_DOWN) {

         final int x = (int) event.getX();
         final int y = (int) event.getY();

         final Iterator<AngelCharacter> iterator = this.angelList.iterator();

         while (iterator.hasNext()) {
            final AngelCharacter angel = iterator.next();
            if (angel.getX() < x && x < angel.getX() + angel.getWidth() && angel.getY() < y && y < angel.getY() + angel.getHeight()) {
               // Remove the current element from the iterator and the list.
               iterator.remove();

               // Create Explosion object.
               final Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.explosion);
               final Explosion explosion = new Explosion(this, bitmap, angel.getX(), angel.getY());

               this.explosionList.add(explosion);
            }
         }


         for (AngelCharacter angel : angelList) {
            final int movingVectorX = x - angel.getX();
            final int movingVectorY = y - angel.getY();
            angel.setMovingVector(movingVectorX, movingVectorY);
         }
         return true;
      }
      return false;
   }

   @Override
   public void draw(final Canvas canvas) {
      super.draw(canvas);

      this.mapView.draw(canvas);

      for (AngelCharacter angel : angelList) {
         angel.draw(canvas);
      }

      for (Explosion explosion : this.explosionList) {
         explosion.draw(canvas);
      }

      this.chibi.draw(canvas);
      // this.angel.draw(canvas);

   }

   // Implements method of SurfaceHolder.Callback
   @Override
   public void surfaceCreated(final SurfaceHolder holder) {
      final Bitmap mapBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiles);
      final Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.chibi);
      final Bitmap angelBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.chibiangel);
      final Bitmap towerBitMap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tower);
      this.mapView = new MapView(this, mapBitmap, towerBitMap);
      this.chibi = new ChibiCharacter(this, chibiBitmap1, X_POS, Y_POS);
      this.angel = new AngelCharacter(this, angelBitmap, X_POS, Y_POS);

      this.angelList.add(this.angel);

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