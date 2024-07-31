import console_game.characters.Player;
import console_game.util.Util;
import console_game.util.UtilStrings;

public class Main {
    public static void main(String[] args) {
        UtilStrings.printMenu();
        Player bot = new Player(Util.getRandomAttribute());
        Player player = new Player(Util.selectAttribute());
        bot.block();
        player.attack(bot);
        System.out.println(player.getAttribute().getTitle());
    }
}