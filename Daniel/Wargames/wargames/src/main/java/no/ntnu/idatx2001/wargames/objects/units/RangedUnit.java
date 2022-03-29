package no.ntnu.idatx2001.wargames.objects.units;

/**
 * Represents a ranged unit. A ranged unit is a unit
 * that excels at ranged combat, having the advantage of
 * distance between them and the opponent.
 *
 * @author Daniel Ireneo Neri Saren
 * @version 1.0.0
 */
public class RangedUnit extends Unit{
    private final int startHealth;

    /**
     * Constructor for a ranged unit.
     *
     * @param name   The name of the unit
     * @param health Amount of health points, input under 0 will be converted to 0
     * @param attack Amount of attack points
     * @param armor  Amount of defense points
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
        this.startHealth = health;
    }

    /**
     * Constructor for a ranged unit.Default values
     * for attack and defense are set to 15 and 8.
     *
     * @param name      The name of the unit
     * @param health    Amount of health points, input under 0 will be converted to 0
     */
    public RangedUnit(String name, int health){
        super(name,health,15,8);
        this.startHealth = health;
    }

    /**
     * Returns attack bonus that is specific to
     * this type of unit.
     *
     * @return attack bonus
     */
    @Override
    public int getAttackBonus() {
        return 6;
    }

    /**
     * Returns defense bonus that is specific to
     * this type of unit. The defense bonus varies
     * on the amount of times this unit has been attacked
     * and how much damage that has been inflicted.
     *
     * @return defense bonus
     */
    @Override
    public int getResistBonus() {
        if(8 - (this.startHealth - this.getHealth()) <= 0){
            return 1;
        }else{
            return 8 - (this.startHealth - this.getHealth());
        }
    }
}
