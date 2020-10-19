package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.CantBeInfected;
import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.UnitIsDeadException;
import Army.Unit.*;
import org.junit.jupiter.api.Test;

public class WerewolfTest {
    @Test
    public void werewolfWolfState() throws UnitIsDeadException, DeadAfterAttackException {
        Werewolf werewolf = new Werewolf("werewolf", 100, 10);
        werewolf.toWolf();;

        assertEquals(200, werewolf.getHitPointsLimit());
        assertEquals(200, werewolf.getHitPoints());
        assertEquals(20, werewolf.getDamage());

        werewolf.takeMagicDamage(20);
        assertEquals(160, werewolf.getHitPoints());

    }

    @Test
    public void werewolfInfect() throws CantBeInfected {
        Vampire vampire = new Vampire("Vampire", 100, 10);
        Werewolf werewolf = new Werewolf("Werewolf", 100, 10);
        Soldier soldier = new Soldier("Soldier", 100, 10);

        try {
            werewolf.infect(vampire);
        } catch (CantBeInfected ex) {
            System.out.println("Can be infected\n");
        }

        werewolf.infect(soldier);
    }
}
