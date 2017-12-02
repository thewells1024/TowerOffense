package cpe307.team6.toweroffense.game;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import lombok.Data;

@Data
public class Location {
   private final double x;
   private final double y;

   /**
    * Returns the linear distance between two locations.
    *
    * @param from The point to measure to
    * @return The distance between the location and from
    */
   public double getDistance(final Location from) {
      return sqrt(pow(from.getX() - x, 2) + pow(from.getY() - y, 2));
   }

   /**
    * Returns the x and y values of a location as ints for unit path calculation.
    *
    * @return The current tile value of the location
    */
   public Location getPathLocation() {
      return new Location((int) this.getX(), (int) this.getY());
   }
}
