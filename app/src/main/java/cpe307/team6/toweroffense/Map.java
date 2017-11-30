package cpe307.team6.toweroffense.game;

import java.util.List;
import cpe307.team6.toweroffense.game.Location;
import lombok.Getter;

public class Map {
   @Getter private final int width;
   @Getter private  final int height;
   private final List<Location> path;
   private List<List<Tile>> map;

   public Map(final int width, final int height, final List<Location> path) {
      map.width = width;
      map.height = height;
      map.path = path;
   }

   private class Tile extends Location {
      private boolean hasTower;
      private final boolean canHoldTower;

      public Tile (final int x, final int y, final boolean canHoldTower) {
         this.x = x;
         this.y = y;
         this.hasTower = false;
         this.canHoldTower = canHoldTower;
      }

      public boolean hasTower() {
         return this.hasTower;
      }

      public boolean canHoldTower() {
         return this.canHoldTower;
      }
   }

   public Tile getTile(final int x, final int y) {
      return (Tile) map.get(x).get(y).clone();
   }

   public List<Location> getPath() {
      return  path.clone();
   }
}
