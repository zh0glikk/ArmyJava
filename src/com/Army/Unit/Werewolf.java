package Army.Unit;

import Army.Exceptions.CantBeInfected;
import Army.Mediator.InfectMediator;
import Army.State.State;
import Army.State.WolfState;
import Army.Weapon.WerewolfWeapon;

public class Werewolf extends Unit {
    private boolean isWolf;

    public Werewolf(String name, int hitPointsLimit, int damage) {
        super(name, hitPointsLimit, damage);
        this.weapon = new WerewolfWeapon(this);
        isWolf = false;
    }

    public void toWolf() {
        if ( !isWolf ) {
            this.setState(new WolfState(this.getName(), this.getHitPointsLimit(), this.getDamage()));
            isWolf = true;
        } else {
            this.setState(new State(this.getName(), this.getHitPointsLimit()/2, this.getDamage()/2));
            isWolf = false;
        }
    }

    public void infect(Unit other) throws CantBeInfected {
        this.mediator = new InfectMediator(this, other);
        this.mediator.notify(other, "Werewolf Infect");
    }
}
