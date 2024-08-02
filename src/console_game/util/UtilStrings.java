package console_game.util;

import console_game.actions.PlayerActions;
import console_game.characters.Attribute;

public class UtilStrings {
    public static String playerMove;
    public static String botMove;

    public static void printMenu() {
        System.out.println("Выбери желаемый атрибут:");
        System.out.println("1. " + Attribute.STRENGTH.getTitle() + ": " + Attribute.STRENGTH.getInformationAboutAttribute());
        System.out.println("2. " + Attribute.AGILITY.getTitle() + ": " + Attribute.AGILITY.getInformationAboutAttribute());
        System.out.println("3. " + Attribute.UNIVERSAL.getTitle() + ": " + Attribute.UNIVERSAL.getInformationAboutAttribute());
        System.out.println("4. Выбрать случайный атрибут");
        System.out.println("0. Выход");
        Util.initPlayers();
        printStartGame();
    }

    public static void printStartGame() {
        System.out.println("Атрибут противника: " + Util.bot.getAttribute().getTitle());
        System.out.println("\nИгра началась");
        chooseAction();
    }

    public static void chooseAction() {
        System.out.println("\nВыбери действие:");
        System.out.println("1. Атаковать");
        System.out.println("2. Блокировать");
        System.out.println("3. Использовать способность");
        PlayerActions.playerAction();
    }

    public static void printResultsOfTheMove() {
        String turns = playerMove + "\n" + botMove;
        String healthStatus = "У тебя осталось: " + Util.player.getHealthPoints() + " хп\n" +
                "У бота осталось: " + Util.bot.getHealthPoints() + " хп";

        System.out.println("\nИтоги хода:");
        System.out.println(turns);
        System.out.println(healthStatus);

        if (Util.player.getHealthPoints() <= 0 || Util.bot.getHealthPoints() <= 0) {
            if (Util.player.getHealthPoints() <= 0 && Util.bot.getHealthPoints() <= 0) {
                System.out.println("Ничья.");
            } else if (Util.bot.getHealthPoints() <= 0) {
                System.out.println("Ты победил бота!");
            } else {
                System.out.println("Ты проиграл.");
            }
            System.exit(0);
        }
        chooseAction();
    }
}
