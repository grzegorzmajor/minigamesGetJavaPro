package ovh.major.MiniGames.lotto;

import java.security.SecureRandom;

class NumberGenerator {

    public int getRandomNumber(int maxValue) {
        return getRandomNumber(1, maxValue);
    }

    public int getRandomNumber(int minValue, int maxValue) {
        if (maxValue < minValue) {
            throw new RuntimeException("Random Generator Error: Min Value > Max Value");
        }
        SecureRandom random = new SecureRandom();
        return (int) Math.floor(random.nextDouble() * (maxValue - minValue) + minValue);
    }
}
