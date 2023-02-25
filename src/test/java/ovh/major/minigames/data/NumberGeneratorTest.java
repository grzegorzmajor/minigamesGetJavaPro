package ovh.major.minigames.data;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ovh.major.minigames.modules.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {5,10,15,46})
    public void numberGeneratorTest(int minMaxValue) {

        //when
        int result = NumberGenerator.getRandomNumber(minMaxValue, minMaxValue);

        //then
        assertThat(result).isEqualTo(minMaxValue);
    }

    @ParameterizedTest
    @ValueSource(ints={12,13,16,46})
    public void numberGeneratorTest__WhenMinIsBiggerThanMax(int maxValue) {

        //given
        int minValue = maxValue+1;
        String expectedMessage = "Random Generator Error: Min Value > Max Value";

        //when
        Exception exception = assertThrows(RuntimeException.class, () -> NumberGenerator.getRandomNumber(minValue, maxValue));

        //then
        assertTrue(exception.toString()
                .contains(expectedMessage));
    }


}