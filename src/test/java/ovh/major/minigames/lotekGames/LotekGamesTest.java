package ovh.major.minigames.lotekGames;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LotekGamesTest {

    @Test
    public void LottoGameTest_WhenAllNumbersWinning() {
        //given
        Set<Integer> inputNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        Set<Integer> inputAiNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        LotekGames noToLotto = new LotekGames(new GameConfigurator.Builder()
                .numberOfDrawnNumbers(6)
                .drawnRangeMin(1)
                .drawnRangeMax(99)
                .numberOfPlayerNumbers(6)
                .playerShouldEnterAllNumbers(true)
                .build(), inputNumbers, inputAiNumbers);
        Set<Integer> expectedResult = getNumbers(1, 2, 3, 4, 5, 99);

        //when
        Set<Integer> resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }

    @Test
    public void LottoGameTest_WhenNoNumbersWinning() {
        //given
        Set<Integer> inputNumbers = new HashSet<>();
        Set<Integer> inputAiNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        LotekGames noToLotto = new LotekGames(new GameConfigurator.Builder()
                .numberOfDrawnNumbers(6)
                .drawnRangeMin(1)
                .drawnRangeMax(99)
                .numberOfPlayerNumbers(6)
                .playerShouldEnterAllNumbers(true)
                .build(), inputNumbers, inputAiNumbers);

        //when
        Set<Integer> resultNumbers = noToLotto.start();

        //then
        assertThat(new HashSet<>().toString()).isEqualTo(resultNumbers.toString());
    }

    @Test
    public void LottoGameTest_WhenOneNumberWinning() {
        //given
        Set<Integer> inputNumbers = getNumbers(1);
        Set<Integer> inputAiNumbers = getNumbers(1, 2, 3, 4, 5, 99);
        LotekGames noToLotto = new LotekGames(new GameConfigurator.Builder()
                .numberOfDrawnNumbers(6)
                .drawnRangeMin(1)
                .drawnRangeMax(99)
                .numberOfPlayerNumbers(6)
                .playerShouldEnterAllNumbers(true)
                .build(), inputNumbers, inputAiNumbers);
        Set<Integer> expectedResult = getNumbers(1);

        //when
        Set<Integer> resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }


    private Set<Integer>getNumbers(int... number) {
        Set<Integer> numbers = new HashSet<>();
        for (int j : number) {
            numbers.add(j);
        }
        return numbers;
    }


}
