package Army.Unit;

import Army.Exceptions.UnitIsDeadException;
import Army.Weapon.BerserkerWeapon;


public class Berserker extends Unit {
    public Berserker(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new BerserkerWeapon(this);
    }

    @Override
    public void takeMagicDamage(int dmg) throws UnitIsDeadException {
        super.takeMagicDamage(0);
    }
}
