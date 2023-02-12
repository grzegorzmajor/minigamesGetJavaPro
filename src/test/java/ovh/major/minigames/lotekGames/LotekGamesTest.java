package ovh.major.minigames.lotekGames;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotekGamesTest {

    @Test
    public void LottoGameTest_WhenAllNumbersWinning() {
        //given
        NumbersSet inputNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        NumbersSet inputAiNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        GameConfigurator gameConfig = new GameConfigurator(6, 1, 99, 6, true);
        LotekGames noToLotto = new LotekGames(gameConfig, inputNumbers, inputAiNumbers);
        NumbersSet expectedResult = getNumbers(1, 2, 3, 4, 5, 99);

        //when
        NumbersSet resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }

    @Test
    public void LottoGameTest_WhenNoNumbersWinning() {
        //given
        NumbersSet inputNumbers = new NumbersSet(6);
        NumbersSet inputAiNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        GameConfigurator gameConfig = new GameConfigurator(6, 1, 99, 6, true);
        LotekGames noToLotto = new LotekGames(gameConfig, inputNumbers, inputAiNumbers);
        NumbersSet expectedResult = new NumbersSet(6);

        //when
        NumbersSet resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }

    @Test
    public void LottoGameTest_WhenOneNumberWinning() {
        //given
        NumbersSet inputNumbers = getNumbers(1);
        NumbersSet inputAiNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        GameConfigurator gameConfig = new GameConfigurator(6, 1, 99, 6, true);
        LotekGames noToLotto = new LotekGames(gameConfig, inputNumbers, inputAiNumbers);
        NumbersSet expectedResult = getNumbers(1);

        //when
        NumbersSet resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }


    private NumbersSet getNumbers(int... liczba) {
        int maxNumberOfNumbers = liczba.length;
        NumbersSet numbers = new NumbersSet(maxNumberOfNumbers);
        for (int j : liczba) {
            numbers.add(j);
        }
        return numbers;
    }


}
