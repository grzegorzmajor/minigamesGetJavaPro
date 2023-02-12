package ovh.major.minigames.lotekGames.console;

import ovh.major.minigames.lotekGames.NumbersSet;

class LotekResults {
    private final NumbersSet winingUserNumbers;

    public LotekResults(NumbersSet winingUserNumbers) {
        this.winingUserNumbers = winingUserNumbers;
    }

    public String toString() {
        String result;
        if (numberOfHits() > 0) {
            result = "\nGraczu! Trafiłeś " + numberOfHits() + " " + numberWordChanger(numberOfHits()) + ". Trafione liczby: ";
            result = result + winingNumbers();
        } else {
            result = "\nGraczu! Nie trafiłeś żadnej liczby!";
        }
        return result;
    }

    private String numberWordChanger(int liczba) {
        switch (liczba) {
            case 1 -> {
                return "liczbę";
            }
            case 2, 3, 4 -> {
                return "liczby";
            }
            default -> {
                return "liczb";
            }
        }
    }

    private int numberOfHits() {
        return winingUserNumbers.size();
    }

    private String winingNumbers() {
        return winingUserNumbers.toString();
    }

}
