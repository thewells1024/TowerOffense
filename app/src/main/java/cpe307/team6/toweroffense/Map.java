package cpe307.team6.toweroffense.game;

import java.util.List;
import cpe307.team6.toweroffense.game.Location;
import lombok.Getter;

public class Map {
   @Getter private final int width;
   @Getter private  final int height;
   @Getter private final List<Location> path;
   private List<List<Tile>> map;

   public Map(final int width, final int height, final List<Location> path) {
      this.width = width;
      this.height = height;
      this.path = path;
   }

   private class Tile extends Location {
      private boolean hasTower;
      private boolean canHoldTower;

      public Tile (final int x, final int y) {
         this.x = x;
         this.y = y;
         this.hasTower = false;
      }

      public boolean hasTower() {
         return this.hasTower;
      }

      public boolean canHoldTower() {
         return this.canHoldTower;
      }
   }

   public Tile getTile(int x, int y) {
      Tile clone = (Tile) map.get(x).get(y).clone();
      return clone;
   }

   public List<Location> getPath() {
      List<Location> newPath = path.clone();
      return newPath;
   }
}
