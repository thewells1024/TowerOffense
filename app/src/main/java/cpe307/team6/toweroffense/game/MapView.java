package cpe307.team6.toweroffense.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class MapView extends AbstractGameObject {
   private static final int ROW_COUNT = 30;
   private static final int COL_COUNT = 30;
   private static final int TILE_ROW_COUNT_CONST = 9;
   private static final int TILE_COL_COUNT_CONST = 8;
   private static final int BIT_MAP_ROW_COUNT = 6;
   private static final int BIT_MAP_COL_COUNT = 20;

   // Row index of Image are being used.
   private int rowUsing;
   private int colUsing;

   private Bitmap[][] tiles;

   private long lastDrawNanoTime = -1;

   private GameSurface gameSurface;

   MapView(final GameSurface gameSurface, final Bitmap image, final Bitmap tower) {
      super(image, ROW_COUNT, COL_COUNT);
      final int tileRowCount = TILE_ROW_COUNT_CONST;
      final int tileColCount = TILE_COL_COUNT_CONST;

      this.gameSurface = gameSurface;

      this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30

      for (int row = 0; row < tileRowCount; row++) {
         for (int col = 0; col < tileColCount; col++) {
            this.tiles[row][col] = this.createSubImageAt(row + BIT_MAP_ROW_COUNT, col + BIT_MAP_COL_COUNT);
         }
      }
   }


   public MapView(final GameSurface gameSurface) {
      super(ROW_COUNT, COL_COUNT);
      final int tileRowCount = TILE_ROW_COUNT_CONST;
      final int tileColCount = TILE_COL_COUNT_CONST;

      this.gameSurface = gameSurface;

      this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30
   }

   public void update() {
   }

   void draw(final Canvas canvas) {
      // Bitmap bitmap = this.getCurrentMoveBitmap();

      for (int i = 0; i < canvas.getWidth() / this.objectWidth; i += 1) {
         for (int j = 0; j < canvas.getHeight() / this.objectHeight; j += 1) {
            canvas.drawBitmap(tiles[0][0], i * this.objectWidth, j * this.objectHeight, null);
         }
      }

      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < canvas.getHeight() / this.objectHeight; j++) {
            canvas.drawBitmap(
                  tiles[3][2],
                  (i - 2) * this.objectWidth + (canvas.getWidth() / 2) + this.objectWidth / 2,
                  j * this.objectHeight,
                  null
            );
         }
      }

      // Last draw time.
      this.lastDrawNanoTime = System.nanoTime();
   }

   public Bitmap[][] getTiles() {
      return this.tiles;
   }
}