package ovh.major.MiniGames.lotto;

import java.util.List;
import org.junit.Test;

public class LottoGameTest {


    @Test
    public void should_return_winner_message_when_user_gave_six_correct_numbers_and_winning_numbers_was_the_same() {
        List<Integer> numbersFromUser = List.of(1,2,3,4,5,6);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        LottoGame lotto = new LottoGame(6, 99, 6);

        GameResult gameResult = lotto.startGame(numbersFromUser, winningNumbers);

        System.out.println(gameResult.getMessage());
        System.out.println(gameResult.isWinner());
    }

    @Test
    public void should_return_winner_message_when_user_gave_six_correct_numbers_and_winning_numbers_was_the_same() {
        List<Integer> numbersFromUser = List.of(1,2,3,4);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        LottoGame lotto = new LottoGame(6, 99, 6);

        GameResult gameResult = lotto.startGame(numbersFromUser, winningNumbers);

        System.out.println(gameResult.getMessage());
        System.out.println(gameResult.isWinner());
    }
}
