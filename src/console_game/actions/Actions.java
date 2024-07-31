package console_game.actions;

import console_game.characters.Character;
import console_game.util.Util;

import java.util.Random;

public class Actions {

    static boolean block = false;

    public static void attack(int damageFromAttack, Character opponent) {
        if (!block) {
            makeDamage(damageFromAttack, opponent);
            return;
        }
        makeDamage((int) (damageFromAttack * opponent.getBlockPercentage()), opponent);
        block = false;
    }

    public static void block() {
        block = true;
    }

    public static void makeDamage(int damage, Character opponent) {
        opponent.setHealthPoints(opponent.getHealthPoints() - damage);
    }



}
