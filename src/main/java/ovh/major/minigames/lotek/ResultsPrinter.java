package ovh.major.minigames.lotek;

import ovh.major.minigames.interfaces.console.ConsolePrinter;

class ResultsPrinter {

    private final Results results;

    ResultsPrinter(Results results) {
        this.results = results;
    }

    public void print() {
        printHits();
        printMissed();
    }

    private void printHits() {
        ConsolePrinter console = new ConsolePrinter();
        int numberOfHits = results.numberOfHits();
        if (numberOfHits > 0) {
            console.print("Graczu! Trafiłeś " + numberOfHits + " " + numberWordChanger(numberOfHits) + ". Trafione Liczby: ");
            console.printLn(results.winingNumbers());
        } else {
            console.printLn("Graczu! Nie trafiłeś żadnej liczby!");
        }
    }

    private void printMissed() {
        ConsolePrinter console = new ConsolePrinter();
        int numberOfMissed = results.numberOfMissed();
        if (numberOfMissed > 0) {
            console.print("Chybiłeś " + numberOfMissed + " " + numberWordChanger(numberOfMissed) + ". Chybione Liczby: ");
            console.printLn(results.missedNumbers());
        } else {
            console.printLn("Trafiłeś wszystkie liczby!");
        }
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
}
