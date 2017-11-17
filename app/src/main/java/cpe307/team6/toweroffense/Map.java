package cpe307.team6.toweroffense.game;

import java.util.List;
import cpe307.team6.toweroffense.game.Location;
import lombok.Getter;

public class Map {
   private @Getter final int width;
   private @Getter final int height;
   private final List<Location> path;
   private List<List<Tile>> map;

   public Map(final int width, final int height, final List<Location> path) {
      this.width = width;
      this.height = height;
      this.path = path;
   }

   private class Tile {
      public @Getter final int x;
      public @Getter final int y;

      public Tile (final int x, final int y) {
         this.x = x;
         this.y = y;
      }
   }

   public Tile getTile(int x, int y) {
      Tile tile = map.get(x).get(y);
      return tile;
   }

   public List<Location> getPath() {
      List<Location> newPath = path;
      return newPath;
   }
}
