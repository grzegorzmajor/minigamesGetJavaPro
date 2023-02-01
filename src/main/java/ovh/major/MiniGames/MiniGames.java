package ovh.major.MiniGames;

import ovh.major.MiniGames.LottoGame.LottoGame;

public class MiniGames {
    public static void main(String[] args) {

        LottoGame lotto = new LottoGame(6,100,6);
        lotto.startGame();

    }
}
