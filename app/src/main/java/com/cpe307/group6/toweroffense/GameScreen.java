package com.cpe307.group6.toweroffense;

import com.cpe307.group6.toweroffense.game.Game;
import com.cpe307.group6.toweroffense.game.Location;
import com.cpe307.group6.toweroffense.game.Map;
import com.cpe307.group6.toweroffense.game.PlayerStatus;
import com.cpe307.group6.toweroffense.game.factories.TowerFactory;
import com.cpe307.group6.toweroffense.game.interfaces.Player;
import com.cpe307.group6.toweroffense.game.interfaces.Tower;
import com.cpe307.group6.toweroffense.game.interfaces.Unit;
import com.cpe307.group6.toweroffense.game.players.EasyBot;
import com.cpe307.group6.toweroffense.game.views.BasicUnitView;
import com.cpe307.group6.toweroffense.game.views.GameSurface;
import com.cpe307.group6.toweroffense.game.views.TowerView;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.Window;
import android.view.WindowManager;

public class GameScreen extends AppCompatActivity {
   private static final String TAG = "GAME_SCREEN";
   private GameSurface surface;

   private Game game;
   private Map map;
   private Bitmap unitBitmap;
   private Bitmap towerBitmap;

   @Override
   protected void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      // Set fullscreen
      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN);

      // Set No Title
      this.requestWindowFeature(Window.FEATURE_NO_TITLE);

      // Setup Game
      unitBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.chibiangel);
      towerBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.tiles);

      final Player player1;
      final Player player2;
      final Bundle extras = getIntent().getExtras();
      if (extras != null) {
         player1 = (Player) extras.get("player1");
         player2 = (Player) extras.get("player2");
      } else {
         player1 = new EasyBot();
         player2 = new EasyBot();
      }
      surface = new GameSurface(this);
      final List<Location> path = getPath();
      TowerFactory.createFactory(path);
      map = new Map(Map.DEFAULT_WIDTH, Map.DEFAULT_HEIGHT, path);
      final Handler handler = new Handler(Looper.getMainLooper()) {
         @Override
         public void handleMessage(final Message inputMessage) {
            updateUI(surface, surface.getHolder());
         }
      };
      this.game = new Game(player1, player2, map, path, handler);
      setContentView(surface);
   }

   private List<Location> getPath() {
      final List<Location> path = new ArrayList<>();
      for (int yLocation = Map.DEFAULT_HEIGHT - 1; yLocation >= 0; yLocation--) {
         path.add(new Location(Map.DEFAULT_WIDTH / 2, yLocation));
      }
      return path;
   }

   private void updateUI(final GameSurface surface, final SurfaceHolder holder) {
      Log.d(TAG, "Drawing");
      Canvas canvas = null;
      try {
         // Get Canvas from Holder and lock it.
         canvas = holder.lockCanvas();

         // Synchronized
         synchronized (canvas) {
            final int width = surface.getWidth();
            final int height = surface.getWidth();
            surface.draw(canvas);
            for (PlayerStatus playerStatus : game.getPlayerStatuses()) {
               for (Unit unit : playerStatus.getUnits()) {
                  Log.d(TAG, String.format("Unit at %s", unit.getLocation()));
                  new BasicUnitView(unitBitmap, transformX(unit.getLocation().getX(), width),
                     transformY(unit.getLocation().getY(), height)).draw(canvas);
               }

               for (Tower tower : playerStatus.getTowers()) {
                  new TowerView(towerBitmap, transformX(tower.getLocation().getX(), width),
                     transformY(tower.getLocation().getY(), height)).draw(canvas);
               }
            }
         }
      } catch (Exception except) {
         Log.d(TAG, except.toString());
      } finally {
         if (canvas != null) {
            holder.unlockCanvasAndPost(canvas);
         }
      }
   }

   public int transformX(final double xLocation, final int width) {
      return (int) (width * xLocation / map.getWidth());
   }

   public int transformY(final double yLocation, final int height) {
      return (int) (height * yLocation / map.getHeight());
   }
}
