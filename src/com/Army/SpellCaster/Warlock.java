package Army.SpellCaster;

import Army.Exceptions.UnitIsDeadException;
import Army.Pets.Demon;
import Army.Spell.*;
import Army.Unit.Unit;

public class Warlock extends SpellCaster{
    private boolean isDemonExist;
    private Demon demon;


    public Warlock(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower, double damageMultiplier, double healingMultiplier) {
        super(name, hitPointsLimit, damage, manaLimit, magicPower, damageMultiplier, healingMultiplier);

        this.isDemonExist = false;
        this.demon = null;

        spellBook.put(Spells.FireBall, new FireBall(this));
        spellBook.put(Spells.Heal, new Heal(this));
        spellBook.put(Spells.FrostBall, new FrostBall(this));

        Spell tmp = spellBook.get(Spells.FireBall);
        if ( tmp != null ) {
            this.spell = tmp;
        }
    }

    public Warlock(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower) {
        this(name, hitPointsLimit, damage, manaLimit, magicPower, 1, 0.5);
    }

    public void createDemon() {
        if ( !isDemonExist ) {
            demon = new Demon("Demon", 50, 10, this);
            this.isDemonExist = true;
        }
    }

    public void removeDemon() {
        if ( isDemonExist ) {
            this.demon = null;
            this.isDemonExist = false;
        }
    }

    public void demonAttack(Unit other) throws UnitIsDeadException {
        if ( isDemonExist ) {
            this.demon.attack(other);
        }
    }
}
