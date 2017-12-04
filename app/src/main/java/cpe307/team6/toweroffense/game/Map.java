package cpe307.team6.toweroffense.game;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;

public class Map {
   public static final int DEFAULT_HEIGHT = 50;
   public static final int DEFAULT_WIDTH = 31;

   @Getter
   private final int width;
   @Getter
   private final int height;
   private final List<Location> path;
   private List<List<Tile>> map;

   public Map(final int width, final int height, final List<Location> path) {
      this.width = width;
      this.height = height;
      this.path = new ArrayList<>(path);
      map = createMap(width, height, path);
   }
   
   public static List<List<Tile>> createMap(final int width, final int height, final List<Location> path) {
      final List<List<Tile>> returnMap = new ArrayList<>();
      for (int i = 0; i < width; i++) {
         final ArrayList<Tile> row = new ArrayList<>();
         for (int j = 0; j < height; j++) {
            row.add(new Tile(i, j, !path.contains(new Location(i, j))));
         }
         returnMap.add(row);
      }
      return returnMap;
   }

   @EqualsAndHashCode(callSuper = true)
   public static class Tile extends Location {
      private boolean hasTower;
      private final boolean canHoldTower;
      
      Tile (final double xLocation, final double yLocation, final boolean canHoldTower) {
         this(xLocation, yLocation, false, canHoldTower);
      }

      Tile (final double xLocation, final double yLocation, final boolean hasTower, final boolean canHoldTower) {
         super(xLocation, yLocation);
         this.hasTower = hasTower;
         this.canHoldTower = canHoldTower;
      }

      Tile(final Tile from) {
         super(from.getX(), from.getY());
         this.hasTower = from.hasTower();
         this.canHoldTower = from.canHoldTower();
      }

      public boolean placeTower() {
         if (canHoldTower && !hasTower) {
            hasTower = true;
            return true;
         }
         return false;
      }

      public boolean hasTower() {
         return hasTower;
      }

      public boolean canHoldTower() {
         return canHoldTower;
      }
   }

   public Tile getTile(final int xLocation, final int yLocation) {
      return new Tile(map.get(xLocation).get(yLocation));
   }

   public Tile getTile(final Location location) {
      return getTile((int) location.getX(), (int) location.getY());
   }

   public List<Location> getPath() {
      return new ArrayList<>(path);
   }

   public boolean placeTowerAt(final Location location) {
      return map.get((int) location.getX()).get((int) location.getY()).placeTower();
   }
}
