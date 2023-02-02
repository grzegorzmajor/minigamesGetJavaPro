package ovh.major.MiniGames.interfaces.console;

import java.util.List;
import ovh.major.MiniGames.lotto.GameResult;
import ovh.major.MiniGames.lotto.LottoGame;

public class MenuInterface extends ConsoleInterface {

    private String menu() {
        writeTextLine("MENU");
        writeTextLine("----");
        writeTextLine("[lotek] Lotek | [exit] koniec");
        return questionChoice("Wpisz słowo z nawiasów: ");
    }

    public void start() {
        boolean continueGames = false;
        do {
            continueGames = isContinueGames(continueGames);
        } while (!continueGames);
    }

    private boolean isContinueGames(boolean continueGames) {
        switch (menu()) {
            case "lotek" -> {
                LottoGame lotto = new LottoGame(6, 99, 6);
                //pobieranie liczb z konsoli
                List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
                GameResult gameResult = lotto.startGame(numbersFromUser);
                System.out.println(gameResult.getMessage());
                System.out.println(gameResult.isWinner());
            }
            case "exit" -> {
                if (questionYesNo("Czy na pewno chcesz wyjść? [yes]|[no]")) continueGames = true;
            }
            default -> writeTextLine("Wybierz poprawną opcję! ");
        }
        return continueGames;
    }
}
