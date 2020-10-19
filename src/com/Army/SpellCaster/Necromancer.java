package Army.SpellCaster;

import Army.Exceptions.DeadAfterAttackException;
import Army.Exceptions.LowManaException;
import Army.Exceptions.NotEnoughManaException;
import Army.Exceptions.UnitIsDeadException;
import Army.Observer.Observer;
import Army.Race.Race;
import Army.Spell.*;
import Army.Unit.Unit;
import Army.Weapon.SpellCasterWeapon;

public class Necromancer extends SpellCaster implements Observer{
    public Necromancer(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower, double damageMultiplier, double healingMultiplier) {
        super(name, hitPointsLimit, damage, manaLimit, magicPower, damageMultiplier, healingMultiplier);

        this.race = Race.Undead;

        spellBook.put(Spells.FireBall, new FireBall(this));
        spellBook.put(Spells.Heal, new Heal(this));
        spellBook.put(Spells.FrostBall, new FrostBall(this));
        spellBook.put(Spells.GreatHeal, new GreatHeal(this));

        Spell tmp = spellBook.get(Spells.FireBall);
        if ( tmp != null ) {
            this.spell = tmp;
        }
    }

    public Necromancer(String name, int hitPointsLimit, int damage, int manaLimit, int magicPower) {
        this(name, hitPointsLimit, damage, manaLimit, magicPower, 1, 0.5);
    }

    @Override
    public void cast(Unit other) throws UnitIsDeadException, LowManaException, NotEnoughManaException, DeadAfterAttackException {
        super.cast(other);
        other.observables.addObserver(this);
    }

    @Override
    public void cast(Unit other, double multiplier) throws UnitIsDeadException, LowManaException, NotEnoughManaException, DeadAfterAttackException {
        super.cast(other, multiplier);
        other.observables.addObserver(this);
    }

    @Override
    public void attack(Unit other) throws UnitIsDeadException {
        super.attack(other);
        other.observables.addObserver(this);
    }

    @Override
    public void recieveMessage() {
        this.addHitPoints(this.getHitPointsLimit()/10);
    }
}
