package cpe307.team6.toweroffense.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Map extends GameObject {
    // Row index of Image are being used.
    private int rowUsing;
    private int colUsing;

    private Bitmap[][] tiles;

    private long lastDrawNanoTime = -1;

    private GameSurface gameSurface;

    Map(GameSurface gameSurface, Bitmap image) {
        super(image, 30, 30);
        int tileRowCount = 9;
        int tileColCount = 8;

        this.gameSurface = gameSurface;

        this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30

        for(int row = 0; row < tileRowCount; row++ ) {
            for (int col = 0; col < tileColCount; col++) {
                this.tiles[row][col] = this.createSubImageAt(row + 6, col + 20);
            }
        }
    }


    public Map(GameSurface gameSurface) {
        super(30, 30);
        int tileRowCount = 9;
        int tileColCount = 8;

        this.gameSurface = gameSurface;

        this.tiles = new Bitmap[tileRowCount][tileColCount]; // 30 x 30
    }

    public void update()  {}

    void draw(Canvas canvas)  {
        // Bitmap bitmap = this.getCurrentMoveBitmap();

        for (int i = 0; i < canvas.getWidth() / this.objectWidth; i++) {
            for (int j = 0; j < canvas.getHeight() / this.objectHeight; j++) {
                canvas.drawBitmap(tiles[0][0], i * this.objectWidth, j * this.objectHeight, null);
            }
        }

        // Last draw time.
        this.lastDrawNanoTime= System.nanoTime();
    }

    public Bitmap[][] getTiles() {
        return this.tiles;
    }
}