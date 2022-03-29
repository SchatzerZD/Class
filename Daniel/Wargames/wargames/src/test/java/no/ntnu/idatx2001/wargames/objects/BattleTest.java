package no.ntnu.idatx2001.wargames.objects;

import no.ntnu.idatx2001.wargames.objects.units.CavalryUnit;
import no.ntnu.idatx2001.wargames.objects.units.InfantryUnit;
import no.ntnu.idatx2001.wargames.objects.units.RangedUnit;
import no.ntnu.idatx2001.wargames.objects.units.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    Battle battle;
    Army army1;
    Army army2;

    @BeforeEach
    void setUp() {
        ArrayList<Unit> units1 = new ArrayList<>();
        units1.add(new InfantryUnit("Infantry1Army1",50));
        units1.add(new InfantryUnit("Infantry2Army1",50));
        units1.add(new InfantryUnit("Infantry3Army1",50));
        units1.add(new RangedUnit("Ranged1Army1",45));

        army1 = new Army("Army1",units1);

        ArrayList<Unit> units2 = new ArrayList<>();
        units2.add(new InfantryUnit("Infantry1Army2",50));
        units2.add(new InfantryUnit("Infantry2Army2",50));
        units2.add(new InfantryUnit("Infantry3Army2",50));
        units2.add(new RangedUnit("Ranged1Army2",45));
        units2.add(new CavalryUnit("Cavalry1Army2",43));

        army2 = new Army("Army2",units2);

        battle = new Battle(army1,army2);
    }

    @Test
    void simulate() {
        Army armyWin = battle.simulate();
        System.out.println("\n\n\n\n\n\n");
        System.out.println("WINNER:" + armyWin);
        Assertions.assertTrue(armyWin.equals(army1) || armyWin.equals(army2));
    }
}