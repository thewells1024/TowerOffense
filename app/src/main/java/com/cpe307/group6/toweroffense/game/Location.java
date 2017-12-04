package com.cpe307.group6.toweroffense.game;

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

   public Location getPathLocation() {
      return new Location((int) this.getX(), (int) this.getY());
   }
}
