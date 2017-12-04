package cpe307.team6.toweroffense.game.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import lombok.Getter;

public class MapView extends AbstractGameObject {
   private static final int ROW_COUNT = 30;
   private static final int COL_COUNT = 30;
   private static final int TILE_ROW_COUNT_CONST = 9;
   private static final int TILE_COL_COUNT_CONST = 8;
   private static final int BIT_MAP_ROW_COUNT = 6;
   private static final int BIT_MAP_COL_COUNT = 20;
   private static final int ROW_TILE_POS = 3;

   @Getter
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

      for (int i = 0; i < canvas.getWidth() / getWidth(); i += 1) {
         for (int j = 0; j < canvas.getHeight() / getHeight(); j += 1) {
            canvas.drawBitmap(tiles[0][0], i * getWidth(), j * this.getHeight(), null);
         }
      }

      for (int i = 0; i < ROW_TILE_POS; i++) {
         for (int j = 0; j < canvas.getHeight() / getHeight(); j++) {
            canvas.drawBitmap(
                  tiles[ROW_TILE_POS][2],
                  (i - 2) * getWidth() + (canvas.getWidth() / 2) + getWidth() / 2,
                  j * getHeight(),
                  null
            );
         }
      }

      // Last draw time.
      this.lastDrawNanoTime = System.nanoTime();
   }
}