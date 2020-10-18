package Army.Unit;

import Army.Exceptions.CantBeInfected;
import Army.Mediator.InfectMediator;
import Army.Race.Race;
import Army.Weapon.VampireWeapon;

public class Vampire extends Unit{
    public Vampire(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new VampireWeapon(this);
        this.race = Race.Undead;
    }

    public void infect(Unit other) throws CantBeInfected {
        this.mediator = new InfectMediator(this, other);
        this.mediator.notify(other, "Vampire Infect");
    }
}
