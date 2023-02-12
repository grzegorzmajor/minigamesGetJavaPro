package ovh.major.minigames.lotekGames.console;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.modules.console.ConsoleNumberReader;
import ovh.major.minigames.modules.console.ConsolePrinter;

public class Lotek {
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    public void startGame() {
        final GameConfigurator gameConfig =
                new GameConfigurator(6, 1, 99,
                        6, true);
        final LotekConsoleBuilder lotek = new LotekConsoleBuilder(gameConfig);
        lotek.start();
    }
    public void startGame69() {
        consolePrinter.printLn("Ile liczb chcesz wybrać? ");
        ConsoleNumberReader consoleNumberReader = new ConsoleNumberReader(1, 12);
        int numberOfPlayerNumbers = consoleNumberReader.readNumberFromUser();
        final GameConfigurator gameConfig =
                new GameConfigurator(6, 1, 69,
                        numberOfPlayerNumbers, false);
        final LotekConsoleBuilder lotek = new LotekConsoleBuilder(gameConfig);
        lotek.start();
    }
}
