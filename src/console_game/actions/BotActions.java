package console_game.actions;

import console_game.util.Util;
import console_game.util.UtilStrings;

public class BotActions {
    public static int botDamage;

    public static void botAction() {
        boolean ability = Util.isBotAbilityActive();
        int randomAction = Util.random.nextInt(Util.bot.isCooldown() ? 2 : 3);

        switch (randomAction) {
            case 0:
                Util.bot.block();
                UtilStrings.botMove = "Бот блокировал.." + (Util.bot.isAttackAndBlock() ? " ..и атаковал тебя, нанеся " + botDamage + " урона!" : ".");
                break;
            case 1:
                Util.bot.attack(Util.player);
                UtilStrings.botMove = "Бот атаковал тебя и нанес " + botDamage + " урона.";
                break;
            case 2:
                Util.bot.useAbility();
                UtilStrings.botMove = Util.bot.getAttribute().getAbilityDescription();
                break;
            default:
                System.out.println("Произошла ошибка с выбором действия бота.");
                System.exit(0);
        }
        Util.bot.updateTurn();
        UtilStrings.printResultsOfTheMove();
    }

    public static void botLogic() {
        // Реализация логики бота
    }
}
