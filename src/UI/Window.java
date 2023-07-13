package UI;

import javax.swing.*;

public class Window {
    private JPanel rootPanel;
    private JTabbedPane tabbed1;
    private JButton newClientButton;
    private JTable table1;

    public Window() {
        JFrame frame = new JFrame("ATM Manager");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}