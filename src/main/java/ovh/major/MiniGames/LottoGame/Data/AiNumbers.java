package ovh.major.MiniGames.LottoGame.Data;

import ovh.major.MiniGames.LottoGame.NumberGenerator.NumberGenerator;

public class AiNumbers {
    private final int NUMBER_OF_DRAWN_NUMBERS;
    private final int DRAWN_RANGE;
    private final Numbers numbers;
    private final NumberGenerator generator;

    public AiNumbers(int numberOfDrawnNumbers, int drawnRange){
        this.NUMBER_OF_DRAWN_NUMBERS = numberOfDrawnNumbers;
        this.DRAWN_RANGE = drawnRange;
        numbers = new Numbers(numberOfDrawnNumbers);
        generator = new NumberGenerator();
    }

    public void drawn(){
        for (int i=0; i<NUMBER_OF_DRAWN_NUMBERS; i++) {
            numbers.add(generator.getRandomNumber(DRAWN_RANGE));
        }
    }

}
