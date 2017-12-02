package cpe307.team6.toweroffense.game;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import lombok.Data;

@Data
public class Location {
   private final double x;
   private final double y;

   public double getDistance(final Location from) {
      return sqrt(pow(from.getX() - x, 2) + pow(from.getY() - y, 2));
   }
}