package cpe307.team6.toweroffense.game.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Explosion extends AbstractGameObject {
   private static final int ROW_COUNT = 5;
   private static final int COL_COUNT = 5;

   private int rowIndex = 0;
   private int colIndex = -1;

   private boolean finish = false;
   private GameSurface gameSurface;


   public Explosion(final GameSurface gameSurface, final Bitmap image, final int xPos, final int yPos) {
      super(image, ROW_COUNT, COL_COUNT, xPos, yPos);

      this.gameSurface = gameSurface;
   }

   public Explosion(final int xPos, final int yPos) {
      super(xPos, yPos);
      this.rowIndex = xPos;
      this.colIndex = yPos;
   }

   public void update() {
      this.colIndex++;

      if (this.colIndex >= COL_COUNT) {
         this.colIndex = 0;
         this.rowIndex++;

         if (this.rowIndex >= ROW_COUNT) {
            this.finish = true;
         }
      }
   }

   public void draw(final Canvas canvas) {
      if (!finish) {
         final Bitmap bitmap = this.createSubImageAt(rowIndex, colIndex);
         canvas.drawBitmap(bitmap, getX(), getY(), null);
      }
   }

   public boolean isFinish() {
      return finish;
   }

   public int getRowIndex() {
      return this.rowIndex;
   }

   public int getColIndex() {
      return this.colIndex;
   }
}