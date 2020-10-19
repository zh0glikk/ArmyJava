package Army.Unit;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.UnitIsDeadException;
import Army.Mediator.Mediator;
import Army.Observer.Observable;
import Army.State.State;
import Army.Weapon.Weapon;
import Army.Race.Race;

public abstract class Unit {
    protected State state;
    protected Weapon weapon;
    protected Race race;
    protected Mediator mediator;

    public Observable observables;

    public void ensureIsAlive() throws UnitIsDeadException {
        this.state.ensureIsALive();
    }

    public Unit(String name, int hitPointsLimit, int damage) {
        this.state = new State(name, hitPointsLimit, damage);
        this.race = Race.Human;
        this.mediator = null;
        observables = new Observable();
    }

    public int getHitPoints() {
        return this.state.getHitPoints();
    }

    public int getHitPointsLimit() {
        return this.state.getHitPointsLimit();
    }

    public int getDamage() {
        return this.state.getDamage();
    }

    public String getName() {
        return this.state.getName();
    }

    public Race getRace() { return  this.race; }

    public void takeDamage(int dmg) throws UnitIsDeadException, DeadAfterAttackException {
        this.state.takeDamage(dmg);
    }

    public void takeMagicDamage(int dmg) throws UnitIsDeadException, DeadAfterAttackException {
        this.state.takeMagicDamage(dmg);
    }

    public void addHitPoints(int hp) {
        this.state.addHitPoints(hp);
    }

    public void attack(Unit other) throws UnitIsDeadException {
        ensureIsAlive();
        try {
            this.weapon.attack(other);
        } catch (DeadAfterAttackException e) {
            other.observables.sendMessage();
        }
    }

    public void counterAttack(Unit other) throws UnitIsDeadException {
        ensureIsAlive();
        try {
            this.weapon.counterAttack(other);
        } catch (DeadAfterAttackException e) {
            other.observables.sendMessage();
        }
    }

    public void setRace(Race newRace) {
        this.race = newRace;
    }

    public void setWeapon(Weapon newWeapon) { this.weapon = newWeapon; }

    public void setState(State newState) { this.state = newState; }

    public void setMediator(Mediator mediator) { this.mediator = mediator; }


}
