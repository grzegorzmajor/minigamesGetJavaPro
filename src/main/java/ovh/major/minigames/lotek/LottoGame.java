package ovh.major.minigames.lotek;

import ovh.major.minigames.data.GameConfigurator;
import ovh.major.minigames.data.Numbers;

public class LottoGame {
    GameConfigurator gameConfig;
    private final Numbers playerNumbers;
    private final Numbers aiNumbers;

    public LottoGame(GameConfigurator gameConfigurator, Numbers playerNumbers, Numbers aiNumbers) {
        this.gameConfig = gameConfigurator;
        this.aiNumbers = aiNumbers;
        this.playerNumbers = playerNumbers;
    }

    public Numbers start() {
        return aiNumbers.returnContainNumbers(playerNumbers);
    }
}
