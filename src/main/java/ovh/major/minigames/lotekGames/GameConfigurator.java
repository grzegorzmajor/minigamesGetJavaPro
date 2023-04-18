package ovh.major.minigames.lotekGames;

public class GameConfigurator {

    private final int NUMBER_OF_DRAWN_NUMBERS;
    private final int NUMBER_OF_PLAYER_NUMBERS;
    private final int DRAWN_RANGE_MAX;
    private final int DRAWN_RANGE_MIN;
    private final boolean PLAYER_SHOULD_ENTER_ALL_NUMBERS;

    private GameConfigurator(Builder builder) {
        this.DRAWN_RANGE_MAX = builder.DRAWN_RANGE_MAX;
        this.DRAWN_RANGE_MIN = builder.DRAWN_RANGE_MIN;
        this.NUMBER_OF_PLAYER_NUMBERS = builder.NUMBER_OF_PLAYER_NUMBERS;
        this.NUMBER_OF_DRAWN_NUMBERS = builder.NUMBER_OF_DRAWN_NUMBERS;
        this.PLAYER_SHOULD_ENTER_ALL_NUMBERS = builder.PLAYER_SHOULD_ENTER_ALL_NUMBERS;
    }

    public static class Builder {
        private int NUMBER_OF_DRAWN_NUMBERS;
        private int NUMBER_OF_PLAYER_NUMBERS;
        private int DRAWN_RANGE_MAX;
        private int DRAWN_RANGE_MIN;
        private boolean PLAYER_SHOULD_ENTER_ALL_NUMBERS;

        public Builder(){}

        public Builder numberOfDrawnNumbers( int i ){
            this.NUMBER_OF_DRAWN_NUMBERS = i;
            return this;
        }
        public Builder numberOfPlayerNumbers( int i ){
            this.NUMBER_OF_PLAYER_NUMBERS = i;
            return this;
        }
        public Builder drawnRangeMax( int i ){
            this.DRAWN_RANGE_MAX = i;
            return this;
        }
        public Builder drawnRangeMin( int i ){
            this.DRAWN_RANGE_MIN = i;
            return this;
        }
        public Builder playerShouldEnterAllNumbers( boolean b ){
            this.PLAYER_SHOULD_ENTER_ALL_NUMBERS = b;
            return this;
        }

        public GameConfigurator build() {
            return new GameConfigurator(this);
        }

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
