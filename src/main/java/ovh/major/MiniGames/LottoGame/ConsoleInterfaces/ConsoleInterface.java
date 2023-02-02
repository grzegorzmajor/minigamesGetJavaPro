package ovh.major.MiniGames.LottoGame.ConsoleInterfaces;

import java.util.Scanner;

public class ConsoleInterface {

    Scanner scanner = new Scanner(System.in);

    protected String questionChoice(String question) {
        writeText(question);
        return readLine();
    }

    protected boolean questionYesNo(String text) {
        writeText(text+": ");
        String userChoice = readLine();
        return !userChoice.startsWith("yes");
    }

    protected int readNumber() {
        return scanner.nextInt();
    }

    protected String readLine() {
        return scanner.nextLine();
    }

    public void writeText(String text) {
        System.out.print(text);
    }
    public void writeTextLine(String text) {
        System.out.println(text);
    }
    protected void scannerClear(){
        if (scanner.hasNextLine()) readLine();
    }

}
