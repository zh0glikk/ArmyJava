package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.LowManaException;
import Army.Exceptions.NotEnoughManaException;
import Army.Exceptions.UnitIsDeadException;
import Army.Spell.Spells;
import Army.SpellCaster.Priest;
import Army.Unit.Vampire;
import org.junit.jupiter.api.Test;

public class PriestTest {
    @Test
    public void priestAttackCheck() throws UnitIsDeadException, LowManaException, NotEnoughManaException, DeadAfterAttackException {
        Priest pr = new Priest("Priest", 100, 10, 100, 20);
        Vampire vampire = new Vampire("Vampire", 100, 10);

        pr.attack(vampire);

        assertEquals(92, vampire.getHitPoints());

        pr.cast(vampire);

        assertEquals(72, vampire.getHitPoints());
    }

}
