package ovh.major.minigames.lotekGames;

import java.util.HashSet;
import java.util.Set;

public class LotekGames {
    private final Set<Integer> playerNumbers;
    private final Set<Integer> aiNumbers;
    GameConfigurator gameConfig;

    public LotekGames(GameConfigurator gameConfigurator, Set<Integer> playerNumbers, Set<Integer> aiNumbers) {
        this.gameConfig = gameConfigurator;
        this.aiNumbers = aiNumbers;
        this.playerNumbers = playerNumbers;
    }

    public Set<Integer> start() {
        Set<Integer> result = new HashSet<>();
        playerNumbers.forEach(number -> {
            if (aiNumbers.contains(number)) result.add(number);
        });
        return result;
    }
}
