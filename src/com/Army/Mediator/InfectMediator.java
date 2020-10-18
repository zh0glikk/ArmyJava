package Army.Mediator;

import Army.Exceptions.CantBeInfected;
import Army.Race.Race;
import Army.Unit.Unit;
import Army.Unit.Vampire;
import Army.Unit.Werewolf;
import Army.Weapon.VampireWeapon;
import Army.Weapon.WerewolfWeapon;

public class InfectMediator extends Mediator {
    private Unit u1;
    private Unit u2;

    public InfectMediator(Unit u1, Unit u2) {
        this.u1 = u1;
        this.u2 = u2;
        this.u1.setMediator(this);
        this.u2.setMediator(this);
    }

    @Override
    public void notify(Unit victim, String event) throws CantBeInfected {
        if (event == "Vampire Infect") {
            if ( victim instanceof Werewolf) {
                throw new CantBeInfected();
            }
            victim.setRace(Race.Undead);
            victim.setWeapon(new VampireWeapon(victim));
        } else if (event == "Werewolf Infect") {
            if ( victim instanceof Vampire) {
                throw new CantBeInfected();
            }
            victim.setWeapon(new WerewolfWeapon(victim));
        }
    }
}
