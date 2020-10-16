package Army.Weapon;

import Army.Exceptions.UnitIsDeadException;
import Army.Unit.Unit;

public abstract class Weapon {
    protected Unit owner;

    public Weapon(Unit owner) {
        this.owner = owner;
    }

    public void attack(Unit other) throws UnitIsDeadException {
        other.takeDamage(this.owner.getDamage());

        if ( other.getHitPoints() > 0 ) {
            other.counterAttack(this.owner);
        }
    }

    public void counterAttack(Unit other) throws UnitIsDeadException {
        other.takeDamage(this.owner.getDamage()/2);
    }
}
