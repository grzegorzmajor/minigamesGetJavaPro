package ovh.major.MiniGames.LottoGame.Data;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTests {

    @Test
    public void printTest__whenNumbersIsEmpty(){
        Numbers num = new Numbers(3);
        String result = num.toString();
        assertThat(result).isEqualTo("");
    }

    @Test
    public void printTest__whenNumbersIsNotEmpty(){
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        String  result = num.toString();
        assertThat(result).isEqualTo("3, 2");
    }

    @Test
    public void printTest__whenNumbersIsFull(){
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        num.add(1);
        String  result = num.toString();
        assertThat(result).isEqualTo("3, 2, 1");
    }

    @Test
    public void sizeTest__whenNumbersIsEmpty(){
        Numbers num = new Numbers(3);
        int result = num.size();
        assertThat(result).isEqualTo(0);
    }
    @Test
    public void sizeTest__whenNumbersIsNotEmpty(){
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        int result = num.size();
        assertThat(result).isEqualTo(2);
    }
    @Test
    public void sizeTest__whenNumbersIsFull(){
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        num.add(1);
        int result = num.size();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void isContainNumberTest__whenIsContain() {
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        num.add(1);
        boolean result = num.isContainNumber(1);
        assertThat(result).isEqualTo(true);
    }
    @Test
    public void isContainNumberTest__whenIsNotContain() {
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        num.add(1);
        boolean result = num.isContainNumber(5);
        assertThat(result).isEqualTo(false);
    }
    @Test
    public void isContainAllNumbersTest__WhenResultIsTrue(){
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        num.add(1);
        boolean result = num.isContainAllNumbers(num);
        assertThat(result).isEqualTo(true);
    }
    @Test
    public void isContainAllNumbersTest__WhenResultIsFalse(){
        Numbers num = new Numbers(3);
        num.add(3);
        num.add(2);
        num.add(1);
        Numbers num2= new Numbers(3);
        boolean result = num.isContainAllNumbers(num2);
        assertThat(result).isEqualTo(false);
    }
    @Test
    public void isContainAllNumbersTest__WhenResultIsTrueAndTheyAreNotTeSame() {
        Numbers num = new Numbers(3);
        Numbers num2= new Numbers(3);
        num.add(3);
        num.add(2);
        num.add(1);
        num2.add(1);
        num2.add(2);
        boolean result = num.isContainAllNumbers(num2);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void returnContainNumbersTest__WhenResultIsTrueAndTheyAreNotTeSame() {
        Numbers num = new Numbers(3);
        Numbers num2= new Numbers(3);

        num.add(3);
        num.add(2);
        num.add(1);
        num2.add(2);
        num2.add(1);
        String num2String = num2.toString();

        Numbers result = num.returnContainNumbers(num2);
        String resultString = result.toString();


        assertThat(resultString).isEqualTo(num2String);
    }



}
