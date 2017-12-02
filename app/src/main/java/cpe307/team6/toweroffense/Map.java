package cpe307.team6.toweroffense.game;

import java.util.ArrayList;
import java.util.List;
import cpe307.team6.toweroffense.game.Location;
import lombok.Getter;

public class Map {
   @Getter private final int width;
   @Getter private final int height;
   private final List<Location> path;
   private List<List<Tile>> map;

   public Map(final int width, final int height, final List<Location> path) {
      this.width = width;
      this.height = height;
      this.path = path.clone();
      map = createMap(width, height, path);
   }
   
   public List<List<Tile>> createMap(final int width, final int height, final List<Location> path) {
      List<List<Tile>> returnMap = new ArrayList<>();
      for ( int i = 0; i < height; i++) {
         ArrayList<Tile> row = new ArrayList<>();
         for (int j = 0; j < width; j++) {
            row.add(new Tile(i,j,path.contains(new Location(i,j))));           
         }
         returnMap.add(row);
      }
      return returnMap;
   }
   
   @Data
   private class Tile extends Location implements Cloneable {
      private boolean hasTower;
      private final boolean canHoldTower;
      
      public Tile (final int x, final int y, final boolean canHoldTower) {
         super(x,y);
         this.hasTower = false;
         this.canHoldTower = canHoldTower;
      }

      public Object clone() throws CloneNotSupportedException {
         return super.clone();
      }
   }

   public Tile getTile(final int x, final int y) {
      return (Tile) map.get(x).get(y).clone();
   }

   public List<Location> getPath() {
      return  path.clone();
   }
}
