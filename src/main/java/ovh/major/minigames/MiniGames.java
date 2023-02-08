package ovh.major.minigames;

import ovh.major.minigames.interfaces.console.ConsoleMenu;

public class MiniGames {
    public static void main(String[] args) {
        if (args.length == 0) {
            ConsoleMenu consoleMenu = new ConsoleMenu();
            consoleMenu.start();
        }
    }
}
