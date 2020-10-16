package Army.Unit;

import Army.Weapon.RogueWeapon;

public class Rogue extends Unit{
    public Rogue(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new RogueWeapon(this);
    }


}
