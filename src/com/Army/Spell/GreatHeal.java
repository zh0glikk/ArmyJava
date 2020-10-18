package Army.Spell;

import Army.Exceptions.UnitIsDeadException;
import Army.SpellCaster.SpellCaster;
import Army.Unit.Unit;

public class GreatHeal extends Spell{
    public GreatHeal(SpellCaster owner, int manaCost, int spellType) {
        super(owner, manaCost, spellType);
    }

    public GreatHeal(SpellCaster owner) {
        this(owner, 20, 0);
    }

    @Override
    public void cast(Unit other) throws UnitIsDeadException {
        other.addHitPoints((int) (owner.getMagicPower() * owner.getHealingMultiplier() * 2));
    }

    @Override
    public void cast(Unit other, double multiplier) throws UnitIsDeadException {
        other.addHitPoints((int) (owner.getMagicPower() * owner.getHealingMultiplier() * 2 * multiplier));
    }
}
