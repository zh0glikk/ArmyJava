package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.UnitIsDeadException;
import Army.Unit.Vampire;
import Army.Unit.Soldier;
import org.junit.jupiter.api.Test;

public class VampireTest {
    @Test
    public void vampireAttack() throws UnitIsDeadException {
        Vampire vampire = new Vampire("Vampire", 100, 10);
        Soldier soldier = new Soldier("Soldier", 100, 10);

        soldier.attack(vampire);

        assertEquals(95, soldier.getHitPoints());
        assertEquals(92, vampire.getHitPoints());

        vampire.attack(soldier);

        assertEquals(85, soldier.getHitPoints());
        assertEquals(92, vampire.getHitPoints());

    }
}
