package ovh.major.MiniGames.LottoGame.NumberGenerator;

import java.security.SecureRandom;

public class NumberGenerator {

    public int getRandomNumber(int maxValue) {
        SecureRandom sRandom = new SecureRandom();
        return getRandomNumber(1,maxValue);
    }

    public int getRandomNumber(int minValue, int maxValue) {
        if (maxValue<minValue) throw new RuntimeException("Random Generator Error: Min Value > Max Value");
        SecureRandom sRandom = new SecureRandom();
        return (int) Math.floor(sRandom.nextDouble() * (maxValue - minValue) + minValue);
    }
}
