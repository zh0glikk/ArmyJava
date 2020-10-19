package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Army.Exceptions.DeadAfterAttackException;
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
    public void takeDamage() throws UnitIsDeadException, DeadAfterAttackException {
        State st = new State("State", 100, 10);

        st.takeDamage(10);

        assertEquals(90, st.getHitPoints());

        st.takeMagicDamage(10);

        assertEquals(80, st.getHitPoints());
    }

    @Test
    public void zeroHpCase() throws UnitIsDeadException, DeadAfterAttackException {
        State st = new State("State", 100, 10);
        try {
            st.takeDamage(110);
        } catch (DeadAfterAttackException e) {
            System.out.println("dead after attack");
        }

        assertEquals(0, st.getHitPoints());

        try {
            st.takeDamage(110);
        } catch (UnitIsDeadException e) {
            System.out.println("unit is dead");
        }
    }
}
