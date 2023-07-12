package UI;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        super("ATM Manager");

        JMenuBar menu = new Menu();
        setJMenuBar(menu);

        setSize(200,100);
        setVisible(true);
    }
}
