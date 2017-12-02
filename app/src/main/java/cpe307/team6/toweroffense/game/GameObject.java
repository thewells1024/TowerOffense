package cpe307.team6.toweroffense.game;

import android.graphics.Bitmap;

public abstract class GameObject {
    private Bitmap image;

    final int rowCount;
    final int colCount;

    private int imageWidth = 0;
    private int imageHeight = 0;

    int objectWidth = 0;
    int objectHeight = 0;

    int x;
    int y;

    // Draw object at specific x, y
    public GameObject(Bitmap image, int rowCount, int colCount, int x, int y)  {

        this.image = image;
        this.rowCount = rowCount;
        this.colCount = colCount;

        this.x = x;
        this.y = y;

        this.imageWidth = image.getWidth();
        this.imageHeight = image.getHeight();

        this.objectWidth = this.imageWidth / colCount;
        this.objectHeight= this.imageHeight / rowCount;
    }

    // Draw object
    GameObject(Bitmap image, int rowCount, int colCount)  {

        this.image = image;
        this.rowCount = rowCount;
        this.colCount = colCount;

        this.x = 0;
        this.y = 0;

        this.imageWidth = image.getWidth();
        this.imageHeight = image.getHeight();

        this.objectWidth = this.imageWidth / colCount;
        this.objectHeight= this.imageHeight / rowCount;
    }

    // Draw object
    GameObject(int rowCount, int colCount)  {

        this.rowCount = rowCount;
        this.colCount = colCount;

        this.x = 0;
        this.y = 0;
    }

    Bitmap createSubImageAt(int row, int col)  {
        // createBitmap(bitmap, x, y, width, height).
        return Bitmap.createBitmap(image, col * objectWidth, row * objectHeight, objectWidth, objectHeight);
    }

    public int getX()  {
        return this.x;
    }

    public int getY()  {
        return this.y;
    }


    public int getHeight() {
        return objectHeight;
    }

    public int getWidth() { return objectWidth; }
}