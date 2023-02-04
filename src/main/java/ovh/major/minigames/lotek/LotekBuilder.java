package ovh.major.minigames.lotek;

import ovh.major.minigames.data.GameConfigurator;
import ovh.major.minigames.data.NumberGenerator;
import ovh.major.minigames.data.Numbers;
import ovh.major.minigames.interfaces.console.ConsolePrinter;
import ovh.major.minigames.interfaces.console.ConsoleReader;

public class LotekBuilder {

    private final GameConfigurator gameConfig;
    private final ConsoleReader gameInterface;

    public LotekBuilder(GameConfigurator gameConfig) {
        this.gameConfig = gameConfig;
        this.gameInterface = new ConsoleReader(gameConfig.getDrawnRangeMin(), gameConfig.getDrawnRangeMax());
    }

    public void start() {
        LottoGame lotto = new LottoGame(gameConfig, readFromPlayer(), drawnNumbers());
        ResultsPrinter resultsPrinter = new ResultsPrinter(lotto.start());
        resultsPrinter.print();
    }

    private Numbers drawnNumbers() {
        Numbers aiNumbers = new Numbers(gameConfig.getNumberOfDrawNumbers(), gameConfig.isShouldBeUnigueNumbers());
        NumberGenerator generator = new NumberGenerator();
        for (int i = 0; i < gameConfig.getNumberOfDrawNumbers(); i++) {
            boolean isAdded = aiNumbers.add(generator.getRandomNumber(gameConfig.getDrawnRangeMax()));
            if (gameConfig.isShouldBeUnigueNumbers() && !isAdded) i--;
        }
        return aiNumbers;
    }

    private Numbers readFromPlayer() {
        final String NUMBER_IS_EXIST_TEXT = "Ta liczba już została wybrana!";
        ConsolePrinter console = new ConsolePrinter();
        Numbers playerNumbers = new Numbers(gameConfig.getNumberOfPlayerNumbers(), gameConfig.isShouldBeUnigueNumbers());
        for (int i = 0; i < gameConfig.getNumberOfPlayerNumbers(); i++) {
            int number = gameInterface.readNumberFromUser();
            boolean isAdded = playerNumbers.add(number);
            if (gameConfig.isShouldBeUnigueNumbers() && !isAdded) {
                console.printLn(NUMBER_IS_EXIST_TEXT);
                i--;
            }
        }
        return playerNumbers;
    }
}


