package Tests;

import Army.Exceptions.UnitIsDeadException;
import Army.SpellCaster.Warlock;
import Army.Unit.Soldier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarlockTest {
    @Test
    public void checkDemonCreateRemove() throws UnitIsDeadException {
        Warlock wrl = new Warlock("Warlock", 100, 10, 100, 20);
        Soldier sl1 = new Soldier("sld1", 100, 10);

        wrl.createDemon();

        wrl.demonAttack(sl1);

        assertEquals(90, sl1.getHitPoints());
    }

}
