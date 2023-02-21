package ovh.major.minigames.lotekGames;

import ovh.major.minigames.modules.NumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class NumberRandomizer {

    private final GameConfigurator gameConfig;

    public NumberRandomizer(GameConfigurator gameConfig) {
        this.gameConfig = gameConfig;
    }

    public Set<Integer> drawnNumbers() {
        Set<Integer> aiNumbers = new HashSet<>();
        for (int i = 0; i < gameConfig.getNumberOfDrawNumbers(); i++) {
            boolean isAdded = aiNumbers.add(NumberGenerator.getRandomNumber(gameConfig.getDrawnRangeMax()));
            if (!isAdded) i--;
        }
        return aiNumbers;
    }
}