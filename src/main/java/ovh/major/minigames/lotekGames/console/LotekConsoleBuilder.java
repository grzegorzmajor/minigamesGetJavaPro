package ovh.major.minigames.lotekGames.console;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.lotekGames.LotekGames;
import ovh.major.minigames.lotekGames.NumberRandomizer;
import ovh.major.minigames.modules.console.ConsolePrinter;

import java.util.Set;

class LotekConsoleBuilder {

    private final static String PLAYER_NUMBER_TEXT = "Numery wybrane przez gracza: ";
    private final static String AI_NUMBER_TEXT = "Numery losowania: ";

    private final GameConfigurator gameConfig;
    private final NumberRandomizer numberRandomizer;
    private final UserNumberReader userNumberReader;


    public LotekConsoleBuilder(GameConfigurator gameConfig) {
        this.gameConfig = gameConfig;
        this.numberRandomizer = new NumberRandomizer(gameConfig);
        this.userNumberReader = new UserNumberReader(gameConfig);
    }

    public void start() {
        Set<Integer> userNumber = userNumberReader.readFromPlayer();
        Set<Integer> aiNumber = numberRandomizer.drawNumbers();
        LotekGames lotto = new LotekGames(gameConfig, userNumber, aiNumber);
        Set<Integer> winingNumbers = lotto.start();
        LotekResults lotekResults = new LotekResults(winingNumbers);
        printUserNumber(userNumber);
        printAiNumber(aiNumber);
        ConsolePrinter.printLn(lotekResults.toString());
    }

    private void printUserNumber(Set<Integer> numbers) {
        numbersPrinter(PLAYER_NUMBER_TEXT, numbers);
    }

    private void printAiNumber(Set<Integer> numbers) {
        numbersPrinter(AI_NUMBER_TEXT, numbers);
    }

    private void numbersPrinter(String description, Set<Integer> playerNumbers) {
        ConsolePrinter.print(description);
        ConsolePrinter.printLn(playerNumbers.toString());
    }
}


