package ovh.major.minigames.lotekGames.window;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.lotekGames.LotekGames;
import ovh.major.minigames.lotekGames.NumberRandomizer;
import ovh.major.minigames.modules.WordChanger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class LotekFrame extends JFrame implements ActionListener {

    private final GameConfigurator gameConfigurator;
    private final Set<Integer> userNumbers;
    private final JLabel label = new JLabel(" Grasz?", SwingConstants.CENTER);
    private final JButton button = new JButton("Gram!");
    private Set<Integer> aiNumbers;


    public LotekFrame(GameConfigurator gameConfigurator) {
        super("Zagrasz?");
        this.gameConfigurator = gameConfigurator;
        userNumbers = new HashSet<>();
        UserNumbersPanel userNumbersPanel = new UserNumbersPanel(userNumbers, gameConfigurator);
        add(userNumbersPanel);
        setBounds(20, 20, 300, 500);
        setLayout(new GridLayout(3, 1));
        setLocationRelativeTo(null);
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

    private void startGameWhenPlayerShouldEnterAllNumbers() {
        if ((userNumbers.size() == gameConfigurator.getNumberOfPlayerNumbers())
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
        NumberRandomizer numberRandomizer = new NumberRandomizer(gameConfigurator);
        this.aiNumbers = numberRandomizer.drawnNumbers();
        LotekGames lotek = new LotekGames(this.gameConfigurator, this.userNumbers, this.aiNumbers);
        resultPrint(lotek.start());
    }

    private void resultPrint(Set<Integer> result) {
        label.setText("<html>Numery losowania: " + aiNumbers + "<br>Trafiłeś "
                + result.size() + " " + WordChanger.number(result.size()) + ": " + result);
    }
}