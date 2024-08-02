package console_game.util;

import console_game.characters.Attribute;
import console_game.characters.Hero;

import java.util.Random;
import java.util.Scanner;

public class Util {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    public static Hero player;
    public static Hero bot;

    public static void initPlayers() {
        player = new Hero(Attribute.selectAttribute(), false);
        bot = new Hero(Attribute.getRandomAttribute(), true);
    }

    public static boolean isDouble() {
        int randInt = random.nextInt(10) + 1;
        System.out.println(randInt);
        return randInt == 10;
    }

    public static Hero getAnotherPlayer(Hero p) {
        return p.isBot() ? Util.player : Util.bot;
    }

    public static boolean isBotAbilityActive() {
        return bot.isDoubleDamageNextTurn() || bot.isAttackAndBlock() || bot.isReduceDamage();
    }

    public static boolean isPlayerAbilityActive() {
        return player.isDoubleDamageNextTurn() || player.isAttackAndBlock() || player.isReduceDamage();
    }
}
