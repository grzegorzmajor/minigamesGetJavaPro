package ovh.major.MiniGames.LottoGame.NumberGenerator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class NumberGeneratorTest {

    @Test
    public void numberGeneratorTest(){
        int minValue = 12;
        int maxValue = 12;
        NumberGenerator numberGenerator = new NumberGenerator();

        int result = numberGenerator.getRandomNumber(minValue,maxValue);

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void numberGeneratorTest__WhenMinIsBiggerThanMax(){
        int minValue = 13;
        int maxValue = 12;
        String expectedMessage = "Random Generator Error: Min Value > Max Value";
        NumberGenerator numberGenerator = new NumberGenerator();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            numberGenerator.getRandomNumber(minValue,maxValue);
        });
        String actualMessage = exception.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
