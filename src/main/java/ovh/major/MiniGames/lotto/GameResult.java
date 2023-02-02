package ovh.major.MiniGames.lotto;

public class GameResult {

    String message;
    boolean winner;

    GameResult(String message, boolean winner) {
        this.message = message;
        this.winner = winner;
    }

    public String getMessage() {
        return message;
    }

    public boolean isWinner() {
        return winner;
    }
}
