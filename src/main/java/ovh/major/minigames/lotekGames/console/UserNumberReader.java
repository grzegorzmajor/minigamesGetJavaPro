package ovh.major.minigames.lotekGames.console;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.modules.console.ConsoleNumberReader;
import ovh.major.minigames.modules.console.ConsolePrinter;

import java.util.HashSet;
import java.util.Set;

class UserNumberReader {

    private final GameConfigurator gameConfig;
    private final ConsoleNumberReader consoleNumberReader;

    public UserNumberReader(GameConfigurator gameConfig) {
        this.gameConfig = gameConfig;
        this.consoleNumberReader = new ConsoleNumberReader(gameConfig.getDrawRangeMin(), gameConfig.getDrawRangeMax());
    }

    Set<Integer> readFromPlayer() {
        final String NUMBER_IS_EXIST_TEXT = "Ta liczba już została wybrana!";
        Set<Integer> playerNumbers = new HashSet<>();
        while (playerNumbers.size() < gameConfig.getNumberOfPlayerNumbers()) {
            int number = consoleNumberReader.readNumberFromUser();
            if (!playerNumbers.add(number)) ConsolePrinter.printLn(NUMBER_IS_EXIST_TEXT);
        }
        return playerNumbers;
    }
}