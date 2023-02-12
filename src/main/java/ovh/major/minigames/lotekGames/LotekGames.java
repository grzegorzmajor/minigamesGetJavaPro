package ovh.major.minigames.lotekGames;

public class LotekGames {
    private final NumbersSet playerNumbers;
    private final NumbersSet aiNumbers;
    GameConfigurator gameConfig;

    public LotekGames(GameConfigurator gameConfigurator, NumbersSet playerNumbers, NumbersSet aiNumbers) {
        this.gameConfig = gameConfigurator;
        this.aiNumbers = aiNumbers;
        this.playerNumbers = playerNumbers;
    }

    public NumbersSet start() {
        return aiNumbers.returnContainNumbers(playerNumbers);
    }
}
