package ovh.major.MiniGames.LottoGame.Data;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    public Numbers sixNumbers(int i1,int i2,int i3,int i4,int i5,int i6) {
        Numbers num = new Numbers(6);
        num.add(i1);
        num.add(i2);
        num.add(i3);
        num.add(i4);
        num.add(i5);
        num.add(i6);
        return num;
    }
    public Numbers zeroNumbers() {
        return new Numbers(6);
    }

    @Test
    public void resultNumOfHitsTest_whenHitAllNumbers(){
        Results result = new Results(sixNumbers(1,2,3,4,5,6),zeroNumbers());
        int intResult = result.numberOfHits();
        assertThat(intResult).isEqualTo(6);
    }

    @Test
    public void resultNumOfFailTest_whenHitAllNumbers(){
        Results result = new Results(sixNumbers(1,2,3,4,5,6),zeroNumbers());
        int intResult = result.numberOfFailures();
        assertThat(intResult).isEqualTo(0);
    }

    @Test
    public void resultNumOfFailTest_whenLoseAllNumbers(){
        Results result = new Results(zeroNumbers(),sixNumbers(1,2,3,4,5,6));
        int intResult = result.numberOfFailures();
        assertThat(intResult).isEqualTo(6);
    }

    @Test
    public void resultNumOfHitsTest_whenLoseAllNumbers(){
        Results result = new Results(zeroNumbers(),sixNumbers(1,2,3,4,5,6));
        int intResult = result.numberOfHits();
        assertThat(intResult).isEqualTo(0);
    }
}
