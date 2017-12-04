package com.cpe307.group6.toweroffense.game.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import lombok.Getter;

public class TowerView extends AbstractGameObject {
   private static final int ROW_COUNT = 30;
   private static final int COL_COUNT = 30;
   private static final int IMAGE_ROW = 8;
   private static final int IMAGE_COL = 9;

   @Getter
   private Bitmap tile;

   public TowerView(final Bitmap image, final int xLocation, final int yLocation) {
      super(image, ROW_COUNT, COL_COUNT, xLocation, yLocation);

      this.tile = this.createSubImageAt(IMAGE_ROW, IMAGE_COL);
   }

   public void draw(final Canvas canvas) {
      canvas.drawBitmap(tile, getX(), getY(), null);
   }
}
