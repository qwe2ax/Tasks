package console_game.actions;

import console_game.util.Util;
import console_game.util.UtilStrings;

public class PlayerActions {
    public static int playerDamage;

    public static void playerAction() {
        System.out.println("\nВаш ход. Выберите действие:");
        switch (Util.scan.next()) {
            case "1" :
                Util.player.attack(Util.bot);
                UtilStrings.playerTurn = "Ты атаковал бота и нанес ему " + playerDamage + " урона.";
                break;
            case "2" :
                Util.player.block();
                UtilStrings.playerTurn = "Ты блокировал.." + (Util.player.isAttackAndBlock() ? " ..и атаковал бота, нанеся ему " + playerDamage + " урона!" : ".");
                break;
            case "3" :
                if (Util.player.isCooldown()) {
                    System.out.println("Способность на перезарядке. Попробуй снова.");
                    playerAction();
                    return;
                } else if (Util.isPlayerAbilityActive()) {
                    System.out.println("Способность уже активирована. Попробуй снова.");
                    playerAction();
                    return;
                }
                Util.player.useAbility();
                UtilStrings.playerTurn = Util.player.getAttribute().getAbilityDescription();
                break;
            case "0" :
                System.out.println("Выход из игры...");
                System.exit(0);
            default:
                System.out.println("Некорректный ввод. Попробуй снова.");
                UtilStrings.chooseAction();
                playerAction();
        }
        Util.player.updateTurn();
        BotActions.botLogic();
    }
}
