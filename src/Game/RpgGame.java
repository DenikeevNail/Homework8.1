package Game;

import Game.Boss.Boss;
import Players.*;

public class RpgGame {


    public static void startGame() {
        Boss boss = new Boss(400, 30);
        Hero[] heroes = getHeroesArray();
        showStatistics(heroes, boss);
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes Won!!!");
            return true;
        }
        boolean allHeroesDied = true;

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss Won!!!");
        }
        return allHeroesDied;
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        showStatistics(heroes, boss);
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            int damageOfBoss = boss.getDamage();
            hero.setHealth(damageOfBoss);
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                int damageOfHero = hero.getDamage();
                boss.setHealth(boss.getHealth() - damageOfHero);
                hero.useAbility(heroes, boss);
            }

        }
        }

        private static Hero[] getHeroesArray () {
            Hero[] heroes = {new Warrior(100, 10),
                    new Magical(100, 10),
                    new Hunter(100, 10),
                    new Medical(100, 10)};
            return heroes;
        }

        private static void showStatistics (Hero[]heroes, Boss boss){
            System.out.println("____________________");
            System.out.println("Boss health = " + boss.getHealth());
            for (Hero hero : heroes) {
                System.out.println(" Hero " + hero.getClass().getSimpleName() + " health = " + hero.getHealth());
            }
            System.out.println("____________________");

        }

}
