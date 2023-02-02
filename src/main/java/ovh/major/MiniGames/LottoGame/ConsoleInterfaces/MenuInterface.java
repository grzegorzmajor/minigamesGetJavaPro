package ovh.major.MiniGames.LottoGame.ConsoleInterfaces;

public class MenuInterface extends ConsoleInterface{

    public String startMenu(){
        writeTextLine("MENU");
        writeTextLine("----");
        writeTextLine("[lotek] Lotek | [exit] koniec");
        return questionChoice("Wpisz słowo z nawiasów: ");
    }
}
