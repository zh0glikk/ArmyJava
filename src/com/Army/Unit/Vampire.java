package Army.Unit;

import Army.Exceptions.UnitIsDeadException;
import Army.Unit.Unit;
import Army.Weapon.VampireWeapon;

public class Vampire extends Unit{
    public Vampire(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new VampireWeapon(this);
    }
}
