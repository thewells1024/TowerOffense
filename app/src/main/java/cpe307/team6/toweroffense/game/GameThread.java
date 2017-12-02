package cpe307.team6.toweroffense.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
   private static final int milliseconds = 1000000;
   private static final int waitTimeBound = 10;

   private boolean running;
   private GameSurface gameSurface;
   private SurfaceHolder surfaceHolder;

   GameThread(final GameSurface gameSurface, final SurfaceHolder surfaceHolder) {
      this.gameSurface = gameSurface;
      this.surfaceHolder = surfaceHolder;
   }

   @Override
   public void run() {
      long startTime = System.nanoTime();

      while (running) {
         Canvas canvas = null;
         try {
            // Get Canvas from Holder and lock it.
            canvas = this.surfaceHolder.lockCanvas();

            // Synchronized
            synchronized (canvas) {
               this.gameSurface.update();
               this.gameSurface.draw(canvas);
            }
         } catch (Exception eException) {
            // Do nothing.
            System.out.println("GameThread: " + eException);
         } finally {
            if (canvas != null) {
               // Unlock Canvas.
               this.surfaceHolder.unlockCanvasAndPost(canvas);
            }
         }

         final long now = System.nanoTime();

         // Interval to redraw game
         // (Change nanoseconds to milliseconds)
         long waitTime = (now - startTime) / milliseconds;

         if (waitTime < waitTimeBound) {
            waitTime = waitTimeBound; // Millisecond.
         }
         System.out.print(" Wait Time = " + waitTime);

         try {
            // Sleep.
            sleep(waitTime);
         } catch (InterruptedException eException) {
            System.out.println(eException);
         }

         startTime = System.nanoTime();
         System.out.print(".");
      }
   }

   void setRunning(final boolean running) {
      this.running = running;
   }
}