package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.LowManaException;
import Army.Exceptions.NotEnoughManaException;
import Army.Exceptions.UnitIsDeadException;
import Army.Spell.Heal;
import Army.Spell.Spells;
import Army.SpellCaster.Wizard;
import Army.Unit.Soldier;
import org.junit.jupiter.api.Test;

public class WizardTest {
    @Test
    public void wizardContruktor() throws UnitIsDeadException, LowManaException, NotEnoughManaException {
        Wizard wz = new Wizard("Wizard", 100, 10, 100, 20);
        Soldier sld = new Soldier("Soldiaer", 100, 10);

        assertEquals(100, wz.getHitPointsLimit());
        assertEquals(1, wz.getDamageMultiplier());
        assertEquals(0.5, wz.getHealingMultiplier());
    }

    @Test
    public void castCheck() throws UnitIsDeadException, LowManaException, NotEnoughManaException {
        Wizard wz = new Wizard("Wizard", 100, 10, 100, 20);
        Soldier sld = new Soldier("Soldiaer", 100, 10);

        wz.cast(sld);

        assertEquals(80, sld.getHitPoints());
        assertEquals(90, wz.getMana());
    }

    @Test
    public void checkNoManaException() throws UnitIsDeadException, LowManaException, NotEnoughManaException {
        Wizard wz = new Wizard("Wizard", 100, 10, 100, 20);
        Soldier sld = new Soldier("Soldiaer", 100, 10);
        Soldier sld2 = new Soldier("Soldiaer", 100, 10);

        for ( int i = 0; i < 10; i++) {
            try {
                wz.cast(sld);
            }
            catch (UnitIsDeadException e) {
                System.out.println("Unit is dead");
            }
        }

        assertEquals(50, wz.getMana());

        for ( int i = 0; i < 10; i++) {
            try {
                wz.cast(sld2);
            }
            catch (UnitIsDeadException e) {
                System.out.println("Unit is dead");
            }
            catch (LowManaException e) {
                System.out.println("No mana");
            }
        }

        assertEquals(0, wz.getMana());
    }

    @Test
    public void checkHealing() throws UnitIsDeadException, LowManaException, NotEnoughManaException {
        Wizard wz = new Wizard("Wizard", 100, 10, 100, 20);
        Soldier sld = new Soldier("Soldiaer", 100, 10);

        wz.cast(sld);

        assertEquals(80, sld.getHitPoints());

        wz.changeSpell(Spells.Heal);

        wz.cast(sld);

        assertEquals(90, sld.getHitPoints());
    }

    @Test
    public void frostBallCheck() throws UnitIsDeadException, NotEnoughManaException, LowManaException {
        Wizard wz = new Wizard("Wizard", 100, 10, 100, 20);
        Soldier sld = new Soldier("Soldiaer", 100, 10);

        wz.attack(sld);

        wz.changeSpell(Spells.FrostBall);

        wz.cast(sld);

        assertEquals(97, wz.getHitPoints());
    }


}
