package no.ntnu.idatx2001.wargames.objects;

import no.ntnu.idatx2001.wargames.objects.units.*;

import java.util.*;

/**
 * Represents an army. An army has a name, and
 * consists of a number of units fighting together.
 *
 * @author Daniel Ireneo Neri Saren
 * @version 1.1.0
 */
public class Army {
    private String name;
    private List<Unit> units;

    /**
     *  Constructor for an army.
     *
     * @param name  Name of the army
     */
    public Army(String name) {
        this.name = name;
        units = new ArrayList<>();
    }

    /**
     *  Constructor for an army.
     *
     * @param name  Name of the army
     * @param units Unit list in the army
     */
    public Army(String name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }

    /**
     * Returns the name of the army
     *
     * @return name of the army
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a unit to the army.
     *
     * @param unit  Unit that will be added to the army
     */
    public void add(Unit unit){
        this.units.add(unit);
    }

    /**
     * Adds a list of units to the army
     *
     * @param units Unit list that will be added to the army
     */
    public void addAll(List<Unit> units){
        this.units.addAll(units);
    }

    /**
     * Removes the specified unit from the army
     *
     * @param unit Unit that will be removed from the army
     */
    public void remove(Unit unit){
        this.units.remove(unit);
    }

    /**
     * Checks if the army has units.
     *
     * @return true if the army has units, false if it's empty.
     */
    public boolean hasUnits(){
        return !this.units.isEmpty();
    }

    /**
     * Returns a list of all the units that are currently in the army
     *
     * @return List of all the current units in the army
     */
    public List<Unit> getAllUnits() {
        return units;
    }

    /**
     * Returns a random unit from the army.
     *
     * @return random unit from the army
     */
    public Unit getRandom(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(units.size());
        return units.get(randomIndex);
    }

    public List<Unit> getInfantryUnits(){
        ArrayList<Unit> infantryUnits = new ArrayList<>();
        for (Unit unit : units) {
            if(unit instanceof InfantryUnit){
                infantryUnits.add(unit);
            }
        }

        return infantryUnits;
    }

    public List<Unit> getCavalryUnits(){
        ArrayList<Unit> cavalryUnits = new ArrayList<>();
        for (Unit unit : units) {
            if(unit instanceof CavalryUnit){
                cavalryUnits.add(unit);
            }
        }

        return cavalryUnits;

    }

    public List<Unit> getRangedUnits() {
        ArrayList<Unit> rangedUnits = new ArrayList<>();
        for (Unit unit : units) {
            if(unit instanceof RangedUnit){
                rangedUnits.add(unit);
            }
        }

        return rangedUnits;

    }

    public List<Unit> getCommanderUnits(){
        ArrayList<Unit> commanderUnits = new ArrayList<>();
        for (Unit unit : units) {
            if(unit instanceof CommanderUnit){
                commanderUnits.add(unit);
            }
        }
        return commanderUnits;
    }


    @Override
    public String toString() {
        String finalString = "Army: " + name + "\n";
        for (Unit unit: units) {
            finalString += unit.toString() + "\n";
        }
        return finalString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }

}
