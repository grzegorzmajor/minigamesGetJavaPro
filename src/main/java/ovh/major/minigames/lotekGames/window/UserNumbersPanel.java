package ovh.major.minigames.lotekGames.window;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.lotekGames.NumbersSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserNumbersPanel extends JPanel implements ActionListener {

    private final JLabel label;
    private final GameConfigurator gameConfigurator;
    private final SpinnerModel model = new SpinnerNumberModel(1, 1, 99, 1);
    private final JSpinner spinner = new JSpinner(model);
    private final JButton addButton = new JButton("Dodaj");
    private final JButton clearButton = new JButton("Czyść");
    NumbersSet userNumbers;
    private String USER_NUMBERS_TEXT;

    public UserNumbersPanel(NumbersSet userNumbers, GameConfigurator gameConfigurator) {
        this.gameConfigurator = gameConfigurator;
        this.userNumbers = userNumbers;
        setUserNumberText();
        this.label = new JLabel(USER_NUMBERS_TEXT, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(280, 70));
        add(label);
        add(spinner);
        spinner.setPreferredSize(new Dimension(100, 30));
        addButton.setPreferredSize(new Dimension(80, 30));
        addButton.addActionListener(this);
        add(addButton);
        clearButton.setPreferredSize(new Dimension(80, 30));
        clearButton.addActionListener(this);
        add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addButton) {
            if (!userNumbers.isFull()) {
                int value = (int) spinner.getValue();
                userNumbers.add(value);
                label.setText("Twoje liczby: " + userNumbers.toString());
            } else {
                label.setText("<html>Twoje liczby: " + userNumbers.toString() + "<br>Nie możesz dodać więcej!");
            }
        }
        if (source == clearButton) {
            userNumbers.clear();
            label.setText(USER_NUMBERS_TEXT);
        }
    }

    private void setUserNumberText() {
        if (gameConfigurator.playerShouldEnterAllNumbers()) {
            USER_NUMBERS_TEXT = "Dodaj dokładnie " + gameConfigurator.getNumberOfPlayerNumbers() + " liczb od "
                    + gameConfigurator.getDrawnRangeMin() + " do "
                    + gameConfigurator.getDrawnRangeMax() + " ";
        } else {
            USER_NUMBERS_TEXT = "Dodaj do " + gameConfigurator.getNumberOfPlayerNumbers() + " liczb od "
                    + gameConfigurator.getDrawnRangeMin() + " do "
                    + gameConfigurator.getDrawnRangeMax() + " ";
        }
    }
}

