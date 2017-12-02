package cpe307.team6.toweroffense.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ChibiCharacter extends AbstractGameObject {
   private static final int ROW_TOP_TO_BOTTOM = 0;
   private static final int ROW_RIGHT_TO_LEFT = 1;
   private static final int ROW_LEFT_TO_RIGHT = 2;
   private static final int ROW_BOTTOM_TO_TOP = 3;
   // Velocity of game character (pixel/millisecond)
   public static final float VELOCITY = 0.1f;
   private static final int CHARACTER_ROW_COUNT = 4;
   private static final int CHARACTER_COL_COUNT = 3;
   private static final int MILLI_SECONDS = 1000000;
   private static final int INIT_X = 10;
   private static final int INIT_Y = 5;

   private static int movingVectorX = INIT_X;
   private static int movingVectorY = INIT_Y;
   // Row index of Image are being used.
   private int rowUsing = ROW_LEFT_TO_RIGHT;

   private int colUsing;

   private Bitmap[] leftToRights;
   private Bitmap[] rightToLefts;
   private Bitmap[] topToBottoms;
   private Bitmap[] bottomToTops;

   private long lastDrawNanoTime = -1;

   private GameSurface gameSurface;

   public ChibiCharacter(final GameSurface gameSurface, final Bitmap image, final int xPos, final int yPos) {
      super(image, CHARACTER_ROW_COUNT, CHARACTER_COL_COUNT, xPos, yPos);

      this.gameSurface = gameSurface;

      this.topToBottoms = new Bitmap[colCount]; // 3
      this.rightToLefts = new Bitmap[colCount]; // 3
      this.leftToRights = new Bitmap[colCount]; // 3
      this.bottomToTops = new Bitmap[colCount]; // 3

      for (int col = 0; col < this.colCount; col++) {
         this.topToBottoms[col] = this.createSubImageAt(ROW_TOP_TO_BOTTOM, col);
         this.rightToLefts[col] = this.createSubImageAt(ROW_RIGHT_TO_LEFT, col);
         this.leftToRights[col] = this.createSubImageAt(ROW_LEFT_TO_RIGHT, col);
         this.bottomToTops[col] = this.createSubImageAt(ROW_BOTTOM_TO_TOP, col);
      }
   }

   public ChibiCharacter(final int xPos, final int yPos) {
      super(xPos, yPos);
      movingVectorX = xPos;
      movingVectorY = yPos;
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
      if (colUsing >= this.colCount) {
         this.colUsing = 0;
      }
      // Current time in nanoseconds
      final long now = System.nanoTime();

      // Never once did draw.
      if (lastDrawNanoTime == -1) {
         lastDrawNanoTime = now;
      }
      // Change nanoseconds to milliseconds (1 nanosecond = 1000000 milliseconds).
      final int deltaTime = (int) ((now - lastDrawNanoTime) / MILLI_SECONDS);

      // Distance moves
      final float distance = VELOCITY * deltaTime;

      final double movingVectorLength = Math.sqrt(movingVectorX * movingVectorX + movingVectorY * movingVectorY);

      // Calculate the new position of the game character.
      this.x = x + (int) (distance * movingVectorX / movingVectorLength);
      this.y = y + (int) (distance * movingVectorY / movingVectorLength);

      // When the game's character touches the edge of the screen, then change direction

      if (this.x < 0) {
         this.x = 0;
         movingVectorX = -movingVectorX;
      } else if (this.x > this.gameSurface.getWidth() - objectWidth) {
         this.x = this.gameSurface.getWidth() - objectWidth;
         movingVectorX = -movingVectorX;
      }

      if (this.y < 0) {
         this.y = 0;
         movingVectorY = -movingVectorY;
      } else if (this.y > this.gameSurface.getHeight() - objectHeight) {
         this.y = this.gameSurface.getHeight() - objectHeight;
         movingVectorY = -movingVectorY;
      }

      // rowUsing
      if (movingVectorX > 0) {
         if (movingVectorY > 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
            this.rowUsing = ROW_TOP_TO_BOTTOM;
         } else if (movingVectorY < 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
            this.rowUsing = ROW_BOTTOM_TO_TOP;
         } else {
            this.rowUsing = ROW_LEFT_TO_RIGHT;
         }
      } else {
         if (movingVectorY > 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
            this.rowUsing = ROW_TOP_TO_BOTTOM;
         } else if (movingVectorY < 0 && Math.abs(movingVectorX) < Math.abs(movingVectorY)) {
            this.rowUsing = ROW_BOTTOM_TO_TOP;
         } else {
            this.rowUsing = ROW_RIGHT_TO_LEFT;
         }
      }
   }

   public void draw(final Canvas canvas) {
      final Bitmap bitmap = this.getCurrentMoveBitmap();
      canvas.drawBitmap(bitmap, x, y, null);
      // Last draw time.
      this.lastDrawNanoTime = System.nanoTime();
   }

   public void setMovingVector(final int movingVectorX, final int movingVectorY) {
      ChibiCharacter.movingVectorX = movingVectorX;
      ChibiCharacter.movingVectorY = movingVectorY;
   }

   public int getMovingVectorX() {
      return movingVectorX;
   }

   public int getMovingVectorY() {
      return movingVectorY;
   }
}
