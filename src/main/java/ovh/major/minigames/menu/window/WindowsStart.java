package ovh.major.minigames.menu.window;

import javax.swing.*;
import java.awt.*;

public class WindowsStart extends JFrame {

    public WindowsStart() {
        super("Menu!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(20, 20, 220, 135);
        MenuPanel menuPanel = new MenuPanel();
        add(menuPanel);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void start() {
        EventQueue.invokeLater(WindowsStart::new);
    }
}
