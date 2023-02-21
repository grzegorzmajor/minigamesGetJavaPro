package ovh.major.minigames.lotekGames;

import ovh.major.minigames.modules.NumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class NumberRandomizer {

    private final GameConfigurator gameConfig;

    public NumberRandomizer(GameConfigurator gameConfig) {
        this.gameConfig = gameConfig;
    }

    public Set<Integer> drawNumbers() {
        Set<Integer> aiNumbers = new HashSet<>();
        while (aiNumbers.size() < gameConfig.getNumberOfDrawNumbers()) {
            aiNumbers.add(NumberGenerator.getRandomNumber(gameConfig.getDrawRangeMax()));
        }
        return aiNumbers;
    }
}