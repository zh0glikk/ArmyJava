package Army.Spell;

import Army.Exceptions.UnitIsDeadException;
import Army.SpellCaster.SpellCaster;
import Army.Unit.Unit;

public class Heal extends Spell{
    public Heal(SpellCaster owner, int manaCost, int spellType) {
        super(owner, manaCost, spellType);
    }

    public Heal(SpellCaster owner) {
        this(owner, 15, 0);
    }

    @Override
    public void cast(Unit other) throws UnitIsDeadException {
        other.addHitPoints((int) (owner.getMagicPower() * owner.getHealingMultiplier()));
    }

    @Override
    public void cast(Unit other, double multiplier) throws UnitIsDeadException {
        other.addHitPoints((int) (owner.getMagicPower() * owner.getHealingMultiplier() * multiplier));
    }
}
