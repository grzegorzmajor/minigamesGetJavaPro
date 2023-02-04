package ovh.major.minigames.interfaces.console;

import ovh.major.minigames.data.GameConfigurator;
import ovh.major.minigames.lotek.LotekBuilder;

public class MenuInterface extends ConsoleInterface {

    private final LotekBuilder lotek = new LotekBuilder(new GameConfigurator(6, 1, 99, 6, true));

    public void start() {
        boolean continueGames;
        do {
            continueGames = isContinueGames();
        } while (continueGames);
    }

    private boolean isContinueGames() {
        switch (menu()) {
            case "lotek" -> lotek.start();
            case "exit" -> {
                return !questionYesNo("Czy na pewno chcesz wyjść? [yes]|[no]: ");
            }
            default -> printTextLine("Wybierz poprawną opcję! ");
        }
        return true;
    }

    private String menu() {
        printMenu();
        return questionChoice("Wpisz słowo z nawiasów: ");
    }

    private void printMenu() {
        printTextLine("MENU");
        printTextLine("----");
        printTextLine("[lotek] Lotek | [exit] Koniec");
    }
}
