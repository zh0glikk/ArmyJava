package Army.Unit;

import Army.Exceptions.UnitIsDeadException;
import Army.Weapon.SoldierWeapon;

public class Soldier extends Unit {
    public Soldier(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new SoldierWeapon(this);
    }
}
