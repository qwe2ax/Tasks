package console_game.actions;

import console_game.util.Util;
import console_game.util.UtilStrings;

public class PlayerActions {
    public static int playerDamage;

    public static void playerAction() {
        switch (Util.scan.next()) {
            case "1" :
                Util.player.attack(Util.bot);
                UtilStrings.playerMove =  "ТЫ атаковал бота и нанес ему " + playerDamage + " урона";
                break;
            case "2" :
                Util.player.block();
                UtilStrings.playerMove = ("Ты блокировал.." + (Util.player.isAttackAndBlock() ? " ..и атаковал бота нанеся ему " + playerDamage
                        + " урона!" : ".")) ;
                break;
            case "3" :
                if (Util.player.isCooldown()) {
                    System.out.println("Способность на перезарядке");
                    playerAction();
                    return;
                } else if (Util.isPlayerAbilityActive()) {
                    System.out.println("Способность уже активирована");
                    playerAction();
                    return;
                }
                Util.player.useAbility();
                UtilStrings.playerMove = Util.player.getAttribute().getAbilityDescription();
                break;
            case "0" :
                System.out.println("exiting..");
                System.exit(0);
            default:
                System.out.println("Ты еблан?");
                UtilStrings.chooseAction();
                playerAction();
        }
        Util.player.updateTurn();
        BotActions.botAction();
    }
}
