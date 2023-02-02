package ovh.major.MiniGames.LottoGame.ConsoleInterfaces;

import ovh.major.MiniGames.LottoGame.LottoGame;

public class MenuInterface extends ConsoleInterface{

    private String menu(){
        writeTextLine("MENU");
        writeTextLine("----");
        writeTextLine("[lotek] Lotek | [exit] koniec");
        return questionChoice("Wpisz słowo z nawiasów: ");
    }
    public void start() {
        boolean continueGames = false;
        do {
            switch (menu()) {
                case "lotek" -> {
                    LottoGame lotto = new LottoGame(6, 99, 6);
                    lotto.startGame();
                }
                case "exit" -> {
                    if (questionYesNo("Czy na pewno chcesz wyjść? [yes]|[no]")) continueGames = true;
                }
                default -> writeTextLine("Wybierz poprawną opcję! ");
            }
        } while (!continueGames);
    }
}
