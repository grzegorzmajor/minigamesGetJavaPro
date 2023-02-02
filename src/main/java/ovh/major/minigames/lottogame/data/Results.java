package ovh.major.minigames.lottogame.data;

public class Results {
    private final Numbers winingUserNumbers;
    private final Numbers missedUserNumbers;

    public Results(Numbers winingUserNumbers, Numbers missedUserNumbers) {
        this.winingUserNumbers = winingUserNumbers;
        this.missedUserNumbers = missedUserNumbers;
    }

    public int numberOfHits() {
        return winingUserNumbers.size();
    }
    public int numberOfFailures() {
        return missedUserNumbers.size();
    }

    public String winingNumbers() {
        return winingUserNumbers.toString();
    }

    public String missedNumbers() {
        return missedUserNumbers.toString();
    }
}
