package ovh.major.minigames.lotekGames.console;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.lotekGames.LotekGames;
import ovh.major.minigames.modules.console.ConsoleNumberReader;
import ovh.major.minigames.modules.console.ConsolePrinter;
import ovh.major.minigames.modules.NumberGenerator;
import ovh.major.minigames.lotekGames.NumbersSet;

class LotekConsoleBuilder {

    private final static String PLAYER_NUMBER_TEXT = "Numery wybrane przez gracza: ";
    private final static String AI_NUMBER_TEXT = "Numery losowania: ";

    private final GameConfigurator gameConfig;
    private final ConsoleNumberReader consoleNumberReader;
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    public LotekConsoleBuilder(GameConfigurator gameConfig) {
        this.gameConfig = gameConfig;
        this.consoleNumberReader = new ConsoleNumberReader(gameConfig.getDrawnRangeMin(), gameConfig.getDrawnRangeMax());
    }

    public void start() {
        LotekGames lotto = new LotekGames(gameConfig, readFromPlayer(), drawnNumbers());
        NumbersSet winingNumbers = lotto.start();
        LotekResults lotekResults = new LotekResults(winingNumbers);
        consolePrinter.printLn(lotekResults.toString());
    }

    private NumbersSet drawnNumbers() {
        NumbersSet aiNumbers = new NumbersSet(gameConfig.getNumberOfDrawNumbers());
        NumberGenerator generator = new NumberGenerator();
        for (int i = 0; i < gameConfig.getNumberOfDrawNumbers(); i++) {
            boolean isAdded = aiNumbers.add(generator.getRandomNumber(gameConfig.getDrawnRangeMax()));
            if (!isAdded) i--;
        }
        numbersPrinter(AI_NUMBER_TEXT, aiNumbers);
        return aiNumbers;
    }

    private NumbersSet readFromPlayer() {
        final String NUMBER_IS_EXIST_TEXT = "Ta liczba już została wybrana!";
        ConsolePrinter consolePrinter = new ConsolePrinter();
        NumbersSet playerNumbers = new NumbersSet(gameConfig.getNumberOfPlayerNumbers());
        for (int i = 0; i < gameConfig.getNumberOfPlayerNumbers(); i++) {
            int number = consoleNumberReader.readNumberFromUser();
            boolean isAdded = playerNumbers.add(number);
            if (!isAdded) {
                consolePrinter.printLn(NUMBER_IS_EXIST_TEXT);
                i--;
            }
        }
        numbersPrinter(PLAYER_NUMBER_TEXT, playerNumbers);
        return playerNumbers;
    }

    private void numbersPrinter(String description, NumbersSet playerNumbers) {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.print(description);
        consolePrinter.printLn(playerNumbers.toString());
    }
}


