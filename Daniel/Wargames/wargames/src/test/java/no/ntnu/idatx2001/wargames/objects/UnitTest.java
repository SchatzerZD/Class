package no.ntnu.idatx2001.wargames.objects;

import no.ntnu.idatx2001.wargames.objects.units.CavalryUnit;
import no.ntnu.idatx2001.wargames.objects.units.CommanderUnit;
import no.ntnu.idatx2001.wargames.objects.units.InfantryUnit;
import no.ntnu.idatx2001.wargames.objects.units.RangedUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTest {
    InfantryUnit infantryUnit;
    RangedUnit rangedUnit;
    CavalryUnit cavalryUnit;
    CommanderUnit commanderUnit;

    @BeforeEach
    void setUp() {
        infantryUnit = new InfantryUnit("Infantry",50);
        rangedUnit = new RangedUnit("Ranged",46);
        cavalryUnit = new CavalryUnit("Cavalry", 40);
        commanderUnit = new CommanderUnit("Commander",52);
    }

    @Test
    void attack(){
        infantryUnit.attack(rangedUnit);
        Assertions.assertEquals(43,rangedUnit.getHealth());
        infantryUnit.attack(rangedUnit);
        Assertions.assertEquals(37,rangedUnit.getHealth());
        infantryUnit.attack(rangedUnit);
        Assertions.assertEquals(27,rangedUnit.getHealth());

        rangedUnit.attack(infantryUnit);
        Assertions.assertEquals(41,infantryUnit.getHealth());

        cavalryUnit.attack(infantryUnit);
        Assertions.assertEquals(25,infantryUnit.getHealth());
        cavalryUnit.attack(infantryUnit);
        Assertions.assertEquals(14,infantryUnit.getHealth());
    }

    @Test
    void getName() {
        Assertions.assertEquals("Infantry",infantryUnit.getName());
        Assertions.assertEquals("Ranged",rangedUnit.getName());
        Assertions.assertEquals("Cavalry",cavalryUnit.getName());
        Assertions.assertEquals("Commander",commanderUnit.getName());
    }

    @Test
    void getHealth() {
        Assertions.assertEquals(50,infantryUnit.getHealth());
        Assertions.assertEquals(46,rangedUnit.getHealth());
        Assertions.assertEquals(40,cavalryUnit.getHealth());
        Assertions.assertEquals(52,commanderUnit.getHealth());
    }

    @Test
    void getAttack() {
        Assertions.assertEquals(15,infantryUnit.getAttack());
        Assertions.assertEquals(15,rangedUnit.getAttack());
        Assertions.assertEquals(20,cavalryUnit.getAttack());
        Assertions.assertEquals(25,commanderUnit.getAttack());
    }

    @Test
    void getArmor() {
        Assertions.assertEquals(10,infantryUnit.getArmor());
        Assertions.assertEquals(8,rangedUnit.getArmor());
        Assertions.assertEquals(12,cavalryUnit.getArmor());
        Assertions.assertEquals(15,commanderUnit.getArmor());
    }

    @Test
    void setHealth(){
        infantryUnit.setHealth(40);
        Assertions.assertEquals(40,infantryUnit.getHealth());
    }

    @Test
    void getAttackBonus(){
        Assertions.assertEquals(8,cavalryUnit.getAttackBonus());
        Assertions.assertEquals(3,cavalryUnit.getAttackBonus());
    }

    @Test
    void getResistBonus(){
        Assertions.assertEquals(8,rangedUnit.getResistBonus());
        infantryUnit.attack(rangedUnit);
        Assertions.assertEquals(5,rangedUnit.getResistBonus());
    }
}