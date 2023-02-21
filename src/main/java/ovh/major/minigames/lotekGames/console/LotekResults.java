package ovh.major.minigames.lotekGames.console;

import ovh.major.minigames.modules.WordChanger;

import java.util.Set;

class LotekResults {
    private final Set<Integer> winingUserNumbers;

    public LotekResults(Set<Integer> winingUserNumbers) {
        this.winingUserNumbers = winingUserNumbers;
    }

    public String toString() {
        String result;
        if (numberOfHits() > 0) {
            result = "\nGraczu! Trafiłeś " + numberOfHits() + " " + WordChanger.number(numberOfHits()) + ". Trafione liczby: ";
            result = result + winingNumbers();
        } else {
            result = "\nGraczu! Nie trafiłeś żadnej liczby!";
        }
        return result;
    }

    private int numberOfHits() {
        return winingUserNumbers.size();
    }

    private String winingNumbers() {
        return winingUserNumbers.toString();
    }

}
