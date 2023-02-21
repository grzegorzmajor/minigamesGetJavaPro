package ovh.major.minigames.lotekGames;

public class GameConfigurator {
    private final int NUMBER_OF_DRAWN_NUMBERS;
    private final int NUMBER_OF_PLAYER_NUMBERS;
    private final int DRAWN_RANGE_MAX;
    private final int DRAWN_RANGE_MIN;
    private final boolean PLAYER_SHOULD_ENTER_ALL_NUMBERS;

    public GameConfigurator(int numberOfDrawnNumbers, int drawnRangeMin, int drawnRangeMax, int numberOfPlayerNumbers, boolean playerShouldEnterAllNumbers) {
        this.DRAWN_RANGE_MAX = drawnRangeMax;
        this.DRAWN_RANGE_MIN = drawnRangeMin;
        this.NUMBER_OF_PLAYER_NUMBERS = numberOfPlayerNumbers;
        this.NUMBER_OF_DRAWN_NUMBERS = numberOfDrawnNumbers;
        this.PLAYER_SHOULD_ENTER_ALL_NUMBERS = playerShouldEnterAllNumbers;
    }

    public int getNumberOfDrawNumbers() {
        return NUMBER_OF_DRAWN_NUMBERS;
    }

    public int getDrawRangeMin() {
        return DRAWN_RANGE_MIN;
    }

    public int getDrawRangeMax() {
        return DRAWN_RANGE_MAX;
    }

    public int getNumberOfPlayerNumbers() {
        return NUMBER_OF_PLAYER_NUMBERS;
    }

    public boolean playerShouldEnterAllNumbers() {
        return PLAYER_SHOULD_ENTER_ALL_NUMBERS;
    }
}
