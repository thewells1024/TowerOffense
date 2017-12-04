package com.cpe307.group6.toweroffense.game.views;

import android.graphics.Bitmap;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractGameObject {
   enum Movement {
      ROW_TOP_TO_BOTTOM,
      ROW_RIGHT_TO_LEFT,
      ROW_LEFT_TO_RIGHT,
      ROW_BOTTOM_TO_TOP
   }

   @Getter
   private int width = 0;
   @Getter
   private int height = 0;

   @Getter
   @Setter
   private int x;
   @Getter
   @Setter
   private int y;

   @Getter
   private final int colCount;
   @Getter
   private final int rowCount;

   private Bitmap image;
   private int imageWidth = 0;
   private int imageHeight = 0;

   // Draw object at specific x, y
   public AbstractGameObject(final Bitmap image, final int rowCount, final int colCount, final int xPos, final int yPos) {

      this.image = image;

      this.colCount = colCount;
      this.rowCount = rowCount;

      this.imageWidth = image.getWidth();
      this.imageHeight = image.getHeight();

      this.width = this.imageWidth / colCount;
      this.height = this.imageHeight / rowCount;

      this.x = xPos;
      this.y = yPos;
   }

   // Draw object
   AbstractGameObject(final Bitmap image, final int rowCount, final int colCount) {

      this.image = image;

      this.colCount = colCount;
      this.rowCount = rowCount;


      this.imageWidth = image.getWidth();
      this.imageHeight = image.getHeight();

      this.width = this.imageWidth / colCount;
      this.height = this.imageHeight / rowCount;

      this.x = 0;
      this.y = 0;
   }

   // Draw object
   AbstractGameObject(final int rowCount, final int colCount) {

      this.rowCount = rowCount;
      this.colCount = colCount;

      this.x = 0;
      this.y = 0;
   }

   Bitmap createSubImageAt(final Movement row, final int col) {
      return Bitmap.createBitmap(image, col * width, row.ordinal() * height, width, height);
   }
   Bitmap createSubImageAt(final int row, final int col) {
      return Bitmap.createBitmap(image, col * width, row * height, width, height);
   }
}