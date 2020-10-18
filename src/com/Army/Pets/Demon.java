package Army.Pets;

import Army.SpellCaster.SpellCaster;
import Army.Unit.Soldier;

public class Demon extends Soldier {
    private SpellCaster owner;

    public Demon(String name, int hitPointsLimit, int damage, SpellCaster owner) {
        super(name, hitPointsLimit, damage);
        this.owner = owner;
    }
}
