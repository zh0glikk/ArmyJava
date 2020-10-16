package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Army.Exceptions.UnitIsDeadException;
import Army.Unit.Rogue;

public class RogueTest {
    @Test
    public void rogueAttack() throws UnitIsDeadException {
        Rogue rog1 = new Rogue("Rogue_1", 100, 10);
        Rogue rog2 = new Rogue("Rogue_2", 100, 10);

        rog1.attack(rog2);

        assertEquals(90, rog2.getHitPoints());
        assertEquals(100, rog1.getHitPoints());

    }
}
