package ovh.major.minigames.menu.console;


import ovh.major.minigames.lotekGames.console.Lotek;
import ovh.major.minigames.modules.console.ConsolePrinter;
import ovh.major.minigames.modules.console.Questions;

public class ConsoleStart {
    private final Questions question = new Questions();
    Lotek lotek = new Lotek();

    public void start() {
        boolean continueGames;
        do {
            printMenu();
            continueGames = isContinueGames();
        } while (continueGames);
    }

    private boolean isContinueGames() {
        String option = getChoice();
        switch (option.toUpperCase()) {
            case "LOTEK" -> lotek.startGame();
            case "LOTEK69" -> lotek.startGame69();
            case "EXIT" -> {
                return !question.yesNo("Czy na pewno chcesz wyjść? [yes]|[no]: ");
            }
            default -> ConsolePrinter.printLn("Wybierz poprawną opcję! ");
        }
        return true;
    }

    private String getChoice() {
        return question.choice("Wpisz słowo z nawiasów: ");
    }

    private void printMenu() {
        ConsolePrinter.printLn(MenuItems.MENU_TITLE.toString());
        ConsolePrinter.printLn(
                "[" + MenuItems.LOTEK.name() + "] " + MenuItems.LOTEK + " | " +
                        "[" + MenuItems.LOTEK69.name() + "] " + MenuItems.LOTEK69 + " | " +
                        "[" + MenuItems.EXIT.name() + "] " + MenuItems.EXIT
        );
    }
}
