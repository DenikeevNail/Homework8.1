package Players;

import Game.Ability;
import Game.Boss.Boss;
import Game.RpgGame;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_REVERT);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        if (getHealth() > 0) {
            setDamage(getDamage() + boss.getDamage());
        }
    }
}

