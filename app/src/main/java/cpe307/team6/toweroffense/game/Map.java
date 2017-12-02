package cpe307.team6.toweroffense.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Map extends AbstractGameObject {
   private static final int rowCount = 30;
   private static final int colCount = 30;
   private static final int tileRowCountConst = 9;
   private static final int tileColCountConst = 8;
   private static final int bitMapRowCount = 6;
   private static final int bitMapColCount = 20;

   // Row index of Image are being used.
   private int rowUsing;
   private int colUsing;

   private Bitmap[][] tiles;

   private long lastDrawNanoTime = -1;

   private GameSurface gameSurface;

   Map(final GameSurface gameSurface, final Bitmap image) {
      super(image, rowCount, colCount);
      final int tileRowCount = tileRowCountConst;
      final int tileColCount = tileColCountConst;

      this.gameSurface = gameSurface;

      this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30

      for (int row = 0; row < tileRowCount; row++) {
         for (int col = 0; col < tileColCount; col++) {
            this.tiles[row][col] = this.createSubImageAt(row + bitMapRowCount, col + bitMapColCount);
         }
      }
   }


   public Map(final GameSurface gameSurface) {
      super(rowCount, colCount);
      final int tileRowCount = tileRowCountConst;
      final int tileColCount = tileColCountConst;

      this.gameSurface = gameSurface;

      this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30
   }

   public void update() {
   }

   void draw(final Canvas canvas) {
      // Bitmap bitmap = this.getCurrentMoveBitmap();

      for (int i = 0; i < canvas.getWidth() / this.objectWidth; i++) {
         for (int j = 0; j < canvas.getHeight() / this.objectHeight; j++) {
            canvas.drawBitmap(tiles[0][0], i * this.objectWidth, j * this.objectHeight, null);
         }
      }

      // Last draw time.
      this.lastDrawNanoTime = System.nanoTime();
   }

   public Bitmap[][] getTiles() {
      return this.tiles;
   }
}