package ovh.major.minigames.modules;

import java.security.SecureRandom;

public class NumberGenerator {

    public static int getRandomNumber(int maxValue) {
        return getRandomNumber(1, maxValue);
    }

    public static int getRandomNumber(int minValue, int maxValue) {
        if (maxValue < minValue) throw new RuntimeException("Random Generator Error: Min Value > Max Value");
        SecureRandom sRandom = new SecureRandom();
        return (int) Math.floor(sRandom.nextDouble() * (maxValue - minValue) + minValue);
    }
}
