package cpe307.team6.toweroffense.game.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import lombok.Getter;

public class TowerView extends AbstractGameObject {
   private static final int ROW_COUNT = 30;
   private static final int COL_COUNT = 30;
   private static final int TILE_ROW_COUNT_CONST = 10;
   private static final int TILE_COL_COUNT_CONST = 10;
   private static final int ROW_TILE_POS = 3;

   @Getter
   private Bitmap[][] tiles;

   private long lastDrawNanoTime = -1;

   private GameSurface gameSurface;

   public TowerView(final Bitmap image, final int xLocation, final int yLocation) {
      super(image, ROW_COUNT, COL_COUNT, xLocation, yLocation);
      final int tileRowCount = TILE_ROW_COUNT_CONST;
      final int tileColCount = TILE_COL_COUNT_CONST;

      this.gameSurface = gameSurface;

      this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30

      for (int row = 0; row < tileRowCount; row++) {
         for (int col = 0; col < tileColCount; col++) {
            this.tiles[row][col] = this.createSubImageAt(row, col);
         }
      }
   }


   public TowerView(final GameSurface gameSurface) {
      super(ROW_COUNT, COL_COUNT);
      final int tileRowCount = TILE_ROW_COUNT_CONST;
      final int tileColCount = TILE_COL_COUNT_CONST;

      this.gameSurface = gameSurface;

      this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30
   }

   public void update() {
   }

   public void draw(final Canvas canvas) {
      canvas.drawBitmap(tiles[8][9], getX(), getY(), null);

      // Last draw time.
      this.lastDrawNanoTime = System.nanoTime();
   }
}
