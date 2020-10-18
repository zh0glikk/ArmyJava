package Army.SpellCaster;

import Army.Exceptions.LowManaException;
import Army.Exceptions.NotEnoughManaException;
import Army.Exceptions.UnitIsDeadException;
import Army.Spell.FireBall;
import Army.Spell.Heal;
import Army.Spell.Spell;
import Army.Spell.Spells;
import Army.State.MagicState;
import Army.Unit.Unit;
import Army.Weapon.SpellCasterWeapon;

import java.util.HashMap;
import java.util.Map;

public abstract class SpellCaster extends Unit {
    protected MagicState magicState;
    protected Spell spell;
    protected Map<Spells, Spell> spellBook = new HashMap<Spells, Spell>();

    private void ensureCanCast() throws LowManaException {
        this.magicState.ensureCanCast();
    }

    public SpellCaster(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower, double damageMultiplier, double healingMultiplier) {
        super(name, hitPointsLimit, damage);
        this.magicState = new MagicState(manaLimit, magicPower, damageMultiplier, healingMultiplier);
        this.weapon = new SpellCasterWeapon(this);
    }

    public int getMana() {
        return this.magicState.getMana();
    }

    public int getManaLimit() {
        return this.magicState.getManaLimit();
    }

    public int getMagicPower() {
        return this.magicState.getMagicPower();
    }

    public double getDamageMultiplier() {
        return this.magicState.getDamageMultiplier();
    }

    public double getHealingMultiplier() {
        return this.magicState.getHealingMultiplier();
    }

    public void setMana(int value) {
        this.magicState.setMana(value);
    }

    public int getManaCost() {
        return this.spell.getManaCost();
    }

    public void cast(Unit other) throws UnitIsDeadException, LowManaException, NotEnoughManaException {
        ensureCanCast();

        if ( this.getMana() >= this.getManaCost()) {
            this.spell.cast(other);
            this.setMana(this.getMana() - this.getManaCost());
        } else {
            throw new NotEnoughManaException();
        }
    }

    public void cast(Unit other, double multiplier) throws UnitIsDeadException, LowManaException, NotEnoughManaException {
        ensureCanCast();

        if ( this.getMana() >= this.getManaCost()) {
            this.spell.cast(other, multiplier);
            this.setMana(this.getMana() - this.getManaCost());
        } else {
            throw new NotEnoughManaException();
        }
    }


    public void changeSpell(Spells spellName) {
        Spell tmp = this.spellBook.get(spellName);
        if ( tmp != null ) {
            this.spell = tmp;
        }
    }
}
