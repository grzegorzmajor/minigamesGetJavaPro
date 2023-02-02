package ovh.major.MiniGames;

import ovh.major.MiniGames.LottoGame.ConsoleInterface;
import ovh.major.MiniGames.LottoGame.LottoGame;

public class MiniGames {
    public static void main(String[] args) {

        ConsoleInterface console = new ConsoleInterface();

        do {
            LottoGame lotto = new LottoGame(6, 100, 6);
            lotto.startGame();

        } while (!console.question("Czy chcesz zagrać jeszcze raz? Wpisz yes lub no"));

    }
}
