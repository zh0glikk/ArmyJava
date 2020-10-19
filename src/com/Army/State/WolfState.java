package Army.State;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.UnitIsDeadException;
import Army.State.State;

public class WolfState extends State {
    public WolfState(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit*2, damage*2);
    }

    @Override
    public void takeMagicDamage(int dmg) throws UnitIsDeadException, DeadAfterAttackException {
        super.takeMagicDamage(dmg*2);
    }
}
