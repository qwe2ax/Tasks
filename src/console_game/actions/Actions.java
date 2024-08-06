package console_game.actions;

import console_game.characters.Hero;
import console_game.util.Util;

public class Actions { ;

    public static void attack(int damageFromAttack, Hero opponent) {
        Hero p = Util.getAnotherPlayer(opponent);
        if (!p.isBlock()) {
            makeDamage(damageFromAttack - opponent.getArmor(), opponent);
            return;
        }
        makeDamage((int) (damageFromAttack * opponent.getBlockPercentage()), opponent);
        p.setBlock(false);
    }

    public static void block(Hero p) {
        p.setBlock(true);
    }

    public static void makeDamage(int damage, Hero opponent) {
        opponent.reduceHealthPoints(damage);
        if (!opponent.isBot()) {
            BotActions.botDamage = damage;
            return;
        }
        PlayerActions.playerDamage = damage;
    }

    public static void useAbility(Hero hero) {
        switch (hero.getAttribute().getAbility()) {
            case 3: // 50% урона при блоке
                hero.setAttackAndBlock(true);
                break;
            case 1: // Х2 демедж на некст ход
                hero.setDoubleDamageNextTurn(true);
                break;
            case 2: // -30% рецивед демеджа на 3 хода
                hero.setReduceDamage(true);
                break;
            default:
                System.out.println("Некорректный выбор способности.");
                System.exit(1);
        }
        hero.setAbilitiesMoves(0);
    }

}
