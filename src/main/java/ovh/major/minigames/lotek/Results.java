package ovh.major.minigames.lotek;

import ovh.major.minigames.data.Numbers;

class Results {
    private final Numbers winingUserNumbers;
    private final Numbers missedUserNumbers;

    public Results(Numbers winingUserNumbers, Numbers missedUserNumbers) {
        this.winingUserNumbers = winingUserNumbers;
        this.missedUserNumbers = missedUserNumbers;
    }

    public int numberOfHits() {
        return winingUserNumbers.size();
    }

    public int numberOfMissed() {
        return missedUserNumbers.size();
    }

    public String winingNumbers() {
        return winingUserNumbers.toString();
    }

    public String missedNumbers() {
        return missedUserNumbers.toString();
    }
}
