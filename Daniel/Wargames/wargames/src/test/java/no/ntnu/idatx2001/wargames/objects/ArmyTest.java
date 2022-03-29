package no.ntnu.idatx2001.wargames.objects;

import no.ntnu.idatx2001.wargames.objects.units.InfantryUnit;
import no.ntnu.idatx2001.wargames.objects.units.RangedUnit;
import no.ntnu.idatx2001.wargames.objects.units.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    Army army;
    ArrayList<Unit> units = new ArrayList<>();
    InfantryUnit testInfantry = new InfantryUnit("TestInfantry",50);

    @BeforeEach
    void setUp() {
        units.add(new InfantryUnit("Infantry1",50));
        units.add(new InfantryUnit("Infantry2",50));
        units.add(new InfantryUnit("Infantry3",50));
        units.add(new RangedUnit("Ranged1",45));
        units.add(testInfantry);

        army = new Army("Army1",units);
    }

    @Test
    void getName() {
        Assertions.assertEquals("Army1",army.getName());
    }

    @Test
    void add() {
        InfantryUnit infantryUnit = new InfantryUnit("Infantry4",50);
        army.add(infantryUnit);
        Assertions.assertTrue(army.getAllUnits().contains(infantryUnit));
    }

    @Test
    void addAll() {
        ArrayList<Unit> testList = new ArrayList<Unit>();
        testList.add(new InfantryUnit("Infantry5",50));
        testList.add(new InfantryUnit("Infantry6",50));
        int beforeSize = army.getAllUnits().size();
        army.addAll(testList);

        Assertions.assertEquals(beforeSize+2,army.getAllUnits().size());
    }

    @Test
    void remove() {
        army.remove(testInfantry);
        Assertions.assertFalse(army.getAllUnits().contains(testInfantry));
    }

    @Test
    void hasUnits() {
        Assertions.assertTrue(army.hasUnits());
    }
}