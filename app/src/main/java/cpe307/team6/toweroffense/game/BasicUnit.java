package cpe307.team6.toweroffense.game;

import cpe307.team6.toweroffense.game.interfaces.Unit;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class BasicUnit implements Unit {
   public static final double SPEED = .1;
   public static final int DEFAULT_HEALTH = 1000;

   private static final int ATTACK = 5;
   private static final double TILE_CHECK = .999;

   private final List<Location> path;

   private Location prevLocation;
   private Location location;
   private int health;

   public BasicUnit(final List<Location> path) {
      this.path = new ArrayList<>(path);
      location = this.path.get(0);
      this.health = DEFAULT_HEALTH;
   }

   public Location move() {
      double remainingMovement = SPEED;

      if (Math.abs(prevLocation.getX() - location.getX()) > TILE_CHECK) {
         prevLocation = location;
      } else if (Math.abs(prevLocation.getY() - location.getY()) > TILE_CHECK) {
         prevLocation = location;
      }

      while (remainingMovement > 0) {
         final int nextIndex = path.indexOf(prevLocation.getPathLocation()) + 1;

         if (nextIndex >= path.size()) {
            break;
         }

         final Location nextLocation = path.get(nextIndex);
         double newX = location.getX();
         double newY = location.getY();
         double changeX = nextLocation.getX() - newX;
         double changeY = nextLocation.getY() - newY;

         if (changeX == 0 && changeY == 0) {
            break;
         }

         if (Math.abs(changeX) > remainingMovement) {
            changeX *= (remainingMovement / Math.abs(changeX));
         }

         if (Math.abs(changeY) > remainingMovement) {
            changeY *= (remainingMovement / Math.abs(changeY));
         }

         newX += changeX;
         newY += changeY;

         location = new Location(newX, newY);
         remainingMovement -= (Math.abs(changeX) + Math.abs(changeY));
      }

      return location;
   }

   public Location getLocation() {
      return this.location;
   }

   public int getAttack() {
      return ATTACK;
   }

   public boolean takeDamage(final int amount) {
      this.health -= amount;
      if (health < 0) {
         this.health = 0;
      }
      // Removal function to be added for 0 health
      return (this.health == 0);
   }
}
