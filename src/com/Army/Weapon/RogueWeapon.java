package Army.Weapon;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.UnitIsDeadException;
import Army.Unit.Unit;

public class RogueWeapon extends Weapon{
    public RogueWeapon(Unit owner) {
        super(owner);
    }

    @Override
    public void attack(Unit other) throws UnitIsDeadException, DeadAfterAttackException {
        other.takeDamage(this.owner.getDamage());
    }
}
