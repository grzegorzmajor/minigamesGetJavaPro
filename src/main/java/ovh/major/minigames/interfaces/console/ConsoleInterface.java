package ovh.major.minigames.interfaces.console;

import java.util.Scanner;

class ConsoleInterface {

    Scanner scanner = new Scanner(System.in);

    protected void printText(String text) {
        System.out.print(text);
    }

    protected void printTextLine(String text) {
        System.out.println(text);
    }

    protected String questionChoice(String question) {
        printText(question);
        return readLine();
    }

    protected boolean questionYesNo(String question) {
        printText(question);
        String userChoice = readLine();
        return userChoice.startsWith("yes");
    }

    protected int readNumber() {
        return scanner.nextInt();
    }

    protected String readLine() {
        return scanner.nextLine();
    }

    protected void scannerClear() {
        if (scanner.hasNextLine()) readLine();
    }

}
