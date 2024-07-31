package console_game.util;

import console_game.characters.Attribute;

import java.util.Random;
import java.util.Scanner;

public class Util {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();

    public static boolean isDouble() {
        int randInt = random.nextInt(10) + 1;
        System.out.println(randInt);
        return randInt == 10;
    }

    public static Attribute getRandomAttribute() {
        Attribute[] attributes = {Attribute.STRENGTH, Attribute.AGILITY, Attribute.UNIVERSAL};
        return attributes[random.nextInt(attributes.length)];
    }

    public static Attribute selectAttribute() {
        Attribute attribute;
        switch (scan.nextInt()) {
            case 1:
                attribute = Attribute.STRENGTH;
                System.out.println("Выбран атрибут " + attribute.getTitle());
                return attribute;
            case 2:
                attribute = Attribute.AGILITY;
                System.out.println("Выбран атрибут " + attribute.getTitle());
                return attribute;
            case 3:
                attribute = Attribute.UNIVERSAL;
                System.out.println("Выбран атрибут " + attribute.getTitle());
                return attribute;
            default:
                attribute = getRandomAttribute();
                System.out.println("Выбран случайный атрибут: " + attribute.getTitle());
                return attribute;
        }
    }

}
