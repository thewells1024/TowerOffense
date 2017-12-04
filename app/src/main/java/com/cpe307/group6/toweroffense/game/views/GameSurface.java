package com.cpe307.group6.toweroffense.game.views;

import com.cpe307.group6.toweroffense.R;
import com.cpe307.group6.toweroffense.game.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {

   private MapView mapView;

   public GameSurface(final Context context) {
      super(context);

      this.setFocusable(true);

      this.getHolder().addCallback(this);
   }

   @Override
   public void draw(final Canvas canvas) {
      super.draw(canvas);

      this.mapView.draw(canvas);
   }

   @Override
   public void surfaceCreated(final SurfaceHolder holder) {
      final Bitmap mapBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiles);
      final Bitmap towerBitMap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tower);
      this.mapView = new MapView(mapBitmap, Map.DEFAULT_WIDTH, Map.DEFAULT_HEIGHT);
   }

   @Override
   public void surfaceChanged(final SurfaceHolder holder, final int format, final int width, final int height) {
      // we don't do anything with this information
   }

   @Override
   public void surfaceDestroyed(final SurfaceHolder holder) {
      // we don't do anything with this information
   }
}
