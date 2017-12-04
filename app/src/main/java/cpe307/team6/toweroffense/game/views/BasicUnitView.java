package cpe307.team6.toweroffense.game.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BasicUnitView extends AbstractGameObject {
   private static final int CHARACTER_ROW_COUNT = 4;
   private static final int CHARACTER_COL_COUNT = 3;

   private Movement rowUsing = Movement.ROW_LEFT_TO_RIGHT;
   private int colUsing;

   private Bitmap[] leftToRights;
   private Bitmap[] rightToLefts;
   private Bitmap[] topToBottoms;
   private Bitmap[] bottomToTops;

   private long lastDrawNanoTime = -1;

   public BasicUnitView(final Bitmap image, final int xLocation, final int yLocation) {
      super(image, CHARACTER_ROW_COUNT, CHARACTER_COL_COUNT, xLocation, yLocation);

      this.topToBottoms = new Bitmap[getColCount()];
      this.rightToLefts = new Bitmap[getColCount()];
      this.leftToRights = new Bitmap[getColCount()];
      this.bottomToTops = new Bitmap[getColCount()];

      for (int col = 0; col < getColCount(); col++) {
         this.topToBottoms[col] = this.createSubImageAt(Movement.ROW_TOP_TO_BOTTOM, col);
         this.rightToLefts[col] = this.createSubImageAt(Movement.ROW_RIGHT_TO_LEFT, col);
         this.leftToRights[col] = this.createSubImageAt(Movement.ROW_LEFT_TO_RIGHT, col);
         this.bottomToTops[col] = this.createSubImageAt(Movement.ROW_BOTTOM_TO_TOP, col);
      }
   }

   public Bitmap[] getMoveBitmaps() {
      switch (rowUsing) {
         case ROW_BOTTOM_TO_TOP:
            return this.bottomToTops;
         case ROW_LEFT_TO_RIGHT:
            return this.leftToRights;
         case ROW_RIGHT_TO_LEFT:
            return this.rightToLefts;
         case ROW_TOP_TO_BOTTOM:
            return this.topToBottoms;
         default:
            return null;
      }
   }

   public Bitmap getCurrentMoveBitmap() {
      final Bitmap[] bitmaps = this.getMoveBitmaps();
      return bitmaps[this.colUsing];
   }


   public void update() {
      this.colUsing++;
      if (colUsing >= this.getColCount()) {
         this.colUsing = 0;
      }
      final long now = System.nanoTime();

      if (lastDrawNanoTime == -1) {
         lastDrawNanoTime = now;
      }

      this.rowUsing = Movement.ROW_TOP_TO_BOTTOM;
   }

   public void draw(final Canvas canvas) {
      final Bitmap bitmap = this.getCurrentMoveBitmap();
      canvas.drawBitmap(bitmap, getX(), getY(), null);
      // Last draw time.
      this.lastDrawNanoTime = System.nanoTime();
   }
}
