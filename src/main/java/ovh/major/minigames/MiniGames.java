package ovh.major.minigames;

import ovh.major.minigames.menu.console.ConsoleStart;
import ovh.major.minigames.menu.window.WindowsStart;

public class MiniGames {
    public static void main(String[] args) {
        System.out.println("args:" + args.length);
        if (args.length == 0) {
            ConsoleStart consoleMenu = new ConsoleStart();
            consoleMenu.start();
        } else {
            if (args[0].equals("--window")) {
                WindowsStart.start();
            }
        }
    }
}
