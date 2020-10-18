package Army.Unit;

import Army.Exceptions.UnitIsDeadException;
import Army.Mediator.Mediator;
import Army.State.State;
import Army.Weapon.Weapon;
import Army.Race.Race;

public abstract class Unit {
    protected State state;
    protected Weapon weapon;
    protected Race race;
    protected Mediator mediator;

    public Unit(String name, int hitPointsLimit, int damage) {
        this.state = new State(name, hitPointsLimit, damage);
        this.race = Race.Human;
        this.mediator = null;
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

    public void takeDamage(int dmg) throws UnitIsDeadException {
        this.state.takeDamage(dmg);
    }

    public void takeMagicDamage(int dmg) throws UnitIsDeadException {
        this.state.takeMagicDamage(dmg);
    }

//    public void takeMagicDamage(int dmg, double multiplier) throws UnitIsDeadException {
//        this.takeMagicDamage((int) (dmg * multiplier));
//    }

    public void addHitPoints(int hp) {
        this.state.addHitPoints(hp);
    }

    public void attack(Unit other) throws UnitIsDeadException {
        this.weapon.attack(other);
    }

    public void counterAttack(Unit other) throws UnitIsDeadException {
        this.weapon.counterAttack(other);
    }

    public void setRace(Race newRace) {
        this.race = newRace;
    }

    public void setWeapon(Weapon newWeapon) { this.weapon = newWeapon; }

    public void setState(State newState) { this.state = newState; }

    public void setMediator(Mediator mediator) { this.mediator = mediator; }


}
