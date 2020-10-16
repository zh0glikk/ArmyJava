package Army.Unit;

import Army.Unit.Unit;
import Army.Weapon.BerserkerWeapon;


public class Berserker extends Unit {
    public Berserker(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new BerserkerWeapon(this);
    }
}
