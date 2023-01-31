package ovh.major.MiniGames.LottoGame.Data;

public class PlayerNumbers {
    private final int PLAYER_CHOSEN_NUMBERS_OF_NUMBERS;
    private final Numbers numbers;
    public PlayerNumbers(int playerChosenNumberOfNumbers){
        this.PLAYER_CHOSEN_NUMBERS_OF_NUMBERS = playerChosenNumberOfNumbers;
        numbers = new Numbers(playerChosenNumberOfNumbers);
    }
    public int numberOfNumbers() {
        return PLAYER_CHOSEN_NUMBERS_OF_NUMBERS;
    }

}
