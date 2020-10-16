package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.UnitIsDeadException;
import org.junit.jupiter.api.Test;

import Army.Unit.Berserker;

public class BerserkerTest {
    @Test
    public void mgicImmuneCheck() throws UnitIsDeadException {
        Berserker berserker = new Berserker("Berserker", 100, 10);
        berserker.takeMagicDamage(100);

        assertEquals(100, berserker.getHitPoints());
    }
}
