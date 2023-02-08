package ovh.major.minigames.interfaces.console;

import ovh.major.minigames.data.GameConfigurator;
import ovh.major.minigames.data.NumberGenerator;
import ovh.major.minigames.data.Numbers;
import ovh.major.minigames.lotek.LottoGame;

class LotekConsoleBuilder {

    private final static String PLAYER_NUMBER_TEXT = "Numery wybrane przez gracza: ";
    private final static String AI_NUMBER_TEXT = "Numery losowania: ";

    private final GameConfigurator gameConfig;
    private final ConsoleReader consoleReader;
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    LotekConsoleBuilder(GameConfigurator gameConfig) {
        this.gameConfig = gameConfig;
        this.consoleReader = new ConsoleReader(gameConfig.getDrawnRangeMin(), gameConfig.getDrawnRangeMax());
    }

    public void start() {
        LottoGame lotto = new LottoGame(gameConfig, readFromPlayer(), drawnNumbers());
        Numbers winingNumbers = lotto.start();
        LotekResults lotekResults = new LotekResults(winingNumbers);
        consolePrinter.printLn(lotekResults.toString());
    }

    private Numbers drawnNumbers() {
        Numbers aiNumbers = new Numbers(gameConfig.getNumberOfDrawNumbers(), gameConfig.isShouldBeUnigueNumbers());
        NumberGenerator generator = new NumberGenerator();
        for (int i = 0; i < gameConfig.getNumberOfDrawNumbers(); i++) {
            boolean isAdded = aiNumbers.add(generator.getRandomNumber(gameConfig.getDrawnRangeMax()));
            if (gameConfig.isShouldBeUnigueNumbers() && !isAdded) i--;
        }
        numbersPrinter(AI_NUMBER_TEXT,aiNumbers);
        return aiNumbers;
    }

    private Numbers readFromPlayer() {
        final String NUMBER_IS_EXIST_TEXT = "Ta liczba już została wybrana!";
        ConsolePrinter consolePrinter = new ConsolePrinter();
        Numbers playerNumbers = new Numbers(gameConfig.getNumberOfPlayerNumbers(), gameConfig.isShouldBeUnigueNumbers());
        for (int i = 0; i < gameConfig.getNumberOfPlayerNumbers(); i++) {
            int number = consoleReader.readNumberFromUser();
            boolean isAdded = playerNumbers.add(number);
            if (gameConfig.isShouldBeUnigueNumbers() && !isAdded) {
                consolePrinter.printLn(NUMBER_IS_EXIST_TEXT);
                i--;
            }
        }
        numbersPrinter(PLAYER_NUMBER_TEXT,playerNumbers);
        return playerNumbers;
    }

    private void numbersPrinter(String description, Numbers playerNumbers) {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.print(description);
        consolePrinter.printLn(playerNumbers.toString());
    }
}


