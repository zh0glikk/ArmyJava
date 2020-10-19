package Army.State;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.UnitIsDeadException;

public class State {
    private int hitPoints;
    private int hitPointsLimit;
    private int damage;
    private String name;

    public void ensureIsALive() throws UnitIsDeadException{
        if ( this.getHitPoints() <= 0 ) {
            throw new UnitIsDeadException();
        }
    }

    public State(String name, int hitPointsLimit, int damage) {
        this.name = name;
        this.hitPointsLimit = hitPointsLimit;
        this.hitPoints = hitPointsLimit;
        this.damage = damage;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public int getHitPointsLimit() {
        return this.hitPointsLimit;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }

    public void takeDamage(int dmg) throws UnitIsDeadException, DeadAfterAttackException {
        ensureIsALive();
        this.hitPoints -= dmg;

        if ( this.hitPoints < 0 ) {
            this.hitPoints = 0;
            throw new DeadAfterAttackException();
        }

    }

    public void takeMagicDamage(int dmg) throws UnitIsDeadException, DeadAfterAttackException {
        ensureIsALive();
        this.hitPoints -= dmg;

        if ( this.hitPoints < 0 ) {
            this.hitPoints = 0;
            throw new DeadAfterAttackException();
        }

    }

    public void addHitPoints(int hp) {
        this.hitPoints += hp;

        if (this.hitPoints > this.hitPointsLimit) {
            this.hitPoints = this.hitPointsLimit;
        }
    }
}
