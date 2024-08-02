package console_game.util;

import console_game.characters.Attribute;
import console_game.characters.Hero;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Util {
    public static String path = "resources/myApp.properties";
    private static Properties properties = new Properties();
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    public static Hero player;
    public static Hero bot;

    public static String getPropertyValue(String key) {
        try (FileInputStream inputStream =  new FileInputStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }

    public static void initPlayers() {
        int baseHP = Integer.parseInt(getPropertyValue("hero.health_points"));
        int minDamage = Integer.parseInt(getPropertyValue("hero.min_damage"));
        int maxDamage = Integer.parseInt(getPropertyValue("hero.max_damage"));
        final double blockPercentage = Double.parseDouble(getPropertyValue("hero.block_percent"));
        player = new Hero(Attribute.selectAttribute(), false, baseHP, minDamage, maxDamage, blockPercentage);
        bot = new Hero(Attribute.getRandomAttribute(), true, baseHP, minDamage, maxDamage, blockPercentage);
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
