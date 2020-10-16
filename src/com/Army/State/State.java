package Army.State;

import Army.Exceptions.UnitIsDeadException;

public class State {
    private int hitPoints;
    private int hitPointsLimit;
    private int damage;
    private String name;

    private void ensureIsALive() throws UnitIsDeadException{
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

    public void takeDamage(int dmg) throws UnitIsDeadException {
        ensureIsALive();

        this.hitPoints -= dmg;

        if ( this.hitPoints < 0 ) {
            this.hitPoints = 0;
        }
    }

    public void takeMagicDamage(int dmg) throws UnitIsDeadException {
        ensureIsALive();
        this.hitPoints -= dmg;

        if ( this.hitPoints < 0 ) {
            this.hitPoints = 0;
        }
    }
}
