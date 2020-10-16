package Army.Unit;

import Army.Mediator.InfectMediator;
import Army.Weapon.VampireWeapon;

public class Vampire extends Unit{
    public Vampire(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new VampireWeapon(this);
    }

    public void infect(Unit other) {
        this.mediator = new InfectMediator(this, other);
        this.mediator.notify(other, "Vampire Infect");
    }
}
