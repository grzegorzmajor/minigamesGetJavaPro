package ovh.major.minigames.menu.window;

import ovh.major.minigames.lotekGames.GameConfigurator;
import ovh.major.minigames.lotekGames.window.LotekFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MenuPanel extends JPanel implements ActionListener {
    private final JButton btnLotek = new JButton("Lotek");
    private final JButton btnLotek69 = new JButton("Lotek69");

    public MenuPanel() {

        btnLotek.setPreferredSize(new Dimension(180, 40));
        btnLotek.addActionListener(this);
        add(btnLotek);


        btnLotek69.setPreferredSize(new Dimension(180, 40));
        btnLotek69.addActionListener(this);
        add(btnLotek69);

        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnLotek) {
            final GameConfigurator gameConfigurator = new GameConfigurator(6, 1,
                    99, 6, true);
            LotekFrame lotekFrame;
            lotekFrame = new LotekFrame(gameConfigurator);
            lotekFrame.setVisible(true);
        }

        if (source == btnLotek69) {
            final GameConfigurator gameConfigurator = new GameConfigurator(6, 1,
                    69, 12, false);
            LotekFrame lotekFrame;
            lotekFrame = new LotekFrame(gameConfigurator);
            lotekFrame.setVisible(true);
        }
    }
}
