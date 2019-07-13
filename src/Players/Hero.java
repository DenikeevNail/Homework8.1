package Players;

import Game.Ability;
import Game.Boss.Boss;
import Game.GameEntity;

public abstract class Hero extends GameEntity implements HavingAbility {

    private Ability ability;

    public Hero(int health, int damage, Ability ability) {
        super(health, damage);
        this.ability = ability;
    }

    public Ability getAbility() {
        return ability;
    }

    public void putDamage(int damage) {
        super.setHealth(super.getHealth() - damage);
    }

}

