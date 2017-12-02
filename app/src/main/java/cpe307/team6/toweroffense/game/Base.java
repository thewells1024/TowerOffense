package cpe307.team6.toweroffense.game;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Base {
   @Setter(AccessLevel.NONE)
   private int health;
   private final Location location;
   private final List<Location> path;

   public int takeDamage(final int amount) {
      health -= amount <= health ? amount : health;
      return health;
   }

   public List<Location> getPath() {
      return new ArrayList<>(path);
   }
}
