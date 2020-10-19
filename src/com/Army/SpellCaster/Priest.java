package Army.SpellCaster;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.LowManaException;
import Army.Exceptions.NotEnoughManaException;
import Army.Exceptions.UnitIsDeadException;
import Army.Race.Race;
import Army.Spell.*;
import Army.Unit.Unit;

public class Priest extends SpellCaster{
    public Priest(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower, double damageMultiplier, double healingMultiplier) {
        super(name, hitPointsLimit, damage, manaLimit, magicPower, damageMultiplier, healingMultiplier);

        spellBook.put(Spells.FireBall, new FireBall(this));
        spellBook.put(Spells.Heal, new Heal(this));
        spellBook.put(Spells.FrostBall, new FrostBall(this));
        spellBook.put(Spells.GreatHeal, new GreatHeal(this));

        Spell tmp = spellBook.get(Spells.FireBall);
        if ( tmp != null ) {
            this.spell = tmp;
        }
    }

    public Priest(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower) {
        this(name, hitPointsLimit, damage, manaLimit, magicPower, 0.5, 1);
    }

    @Override
    public void cast(Unit other) throws UnitIsDeadException, LowManaException, NotEnoughManaException, DeadAfterAttackException {
        if ( other.getRace() == Race.Undead) {
            if ( this.spell.getSpellType() == 1 ) {
                super.cast(other, 2);
            } else {
                super.cast(other, 0);
            }
        } else {
            super.cast(other);
        }
    }
}
