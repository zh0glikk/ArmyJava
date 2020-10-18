package Army.Spell;

import Army.SpellCaster.SpellCaster;

public class FireBall extends Spell{
    public FireBall(SpellCaster owner, int manaCost, int spellType) {
        super(owner, manaCost, spellType);
    }

    public FireBall(SpellCaster owner) {
        this(owner, 10, 1);
    }
}
