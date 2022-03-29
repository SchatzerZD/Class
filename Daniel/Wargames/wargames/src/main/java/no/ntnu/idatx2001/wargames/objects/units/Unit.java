package no.ntnu.idatx2001.wargames.objects.units;

/**
 * Represents a unit. A unit is an object
 * containing variables such as health points, attack points
 * and defense points,
 *
 * @author Daniel Ireneo Neri Saren
 * @version 1.0.2
 */
public abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

    /**
     * Constructor for a unit.
     *
     * @param name The name of the unit
     * @param health Amount of health points, input under 0 will be converted to 0
     * @param attack Amount of attack points
     * @param armor Amount of defense points
     */
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;

        if(health < 0){             //Converts any negative input of health to 0
            health = 0;
        }

        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Attacks an opponent, reducing their health. Their health
     * is reduced by this unit's attack power, and mitigated by their
     * defense points.
     *
     * @param opponent the unit that is going to be attacked
     */
    public void attack(Unit opponent){
        int newHealth = opponent.getHealth() - (this.getAttack() + this.getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        if(newHealth <= 0){
            newHealth = 0;
        }
        opponent.setHealth(newHealth);
    }

    /**
     * Returns the name of the unit
     *
     * @return name of the unit
     */
    public String getName() {
        return name;
    }

    /**
     * Returns amount of health
     *
     * @return health of unit
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns amount of attack points
     *
     * @return attack points
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns amount of armor points
     *
     * @return armor points
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Set the amount of health points of this unit
     *
     * @param health the amount of health the unit will have
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * toString method
     *
     * @return string in the form: Name | HP | Atk | Def
     */
    @Override
    public String toString() {
        return this.name + " " +
                "| HP: " + this.health + " " +
                "| Atk: " + this.attack + " " +
                "| Def: " + this.armor;
    }

    /**
     * Returns attack bonus that is specific to
     * this type of unit.
     *
     * @return attack bonus
     */
    public abstract int getAttackBonus();

    /**
     * Returns defense bonus that is specific to
     * this type of unit.
     *
     * @return defense bonus
     */
    public abstract int getResistBonus();


}
