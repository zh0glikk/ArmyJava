package Army.Spell;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.UnitIsDeadException;
import Army.SpellCaster.SpellCaster;
import Army.Unit.Unit;

public abstract class Spell {
    protected SpellCaster owner;
    protected int manaCost;
    protected int spellType; // 1 - attack, 0 - healing

    public Spell(SpellCaster owner, int manaCost, int spellType) {
        this.owner = owner;
        this.manaCost = manaCost;
        this.spellType = spellType;
    }

    public Spell(SpellCaster owner) {
        this(owner, 10, 1);
    }

    public void cast(Unit other) throws UnitIsDeadException, DeadAfterAttackException {
        other.takeMagicDamage((int) (owner.getMagicPower() * owner.getDamageMultiplier()));
    }

    public void cast(Unit other, double multiplier) throws UnitIsDeadException, DeadAfterAttackException {
        other.takeMagicDamage((int) (owner.getMagicPower() * owner.getDamageMultiplier() * multiplier));
    }

    public int getManaCost() {
        return this.manaCost;
    }

    public int getSpellType() { return this.spellType; }
}
