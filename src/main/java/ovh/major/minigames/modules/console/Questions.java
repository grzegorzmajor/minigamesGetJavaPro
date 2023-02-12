package ovh.major.minigames.modules.console;

import java.util.Scanner;

public class Questions {
    Scanner scanner = new Scanner(System.in);
    ConsolePrinter consolePrinter = new ConsolePrinter();

    public String choice(String question) {
        consolePrinter.print(question);
        return scanner.nextLine();
    }

    public boolean yesNo(String question) {
        consolePrinter.print(question);
        String userChoice = scanner.nextLine();
        return userChoice.startsWith("yes");
    }

}
