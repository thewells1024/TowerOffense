package cpe307.team6.toweroffense.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Explosion extends AbstractGameObject {

   private int rowIndex = 0;
   private int colIndex = -1;

   private boolean finish = false;
   private GameSurface gameSurface;

   private static int rowCount = 5;
   private static int colCount = 5;

   public Explosion(final GameSurface gameSurface, final Bitmap image, final int xPos, final int yPos) {
      super(image, rowCount, colCount, xPos, yPos);

      this.gameSurface = gameSurface;
   }

   public Explosion(final int xPos, final int yPos) {
      super(xPos, yPos);
      this.rowIndex = xPos;
      this.colIndex = yPos;
   }

   public void update() {
      this.colIndex++;

      if (this.colIndex >= colCount) {
         this.colIndex = 0;
         this.rowIndex++;

         if (this.rowIndex >= rowCount) {
            this.finish = true;
         }
      }
   }

   public void draw(final Canvas canvas) {
      if (!finish) {
         final Bitmap bitmap = this.createSubImageAt(rowIndex, colIndex);
         canvas.drawBitmap(bitmap, this.x, this.y, null);
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