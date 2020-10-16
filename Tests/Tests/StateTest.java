package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.UnitIsDeadException;
import org.junit.jupiter.api.Test;

import Army.State.State;

public class StateTest {

    @Test
    public void constuktorTest() {
        State st = new State("State", 100, 10);

        assertEquals("State", st.getName());
        assertEquals(100, st.getHitPointsLimit());
        assertEquals(10, st.getDamage());
        assertEquals(100, st.getHitPoints());
    }

    @Test
    public void takeDamage() throws UnitIsDeadException {
        State st = new State("State", 100, 10);

        st.takeDamage(10);

        assertEquals(90, st.getHitPoints());

        st.takeMagicDamage(10);

        assertEquals(80, st.getHitPoints());
    }

    @Test
    public void zeroHpCase() throws UnitIsDeadException {
        State st = new State("State", 100, 10);
        st.takeDamage(110);

        assertEquals(0, st.getHitPoints());
    }
}
