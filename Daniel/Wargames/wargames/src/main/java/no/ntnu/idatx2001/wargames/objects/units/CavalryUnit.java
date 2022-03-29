package no.ntnu.idatx2001.wargames.objects.units;

/**
 * Represents a cavalry unit. Cavalry units excel
 * with the advantage of cavalry, leading to strong
 * charge attacks, but vulnerable at melee combat.
 *
 * @author Daniel Ireneo Neri Saren
 * @version 1.0.1
 */
public class CavalryUnit extends Unit{
    private int charge = 0;

    /**
     * Constructor for a cavalry unit.
     *
     * @param name   The name of the unit
     * @param health Amount of health points, input under 0 will be converted to 0
     * @param attack Amount of attack points
     * @param armor  Amount of defense points
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for a cavalry unit. Default values
     * for attack and defense are set to 20 and 12.
     *
     * @param name      The name of the unit.
     * @param health    Amount of health points, input under 0 will be converted to 0
     */
    public CavalryUnit(String name, int health){
        super(name,health,20,12);
    }


    /**
     * Returns attack bonus that is specific to
     * this type of unit. First time this unit
     * attacks, it has a great attack bonus, but
     * gets reduced on the next attacks.
     *
     * @return attack bonus
     */
    @Override
    public int getAttackBonus() {
        if(charge == 0){
            charge = 1;
            return 8;
        }else{
            return 3;
        }

    }

    /**
     * Returns defense bonus that is specific to
     * this type of unit.
     *
     * @return defense bonus
     */
    @Override
    public int getResistBonus() {
        return 1;
    }
}
