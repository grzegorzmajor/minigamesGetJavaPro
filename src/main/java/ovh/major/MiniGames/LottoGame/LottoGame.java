package ovh.major.MiniGames.LottoGame;

import ovh.major.MiniGames.LottoGame.Data.Numbers;
import ovh.major.MiniGames.LottoGame.Data.Results;
import ovh.major.MiniGames.LottoGame.NumberGenerator.NumberGenerator;

public class LottoGame {
    private final int NUMBER_OF_DRAWN_NUMBERS;
    private final int NUMBER_OF_PLAYER_NUMBERS;
    private final int DRAWN_RANGE;

    private final boolean SHOULD_BE_UNIQUE_NUMBERS = true;
    private final Numbers playerNumbers;
    private final Numbers aiNumbers;
    private final NumberGenerator generator;

    private final ConsoleGameInterface gameInterface;

    public LottoGame(int numberOfDrawnNumbers, int drawnRange, int numberOfPlayerNumbers){
        this.NUMBER_OF_DRAWN_NUMBERS = numberOfDrawnNumbers;
        this.DRAWN_RANGE = drawnRange;
        this.NUMBER_OF_PLAYER_NUMBERS = numberOfPlayerNumbers;
        aiNumbers =  new Numbers(NUMBER_OF_DRAWN_NUMBERS, SHOULD_BE_UNIQUE_NUMBERS);
        playerNumbers = new Numbers(NUMBER_OF_PLAYER_NUMBERS, SHOULD_BE_UNIQUE_NUMBERS);
        generator = new NumberGenerator();
        gameInterface = new ConsoleGameInterface(DRAWN_RANGE);
    }

    private void drawn(){
        for (int i=0; i<NUMBER_OF_DRAWN_NUMBERS; i++) {
            boolean isAdded = aiNumbers.add(generator.getRandomNumber(DRAWN_RANGE));
            if (SHOULD_BE_UNIQUE_NUMBERS && !isAdded) i--;
        }
    }
    private void readFromUser(){
        for (int i=0; i<NUMBER_OF_PLAYER_NUMBERS; i++ ) {
            int number = gameInterface.readNumberFromUser();
            boolean isAdded = playerNumbers.add(number);
            if (SHOULD_BE_UNIQUE_NUMBERS && !isAdded) {
                gameInterface.writeTextLine("Ta liczba już została wybrana!");
                i--;
            }
        }
    }

    public void startGame() {
        drawn();
        readFromUser();
        Results results = new Results(aiNumbers.returnContainNumbers(playerNumbers),aiNumbers.returnNotContainNumbers(playerNumbers));
        gameInterface.writeText("Numery wybrane przez gracza: ");
        gameInterface.writeTextLine(playerNumbers.toString());
        gameInterface.writeText("Numery losowania: ");
        gameInterface.writeTextLine(aiNumbers.toString());

        gameInterface.writeText("Graczu! Trafiłeś " + results.numberOfHits() + ": ");
        gameInterface.writeTextLine(results.winingNumbers());
        gameInterface.writeText("Nie trafiłeś " + results.numberOfFailures() + ": ");
        gameInterface.writeTextLine(results.missedNumbers());
    }

}
