package ovh.major.minigames.lotek;

import org.junit.Test;
import ovh.major.minigames.data.GameConfigurator;
import ovh.major.minigames.data.Numbers;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void LottoGameTest_WhenAllNumbersWinning() {
        //given
        Numbers inputNumbers = getNumbers(true, 1,2,3,4,5,99);
        Numbers inputAiNumbers = getNumbers( true,1,2,3,4,5,99);
        GameConfigurator gameConfig = new GameConfigurator(6,1,99,6,true);
        LottoGame noToLotto = new LottoGame(gameConfig, inputNumbers, inputAiNumbers );
        Numbers expectedResult = getNumbers(true, 1,2,3,4,5,99);

        //when
        Numbers resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }

    @Test
    public void LottoGameTest_WhenNoNumbersWinning() {
        //given
        Numbers inputNumbers = new Numbers(6,true);
        Numbers inputAiNumbers = getNumbers( true,1,2,3,4,5,99);
        GameConfigurator gameConfig = new GameConfigurator(6,1,99,6,true);
        LottoGame noToLotto = new LottoGame(gameConfig, inputNumbers, inputAiNumbers );
        Numbers expectedResult = new Numbers(6,true);

        //when
        Numbers resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }

    @Test
    public void LottoGameTest_WhenOneNumberWinning() {
        //given
        Numbers inputNumbers = getNumbers(true, 1);
        Numbers inputAiNumbers = getNumbers( true,1,2,3,4,5,99);
        GameConfigurator gameConfig = new GameConfigurator(6,1,99,6,true);
        LottoGame noToLotto = new LottoGame(gameConfig, inputNumbers, inputAiNumbers );
        Numbers expectedResult = getNumbers(true, 1);

        //when
        Numbers resultNumbers = noToLotto.start();

        //then
        assertThat(expectedResult.toString()).isEqualTo(resultNumbers.toString());
    }


    private Numbers getNumbers( boolean shouldBeUniqueNumbers, int ...liczba ) {
        int maxNumberOfNumbers = liczba.length;
        Numbers numbers = new Numbers(maxNumberOfNumbers,shouldBeUniqueNumbers);
        for (int j : liczba) {
            numbers.add(j);
        }
        return numbers;
    }


}
