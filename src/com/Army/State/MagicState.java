package Army.State;

import Army.Exceptions.LowManaException;

public class MagicState {
    private int mana;
    private int manaLimit;
    private int magicPower;
    private double damageMultiplier;
    private double healingMultiplier;

    public void ensureCanCast() throws LowManaException {
        if ( this.mana <= 0 ) {
            this.mana = 0;
            throw new LowManaException();
        }
    }

    public MagicState(int manaLimit, int magicPower, double damageMultiplier, double healingMultiplier) {
        this.manaLimit = manaLimit;
        this.mana = manaLimit;
        this.magicPower = magicPower;
        this.damageMultiplier = damageMultiplier;
        this.healingMultiplier = healingMultiplier;
    }

    public int getMana() {
        return this.mana;
    }

    public int getManaLimit() {
        return this.manaLimit;
    }

    public int getMagicPower() {
        return this.magicPower;
    }

    public double getDamageMultiplier() {
        return this.damageMultiplier;
    }

    public double getHealingMultiplier() {
        return this.healingMultiplier;
    }

    public void setMana(int value) {
        this.mana = value;
    }
}
