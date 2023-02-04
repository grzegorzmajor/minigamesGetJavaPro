package ovh.major.minigames.lotek;

import ovh.major.minigames.data.GameConfigurator;
import ovh.major.minigames.data.Numbers;
import ovh.major.minigames.interfaces.console.ConsolePrinter;

class LottoGame {
    GameConfigurator gameConfig;
    private final static String PLAYER_NUMBER_TEXT = "Numery wybrane przez gracza: ";
    private final static String AI_NUMBER_TEXT = "Numery losowania: ";
    private final Numbers playerNumbers;
    private final Numbers aiNumbers;

    public LottoGame(GameConfigurator gameConfigurator, Numbers playerNumbers, Numbers aiNumbers) {
        this.gameConfig = gameConfigurator;
        this.aiNumbers = aiNumbers;
        this.playerNumbers = playerNumbers;
    }

    public Results start() {
        aiNumbersPrinter();
        playerNumbersPrinter();
        return new Results(aiNumbers.returnContainNumbers(playerNumbers), aiNumbers.returnNotContainNumbers(playerNumbers));
    }

    private void playerNumbersPrinter() {
        ConsolePrinter console = new ConsolePrinter();
        console.print(PLAYER_NUMBER_TEXT);
        console.printLn(playerNumbers.toString());
    }

    private void aiNumbersPrinter() {
        ConsolePrinter console = new ConsolePrinter();
        console.print(AI_NUMBER_TEXT);
        console.printLn(aiNumbers.toString());
    }
}
