package com.cpe307.group6.toweroffense.game.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Explosion extends AbstractGameObject {
   private static final int ROW_COUNT = 5;
   private static final int COL_COUNT = 5;

   private int rowIndex = 0;
   private int colIndex = -1;


   public Explosion(final Bitmap image, final int xPos, final int yPos) {
      super(image, ROW_COUNT, COL_COUNT, xPos, yPos);
   }

   public Explosion(final int xPos, final int yPos) {
      super(xPos, yPos);
      this.rowIndex = xPos;
      this.colIndex = yPos;
   }

   public void draw(final Canvas canvas) {
      final Bitmap bitmap = this.createSubImageAt(rowIndex, colIndex);
      canvas.drawBitmap(bitmap, getX(), getY(), null);
   }

   public int getRowIndex() {
      return this.rowIndex;
   }

   public int getColIndex() {
      return this.colIndex;
   }
}