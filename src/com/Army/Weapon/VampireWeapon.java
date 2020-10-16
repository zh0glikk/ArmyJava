package Army.Weapon;

import Army.Exceptions.UnitIsDeadException;
import Army.Unit.Unit;
import Army.Weapon.Weapon;

public class VampireWeapon extends Weapon{
    public VampireWeapon(Unit owner) {
        super(owner);
    }

    @Override
    public void attack(Unit other) throws UnitIsDeadException {
        this.owner.addHitPoints(this.owner.getDamage()/2);
        super.attack(other);
    }

    @Override
    public void counterAttack(Unit other) throws UnitIsDeadException {
        this.owner.addHitPoints(this.owner.getDamage()/4);
        super.counterAttack(other);
    }
}
