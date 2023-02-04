package ovh.major.minigames.data;

public class GameConfigurator {
    private final int NUMBER_OF_DRAWN_NUMBERS;
    private final int NUMBER_OF_PLAYER_NUMBERS;
    private final int DRAWN_RANGE_MAX;
    private final int DRAWN_RANGE_MIN;
    private final boolean SHOULD_BE_UNIQUE_NUMBERS;

    public GameConfigurator(int numberOfDrawnNumbers, int drawnRangeMin, int drawnRangeMax, int numberOfPlayerNumbers, boolean shouldBeUniqueNumbers) {
        this.DRAWN_RANGE_MAX = drawnRangeMax;
        this.DRAWN_RANGE_MIN = drawnRangeMin;
        this.NUMBER_OF_PLAYER_NUMBERS = numberOfPlayerNumbers;
        this.NUMBER_OF_DRAWN_NUMBERS = numberOfDrawnNumbers;
        this.SHOULD_BE_UNIQUE_NUMBERS = shouldBeUniqueNumbers;
    }

    public int getNumberOfDrawNumbers() {
        return NUMBER_OF_DRAWN_NUMBERS;
    }

    public int getDrawnRangeMin() {
        return DRAWN_RANGE_MIN;
    }

    public int getDrawnRangeMax() {
        return DRAWN_RANGE_MAX;
    }

    public int getNumberOfPlayerNumbers() {
        return NUMBER_OF_PLAYER_NUMBERS;
    }

    public boolean isShouldBeUnigueNumbers() {
        return SHOULD_BE_UNIQUE_NUMBERS;
    }
}
