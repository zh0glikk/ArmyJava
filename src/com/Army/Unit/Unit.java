package Army.Unit;

import Army.Exceptions.UnitIsDeadException;
import Army.State.State;
import Army.Weapon.Weapon;
import Army.Race.Race;

public abstract class Unit {
    protected State state;
    protected Weapon weapon;
    protected Race race;

    public Unit(String name, int hitPointsLimit, int damage) {
        this.state = new State(name, hitPointsLimit, damage);
        race = Race.Human;
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

    public void takeDamage(int dmg) throws UnitIsDeadException {
        this.state.takeDamage(dmg);
    }

    public void takeMagicDamage(int dmg) throws UnitIsDeadException {
        this.state.takeMagicDamage(dmg);
    }

    public void attack(Unit other) throws UnitIsDeadException {
        this.weapon.attack(other);
    }

    public void counterAttack(Unit other) throws UnitIsDeadException {
        this.weapon.counterAttack(other);
    }

    public void changeRace(Race newRace) {
        this.race = newRace;
    }

}