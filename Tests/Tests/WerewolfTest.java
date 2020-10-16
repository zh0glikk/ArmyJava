package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.UnitIsDeadException;
import Army.Unit.*;
import org.junit.jupiter.api.Test;

public class WerewolfTest {
    @Test
    public void werewolfWolfState() throws UnitIsDeadException {
        Werewolf werewolf = new Werewolf("werewolf", 100, 10);
        werewolf.toWolf();;

        assertEquals(200, werewolf.getHitPointsLimit());
        assertEquals(200, werewolf.getHitPoints());
        assertEquals(20, werewolf.getDamage());

        werewolf.takeMagicDamage(20);
        assertEquals(160, werewolf.getHitPoints());

    }
}
