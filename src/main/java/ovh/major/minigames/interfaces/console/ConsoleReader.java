package ovh.major.minigames.interfaces.console;

import java.util.InputMismatchException;

public class ConsoleReader extends ConsoleInterface {

    private final int MIN_VALUE;
    private final int MAX_VALUE;

    public ConsoleReader(int minNumberValue, int maxNumberValue) {
        this.MIN_VALUE = minNumberValue;
        this.MAX_VALUE = maxNumberValue;
    }

    public int readNumberFromUser() {
        boolean userCantReadWithComprehensionOrIsMalicious;
        int number = 0;
        do {
            try {
                userCantReadWithComprehensionOrIsMalicious = false;
                printText("Podaj liczbę od " + MIN_VALUE + " do " + MAX_VALUE + ": ");
                number = readNumberWithMaxValue();
            } catch (InputMismatchException e) {
                printTextLine("To nie jest liczba!");
                scannerClear();
                userCantReadWithComprehensionOrIsMalicious = true;
            }
        } while (userCantReadWithComprehensionOrIsMalicious);
        return number;
    }

    private int readNumberWithMaxValue() {
        int number;
        boolean isNumberInRange;
        do {
            number = readNumber();
            isNumberInRange = number < MIN_VALUE || number > MAX_VALUE;
            if (isNumberInRange) printText("Podana liczba jest poza zakresem! Podaj poprawną: ");
        } while (isNumberInRange);
        return number;
    }
}
