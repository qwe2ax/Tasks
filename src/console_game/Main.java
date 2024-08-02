package console_game;

import console_game.util.Util;
import console_game.util.UtilStrings;


public class Main {
    public static void main(String[] args) {
        UtilStrings.printMenu();
        Util.initPlayers();
//        Attribute attribute = Attribute.selectAttribute();
        System.out.println("Атрибут игрока " + Util.player.getAttribute());
        System.out.println("Атрибут бота " + Util.bot.getAttribute());
//        UtilStrings.printStartGame();
        UtilStrings.chooseAction();
    }
}