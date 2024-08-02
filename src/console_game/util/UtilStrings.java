package console_game.util;

import console_game.actions.PlayerActions;
import console_game.characters.Attribute;

public class UtilStrings {
    public static String playerMove;
    public static String botMove;
    public static void printMenu() {
        System.out.println("Выбери желаемый атрибут:\n" +
                "1. " + Attribute.STRENGTH.getTitle() + ": " + Attribute.STRENGTH.getInformationAboutAttribute() + "\n" +
                "2. " + Attribute.AGILITY.getTitle() + ": " + Attribute.AGILITY.getInformationAboutAttribute() + "\n" +
                "3. " + Attribute.UNIVERSAL.getTitle() + ": " + Attribute.UNIVERSAL.getInformationAboutAttribute() + "\n" +
                "4. " + "Выбрать случайный атрибут\n" +
                "0. Exit"
        );
    }

    public static void printStartGame() {
        System.out.println("Атрибут противника: " + Util.bot.getAttribute().getTitle() + "\n" +
                "Игра началась");
        chooseAction();
    }

    public static void chooseAction() {
        System.out.println("Выбери действие:\n" +
                "1. Атаковать\n" +
                "2. Блокировать\n" +
                "3. Использовать способность");
        PlayerActions.playerAction();
    }

    public static void printResultsOfTheMove() {
        String turns = playerMove + "\n" + botMove + "\n";
        String healthStatus = "У тебя осталось: " + Util.player.getHealthPoints() + " хп\n" +
                "У бота осталось " + Util.bot.getHealthPoints() + " хп\n";

        System.out.println("\nИтоги хода:\n" +
                turns + "\n" +
                healthStatus);
        if (Util.player.getHealthPoints() <= 0 || Util.bot.getHealthPoints() <= 0) {
            if (Util.player.getHealthPoints() <= 0 && Util.bot.getHealthPoints() <= 0) {
                System.out.println("Ничья.");
            } else if (Util.bot.getHealthPoints() <= 0) {
                System.out.println("Ты победил бота");
            } else {
                System.out.println("Ты проиграл.");
            }
            System.exit(0);
        }
        chooseAction();
    }
}
