package ovh.major.minigames.lotekGames.console;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.modules.console.ConsoleNumberReader;
import ovh.major.minigames.modules.console.ConsolePrinter;

public class Lotek {
    public void startGame() {
        final LotekConsoleBuilder lotek = new LotekConsoleBuilder(new GameConfigurator.Builder()
                .numberOfDrawnNumbers(6)
                .drawnRangeMin(1)
                .drawnRangeMax(99)
                .numberOfPlayerNumbers(6)
                .playerShouldEnterAllNumbers(true)
                .build());
        lotek.start();
    }

    public void startGame69() {
        ConsolePrinter.printLn("Ile liczb chcesz wybrać? ");
        ConsoleNumberReader consoleNumberReader = new ConsoleNumberReader(1, 12);
        int numberOfPlayerNumbers = consoleNumberReader.readNumberFromUser();
        final LotekConsoleBuilder lotek = new LotekConsoleBuilder(new GameConfigurator.Builder()
                .numberOfDrawnNumbers(6)
                .drawnRangeMin(1)
                .drawnRangeMax(69)
                .playerShouldEnterAllNumbers(false)
                .numberOfPlayerNumbers(numberOfPlayerNumbers)
                .build()
        );
        lotek.start();
    }
}
