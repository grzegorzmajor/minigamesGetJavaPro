package ovh.major.minigames.menu.console;

enum MenuItems {

    MENU_TITLE("\n--------\n| MENU |\n--------"),
    LOTEK("Lotek 6 z 99"),
    LOTEK69("Lotek 6 z 69, strzelasz od 1 do 12 liczb."),
    EXIT("Wyjście z gry");

    private final String itemDescription;

    MenuItems(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public String toString() {
        return itemDescription;
    }

}
