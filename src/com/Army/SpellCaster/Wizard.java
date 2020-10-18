package Army.SpellCaster;

import Army.Spell.*;

import java.util.HashMap;

public class Wizard extends SpellCaster{
    public Wizard(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower, double damageMultiplier, double healingMultiplier) {
        super(name, hitPointsLimit, damage, manaLimit, magicPower, damageMultiplier, healingMultiplier);

        spellBook.put(Spells.FireBall, new FireBall(this));
        spellBook.put(Spells.Heal, new Heal(this));
        spellBook.put(Spells.FrostBall, new FrostBall(this));

        Spell tmp = spellBook.get(Spells.FireBall);
        if ( tmp != null ) {
            this.spell = tmp;
        }
    }

    public Wizard(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower) {
        this(name, hitPointsLimit, damage, manaLimit, magicPower, 1, 0.5);
    }
}
