package Tests;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.LowManaException;
import Army.Exceptions.NotEnoughManaException;
import Army.Exceptions.UnitIsDeadException;
import Army.SpellCaster.Necromancer;
import Army.Unit.Soldier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NecromancerTest {
    @Test
    public void necromancerHealingTest() throws UnitIsDeadException, NotEnoughManaException, LowManaException, DeadAfterAttackException {
        Necromancer necromancer = new Necromancer("Necromancer", 100, 10, 100, 20);
        Soldier sl1 = new Soldier("sld1", 100, 10);

        necromancer.attack(sl1);

        assertEquals(90, sl1.getHitPoints());
        assertEquals(95, necromancer.getHitPoints());

        necromancer.cast(sl1);
        necromancer.cast(sl1);
        necromancer.cast(sl1);
        necromancer.cast(sl1);
        necromancer.cast(sl1);

        assertEquals(0, sl1.getHitPoints());
        assertEquals(100, necromancer.getHitPoints());

        try {
            sl1.attack(necromancer);
        } catch (UnitIsDeadException e) {
            System.out.println("unit is dead");
        }
        assertEquals(100, necromancer.getHitPoints());

    }
}
