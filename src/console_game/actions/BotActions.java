package console_game.actions;

import console_game.characters.Attribute;
import console_game.util.Util;
import console_game.util.UtilStrings;

import static console_game.util.Util.bot;

public class BotActions {
    public static int botDamage;
    /*
    мне нужно, чтобы бот при активации спсообнсоти последующими ходами её реализовал.
    Так же если бот с атрибутом сила/агилити он чаще использовал именно атаки/блок в зависимости от атрибута
    на низком хп оппонента, он старался быстрее закончить если имеет атрибут отличный от силы
    на своем низком хп, он чаще использовал блок если имеет атрибут отличный от ловкости
     */
    /*
    к моменту как я доделал эту хуйню, мне не то что интернет не включили, мне нахуй свет вырубили))
    ебаная деревня блять сука нахуййййййй!!!!!!!!!!!!!!
    попрогал на выхах блять...
     */
    public static void botLogic() {
        boolean botCooldown = bot.isCooldown();
        boolean ability = Util.isBotAbilityActive();
        if (!botCooldown && !ability) {
            bot.useAbility();
            UtilStrings.botTurn = bot.getAttribute().getAbilityDescription();
        } else {
            Attribute attribute = bot.getAttribute();
            switch (attribute) {
                case Attribute.AGILITY -> botActionForAgility();
                case Attribute.STRENGTH -> botActionForStrength();
                case Attribute.UNIVERSAL -> botActionForUniversal();
            }
        }
        bot.updateTurn();
        UtilStrings.printResultsOfTurn();
    }

    public static void botActionForUniversal() {
        boolean ability = Util.isBotAbilityActive();
        if (ability || Util.player.getHealthPoints() <= 400) {
            bot.attack(Util.player);
            UtilStrings.botTurn = "Бот атаковал тебя и нанес " + botDamage + " урона.";
            return;
        }

        int randomAction = Util.random.nextInt( 2);
        switch (randomAction) {
            case 0:
                bot.block();
                UtilStrings.botTurn = "Бот блокировал..";
                break;
            case 1:
                bot.attack(Util.player);
                UtilStrings.botTurn = "Бот атаковал тебя и нанес " + botDamage + " урона.";
                break;
            default:
                System.out.println("Произошла ошибка с выбором действия бота.");
                System.exit(0);
        }
    }

    public static void botActionForAgility() {
        boolean ability = Util.isBotAbilityActive();
        if (ability || Util.player.getHealthPoints() <= 400) {
            bot.attack(Util.player);
            UtilStrings.botTurn = "Бот атаковал тебя и нанес " + botDamage + " урона.";
            return;
        }

        int randomAction = Util.random.nextInt(3);
        if (randomAction < 2) {
            bot.attack(Util.player);
            UtilStrings.botTurn = "Бот атаковал тебя и нанес " + botDamage + " урона.";
        } else {
            bot.block();
            UtilStrings.botTurn = "Бот блокировал..";
        }
    }

    public static void botActionForStrength() {
        boolean ability = Util.isBotAbilityActive();
        if (ability || bot.getHealthPoints() <= 400) {
            bot.block();
            UtilStrings.botTurn = "Бот блокировал.." + (bot.isAttackAndBlock() ? " ..и атаковал тебя, нанеся " + botDamage + " урона!" : ".");
            return;
        }

        int randomAction = Util.random.nextInt(3);
        if (randomAction < 2) {
            bot.block();
            UtilStrings.botTurn = "Бот блокировал.." + (bot.isAttackAndBlock() ? " ..и атаковал тебя, нанеся " + botDamage + " урона!" : ".");
        } else {
            bot.attack(Util.player);
            UtilStrings.botTurn = "Бот атаковал тебя и нанес " + botDamage + " урона.";
        }
    }
}
