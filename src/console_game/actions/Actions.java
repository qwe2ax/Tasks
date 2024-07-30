package console_game.actions;

import console_game.characters.Bot;
import console_game.characters.Character;

import java.util.Random;

public class Actions {

    static boolean block = false;
    static Random random = new Random();

    public static void attack(int minAttack, int maxAttack, Character opponent) {
        int damageFromAttack = random.nextInt((maxAttack) + minAttack);
        if (!block) {
            loseHp(damageFromAttack);
            return;
        }
        loseHp((int) (damageFromAttack * opponent.getBlockPercentage()));
    }

    public static void block() {
        block = true;
    }

    public static void loseHp(int damage) {
        Bot bot = new Bot();
        bot.setHealthPoints(bot.getHealthPoints() - damage);
    }



}
