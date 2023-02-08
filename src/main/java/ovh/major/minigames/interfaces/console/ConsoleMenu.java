package ovh.major.minigames.interfaces.console;

import ovh.major.minigames.data.GameConfigurator;

public class ConsoleMenu {

    private final GameConfigurator gameConfig = new GameConfigurator(6, 1, 99, 6, true);
    private final LotekConsoleBuilder lotek = new LotekConsoleBuilder(gameConfig);
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final Questions question = new Questions();

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
                return !question.yesNo("Czy na pewno chcesz wyjść? [yes]|[no]: ");
            }
            default -> consolePrinter.printLn("Wybierz poprawną opcję! ");
        }
        return true;
    }

    private String menu() {
        printMenu();
        return question.choice("Wpisz słowo z nawiasów: ");
    }

    private void printMenu() {
        consolePrinter.printLn("\n\nMENU");
        consolePrinter.printLn("----");
        consolePrinter.printLn("[lotek] Lotek | [exit] Koniec");
    }
}
