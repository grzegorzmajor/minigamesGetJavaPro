package ovh.major.minigames.lotekGames.window;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.lotekGames.LotekGames;
import ovh.major.minigames.modules.NumberGenerator;
import ovh.major.minigames.lotekGames.NumbersSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LotekFrame extends JFrame implements ActionListener {

    private final GameConfigurator gameConfigurator;
    private final NumbersSet userNumbers;
    private NumbersSet aiNumbers;
    private final JLabel label = new JLabel(" Grasz?", SwingConstants.CENTER);
    private final JButton button = new JButton("Gram!");


    public LotekFrame(GameConfigurator gameConfigurator) {
        super("Zagrasz?");
        this.gameConfigurator = gameConfigurator;
        userNumbers = new NumbersSet(gameConfigurator.getNumberOfPlayerNumbers());
        UserNumbersPanel userNumbersPanel = new UserNumbersPanel(userNumbers, gameConfigurator);
        add(userNumbersPanel);
        setBounds(20, 20, 300, 500);
        setLayout(new GridLayout(3, 1));
        setLocationRelativeTo(null);
        aiNumbers = drawn(gameConfigurator.getNumberOfDrawNumbers(), gameConfigurator.getDrawnRangeMax());
        add(label);
        label.setPreferredSize(new Dimension(180, 40));
        add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button) {
            if (gameConfigurator.playerShouldEnterAllNumbers()) {
                startGameWhenPlayerShouldEnterAllNumbers();
            } else {
                startGameWhenPlayerDoesNotHaveToEnterAllNumbers();
            }
        }
    }

    private NumbersSet drawn(int numberOfDrawNumbers, int drawnRangeMax) {
        NumbersSet aiNumbers = new NumbersSet(numberOfDrawNumbers);
        NumberGenerator generator = new NumberGenerator();
        for (int i = 0; i < numberOfDrawNumbers; i++) {
            boolean isAdded = aiNumbers.add(generator.getRandomNumber(drawnRangeMax));
            if (!isAdded) i--;
        }
        return aiNumbers;
    }


    private void startGameWhenPlayerShouldEnterAllNumbers() {
        if ((userNumbers.isFull())
        ) {
            startGame();
        } else {
            label.setText("Dodaj najpierw " + gameConfigurator.getNumberOfPlayerNumbers() + " liczb!");
        }
    }

    private void startGameWhenPlayerDoesNotHaveToEnterAllNumbers() {
        if ((userNumbers.size() > 0)
        ) {
            startGame();
        } else {
            label.setText("Dodaj najpierw chciaż jedną liczbę!");
        }
    }
    private void startGame() {
        this.aiNumbers = drawn(gameConfigurator.getNumberOfDrawNumbers(), gameConfigurator.getDrawnRangeMax());
        LotekGames lotek = new LotekGames(this.gameConfigurator, this.userNumbers, this.aiNumbers);
        resultPrint(lotek.start());

    }

    private void resultPrint(NumbersSet result){
        label.setText("<html>Numery losowania: " + aiNumbers + "<br>Trafiłeś "
                + result.size() + " " + numberWordChanger(result.size()) + ": " + result);
    }

    private String numberWordChanger(int liczba) {
        switch (liczba) {
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