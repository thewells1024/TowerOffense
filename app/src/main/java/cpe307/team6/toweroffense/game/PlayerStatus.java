package cpe307.team6.toweroffense.game;

import static java.util.Arrays.asList;

import cpe307.team6.toweroffense.game.interfaces.Player;
import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.interfaces.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class PlayerStatus {
   private final Player player;
   private final Base base;
   @Setter(AccessLevel.NONE)
   private List<Unit> units;
   @Setter(AccessLevel.NONE)
   private List<Tower> towers;
   private Result result;

   public boolean addUnits(final Unit... newUnits) {
      return units.addAll(asList(newUnits));
   }

   public void removeInvalidUnits() {
      List<Location> path = base.getPath();
      Location otherBase = path.get(path.size() - 1);
      units = units.stream()
         .filter(unit -> unit.getHealth() != 0 && !unit.getLocation().equals(otherBase))
         .collect(Collectors.toList());
   }

   public boolean addTowers(final Tower... newTowers) {
      return towers.addAll(asList(newTowers));
   }

   public void removeTower(final Location at) {
      towers = towers.stream()
         .filter(tower -> tower.getLocation().equals(at))
         .collect(Collectors.toList());
   }

   public boolean playerLost() {
      return base.getHealth() == 0;
   }

   public List<Unit> getUnits() {
      return new ArrayList<>(units);
   }

   public List<Tower> getTowers() {
      return new ArrayList<>(towers);
   }
}
