package ovh.major.MiniGames.LottoGame;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleGameInterface extends ConsoleInterface {

    private final int MAX_VALUE;
    Scanner scanner = new Scanner(System.in);

    public ConsoleGameInterface(int maxNumberValue) {
        this.MAX_VALUE = maxNumberValue;
    }
    public int readNumberFromUser() {
        boolean userCantReadWithComprehensionOrIsMalicious;
        int number = 0;
        do {
            try {
                userCantReadWithComprehensionOrIsMalicious = false;
                writeText("Podaj liczbę od 0 do " + MAX_VALUE + ": ");
                number = readNumberWithMaxValue();
            } catch (InputMismatchException e) {
                writeTextLine("To nie jest liczba!");
                scannerClear();
                userCantReadWithComprehensionOrIsMalicious = true;
            }
        } while (userCantReadWithComprehensionOrIsMalicious);
        return number;
    }

    private int readNumberWithMaxValue() {
        int number;
        do {
             number = readNumber();
             if (number> MAX_VALUE) writeText("Podana liczba jest poza zakresem! Podaj poprawną: ");
        } while (number > MAX_VALUE);
        return number;
    }

    private int readNumber() {
        return scanner.nextInt();
    }
}
