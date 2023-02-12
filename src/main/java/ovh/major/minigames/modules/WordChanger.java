package ovh.major.minigames.modules;

public final class WordChanger {
    public static String number(int number) {
        switch (number) {
            case 1 -> {
                return "liczbę";
            }
            case 2, 3, 4 -> {
                return "liczby";
            }
            default -> {
                return "liczb";
            }
        }
    }
}
