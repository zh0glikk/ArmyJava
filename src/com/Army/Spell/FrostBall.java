package Army.Spell;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.UnitIsDeadException;
import Army.SpellCaster.SpellCaster;
import Army.Unit.Unit;

public class FrostBall extends Spell{
    public FrostBall(SpellCaster owner, int manaCost, int spellType) {
        super(owner, manaCost, spellType);
    }

    public FrostBall(SpellCaster owner) {
        this(owner, 20, 1);
    }

    @Override
    public void cast(Unit other) throws UnitIsDeadException, DeadAfterAttackException {
        other.takeMagicDamage((int) (owner.getMagicPower() * owner.getDamageMultiplier()));
        this.owner.addHitPoints(owner.getMagicPower()/10);
    }

    @Override
    public void cast(Unit other, double multiplier) throws UnitIsDeadException, DeadAfterAttackException {
        other.takeMagicDamage((int) (owner.getMagicPower() * owner.getDamageMultiplier() * multiplier));
        this.owner.addHitPoints(owner.getMagicPower()/10);
    }
}
