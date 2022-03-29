package no.ntnu.idatx2001.wargames.objects;

import no.ntnu.idatx2001.wargames.objects.units.Unit;

/**
 * Represents a battle. A battle is a battle
 * between two armies, with units attacking each other
 * until there is one winner.
 *
 * @author Daniel Ireneo Neri Saren
 * @version 1.0.0
 */
public class Battle {
    private Army armyOne;
    private Army armyTwo;

    /**
     * Constructor for a battle.
     *
     * @param armyOne The first army which starts the attack
     * @param armyTwo The second army which will participate in the battle
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     *  Simulates a battle between two armies. Takes a random unit
     *  from each of the armies starts a skirmish between them. If
     *  a unit's health is reduced to 0, they are removed from the army.
     *  The battle is over once one of the armies don't have any more units.
     *
     * @return the winner army of the battle
     */
    public Army simulate(){
        while(armyOne.hasUnits() && armyTwo.hasUnits()){
            Unit unitFromArmyOne = armyOne.getRandom();
            Unit unitFromArmyTwo = armyTwo.getRandom();

            System.out.println("---------------------");

            System.out.println(unitFromArmyOne + " -- attacked -- " + unitFromArmyTwo);
            armyOne.getRandom().attack(unitFromArmyTwo);
            System.out.println("After math: " + unitFromArmyTwo);

            if(unitFromArmyTwo.getHealth() == 0){
                armyTwo.remove(unitFromArmyTwo);
            }else{
                if(armyTwo.hasUnits()){
                    System.out.println(unitFromArmyTwo + " -- attacked -- " + unitFromArmyOne);
                    armyTwo.getRandom().attack(unitFromArmyOne);
                    System.out.println("After math: " + unitFromArmyOne);

                    if(unitFromArmyOne.getHealth() == 0){
                        armyOne.remove(unitFromArmyOne);
                    }
                }
            }
        }

        if(armyOne.hasUnits()){
            return armyOne;
        }else{
            return armyTwo;
        }
    }

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}
