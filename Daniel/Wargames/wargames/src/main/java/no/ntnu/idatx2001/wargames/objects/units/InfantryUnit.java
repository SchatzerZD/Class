package no.ntnu.idatx2001.wargames.objects.units;

/**
 *  Represents an infantry unit. An infantry unit is a unit
 *  which specializes in melee combat, which means it excels
 *  in damage, but often lacks defense.
 *
 * @author Daniel Ireneo Neri Saren
 * @version 1.0.0
 */
public class InfantryUnit extends Unit{

    /**
     * Constructor for an infantry unit.
     *
     * @param name   The name of the unit
     * @param health Amount of health points, can't go under 0
     * @param attack Amount of attack points
     * @param armor  Amount of defense points
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for an infantry unit. Default values
     * for attack and defense are set to 15 and 10.
     *
     * @param name      The name of the unit
     * @param health    Amount of health points, can't go under 0
     */
    public InfantryUnit(String name, int health){
        super(name,health,15,10);
    }

    /**
     * Returns attack bonus that is specific to
     * this type of unit.
     *
     * @return attack bonus
     */
    @Override
    public int getAttackBonus() {
        return 4;
    }

    /**
     * Returns defense bonus that is specific to
     * this type of unit.
     *
     * @return defense bonus
     */
    @Override
    public int getResistBonus() {
        return 2;
    }
}
