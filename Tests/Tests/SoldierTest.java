package Tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Army.Exceptions.UnitIsDeadException;
import Army.Unit.Soldier;

public class SoldierTest {
    @Test
    public void soldierAttack() throws UnitIsDeadException {
        Soldier sl1 = new Soldier("sld1", 100, 10);
        Soldier sl2 = new Soldier("sld2", 100, 10);

        sl1.attack(sl2);

        assertEquals(95, sl1.getHitPoints());
        assertEquals(90, sl2.getHitPoints());

    }
    @Test
    public void checkHealing() throws UnitIsDeadException {
        Soldier sl1 = new Soldier("sld1", 100, 10);
        sl1.attack(sl1);

        assertEquals(85, sl1.getHitPoints());

        sl1.addHitPoints(10);

        assertEquals(95, sl1.getHitPoints());
    }

}
