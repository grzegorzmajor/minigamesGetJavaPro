package ovh.major.MiniGames;

import ovh.major.MiniGames.LottoGame.ConsoleInterfaces.MenuInterface;
import ovh.major.MiniGames.LottoGame.LottoGame;

public class MiniGames {
    public static void main(String[] args) {

        MenuInterface menu = new MenuInterface();
        boolean continueGames = false;

        do {
            String choice = menu.startMenu();
            switch (choice) {
                case "lotek" -> {
                    LottoGame lotto = new LottoGame(6, 99, 6);
                    lotto.startGame();
                }
                case "exit" -> continueGames = true;
                default -> menu.writeTextLine("Wybierz poprawną opcję! ");
            }
        } while (!continueGames);

    }
}
