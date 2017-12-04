package cpe307.team6.toweroffense.game;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import lombok.Data;

@Data
public class Location {
   private final double x;
   private final double y;

   public Location(final double xcoordinate, final double ycoordinate) {
      this.x = xcoordinate;
      this.y = ycoordinate;
   }

   public double getDistance(final Location from) {
      return sqrt(pow(from.getX() - x, 2) + pow(from.getY() - y, 2));
   }

   public double getX() {
      return this.x;
   }

   public double getY() {
      return this.y;
   }
}
