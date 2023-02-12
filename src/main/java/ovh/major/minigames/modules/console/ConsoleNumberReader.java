package ovh.major.minigames.modules.console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleNumberReader {

    private final int MIN_VALUE;
    private final int MAX_VALUE;
    private final Scanner scanner = new Scanner(System.in);
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    public ConsoleNumberReader(int minNumberValue, int maxNumberValue) {
        this.MIN_VALUE = minNumberValue;
        this.MAX_VALUE = maxNumberValue;
    }

    public int readNumberFromUser() {
        boolean userCantReadWithComprehensionOrIsMalicious;
        int number = 0;
        do {
            try {
                userCantReadWithComprehensionOrIsMalicious = false;
                consolePrinter.print("Podaj liczbę od " + MIN_VALUE + " do " + MAX_VALUE + ": ");
                number = readNumberWithRangeOfValue();
            } catch (InputMismatchException e) {
                consolePrinter.printLn("To nie jest liczba!");
                scannerClear();
                userCantReadWithComprehensionOrIsMalicious = true;
            }
        } while (userCantReadWithComprehensionOrIsMalicious);
        return number;
    }

    private int readNumberWithRangeOfValue() {
        int number;
        boolean isNumberInRange;
        do {
            number = scanner.nextInt();
            isNumberInRange = number < MIN_VALUE || number > MAX_VALUE;
            if (isNumberInRange) consolePrinter.print("Podana liczba jest poza zakresem! Podaj poprawną: ");
        } while (isNumberInRange);
        return number;
    }

    private void scannerClear() {
        if (scanner.hasNextLine()) scanner.nextLine();
    }

}
