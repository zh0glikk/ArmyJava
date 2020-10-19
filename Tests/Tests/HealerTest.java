package Tests;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.LowManaException;
import Army.Exceptions.NotEnoughManaException;
import Army.Exceptions.UnitIsDeadException;
import Army.Spell.Spells;
import Army.SpellCaster.Healer;
import Army.Unit.Soldier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealerTest {

    @Test
    public void healingCheck() throws UnitIsDeadException, LowManaException, NotEnoughManaException, DeadAfterAttackException {
        Soldier sld = new Soldier("Soldiaer", 100, 10);
        Healer hl = new Healer("Healer", 100, 10, 100, 20);

        hl.changeSpell(Spells.FireBall);

        hl.cast(sld);
        hl.cast(sld);
        hl.cast(sld);

        assertEquals(70, sld.getHitPoints());

        hl.changeSpell(Spells.Heal);

        hl.cast(sld);

        assertEquals(90, sld.getHitPoints());
    }

    @Test
    public void checkGreatHeal() throws UnitIsDeadException, LowManaException, NotEnoughManaException, DeadAfterAttackException {
        Soldier sld = new Soldier("Soldiaer", 100, 10);
        Healer hl = new Healer("Healer", 100, 10, 100, 20);

        hl.changeSpell(Spells.FireBall);

        hl.cast(sld);
        hl.cast(sld);
        hl.cast(sld);

        assertEquals(70, sld.getHitPoints());

        hl.changeSpell(Spells.GreatHeal);

        hl.cast(sld);

        assertEquals(100, sld.getHitPoints());
    }
}
