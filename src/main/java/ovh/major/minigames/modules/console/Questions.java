package ovh.major.minigames.modules.console;

import java.util.Scanner;

public class Questions {
    Scanner scanner = new Scanner(System.in);

    public String choice(String question) {
        ConsolePrinter.print(question);
        return scanner.nextLine();
    }

    public boolean yesNo(String question) {
        ConsolePrinter.print(question);
        String userChoice = scanner.nextLine();
        return userChoice.startsWith("yes");
    }

}
