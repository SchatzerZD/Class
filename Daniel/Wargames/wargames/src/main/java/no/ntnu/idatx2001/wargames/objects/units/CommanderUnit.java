package no.ntnu.idatx2001.wargames.objects.units;

/**
 * Represents a commander unit. A commander unit
 * is basically a more capable cavalry unit, with
 * increased base attack and defense.
 *
 * @author Daniel Ireneo Neri Saren
 * @version 1.0.0
 */
public class CommanderUnit extends CavalryUnit{

    /**
     * Constructor for a commander cavalry unit.
     *
     * @param name   The name of the unit
     * @param health Amount of health points, input under 0 will be converted to 0
     * @param attack Amount of attack points
     * @param armor  Amount of defense points
     */
    public CommanderUnit(String name, int health, int attack, int armor){
        super(name,health,attack,armor);
    }

    /**
     * Constructor for a commander cavalry unit. Default values
     * for attack and defense are set to 25 and 15.
     *
     * @param name   The name of the unit.
     * @param health Amount of health points, input under 0 will be converted to 0
     */
    public CommanderUnit(String name, int health) {
        super(name, health,25,15);
    }
}
