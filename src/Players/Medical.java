package Players;

import Game.Ability;
import Game.Boss.Boss;

public class Medical extends Hero {
    public Medical(int health, int damage) {
        super(health, damage, Ability.HEAL);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {

        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() + 5);
            }


        }
    }
}
