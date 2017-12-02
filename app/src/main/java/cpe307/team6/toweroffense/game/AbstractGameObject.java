package cpe307.team6.toweroffense.game;

import android.graphics.Bitmap;

public abstract class AbstractGameObject {
   private Bitmap image;

   final int colCount;
   final int rowCount;

   private int imageWidth = 0;
   private int imageHeight = 0;

   int objectWidth = 0;
   int objectHeight = 0;

   int x;
   int y;

   // Draw object at specific x, y
   public AbstractGameObject(final Bitmap image, final int rowCount, final int colCount, int xPos, int yPos) {

      this.image = image;

      this.colCount = colCount;
      this.rowCount = rowCount;

      this.imageWidth = image.getWidth();
      this.imageHeight = image.getHeight();

      this.objectWidth = this.imageWidth / colCount;
      this.objectHeight = this.imageHeight / rowCount;

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

      this.objectWidth = this.imageWidth / colCount;
      this.objectHeight = this.imageHeight / rowCount;

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

   Bitmap createSubImageAt(final int row, final int col) {
      // createBitmap(bitmap, x, y, width, height).
      return Bitmap.createBitmap(image, col * objectWidth, row * objectHeight, objectWidth, objectHeight);
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getHeight() {
      return objectHeight;
   }

   public int getWidth() {
      return objectWidth;
   }
}