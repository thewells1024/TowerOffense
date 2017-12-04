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

   public synchronized boolean addUnits(final Unit... newUnits) {
      return units.addAll(asList(newUnits));
   }

   public synchronized void removeInvalidUnits() {
      final List<Location> path = base.getPath();
      final Location otherBase = path.get(path.size() - 1);
      units = units.stream().
         filter(unit -> unit.getHealth() != 0 && !unit.getLocation().equals(otherBase)).
         collect(Collectors.toList());
   }

   public synchronized boolean addTowers(final Tower... newTowers) {
      return towers.addAll(asList(newTowers));
   }

   public synchronized void removeTower(final Location atLocation) {
      towers = towers.stream().
         filter(tower -> !tower.getLocation().equals(atLocation)).
         collect(Collectors.toList());
   }

   public synchronized boolean playerLost() {
      return base.getHealth() == 0;
   }

   public List<Unit> getUnits() {
      return new ArrayList<>(units);
   }

   public List<Tower> getTowers() {
      return new ArrayList<>(towers);
   }
}
