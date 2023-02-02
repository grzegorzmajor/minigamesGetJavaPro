package ovh.major.MiniGames.LottoGame;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInterface {

    Scanner scanner = new Scanner(System.in);

    public ConsoleInterface() {
    }

    public boolean question(String text) {
        writeText(text+": ");
        String userChoice = scanner.nextLine();
        return !userChoice.startsWith("yes");
    }

    public void writeText(String text) {
        System.out.print(text);
    }
    public void writeTextLine(String text) {
        System.out.println(text);
    }
    protected void scannerClear(){
        if (scanner.hasNext()) scanner.nextLine();
    }

}
