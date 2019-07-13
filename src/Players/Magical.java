package Players;

import Game.Ability;
import Game.Boss.Boss;

import java.util.Random;

public class Magical extends Hero {
    public Magical(int health, int damage) {
        super(health, damage, Ability.BOOST);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            Random r = new Random();
            int randomNum = r.nextInt(4) + 1;
            if (hero.getHealth() > 0) {
                hero.setDamage(hero.getDamage() + randomNum);
            }
        }
    }
}
