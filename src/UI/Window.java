package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        super("ATM Manager");

        JMenuBar menu = new Menu();
        setJMenuBar(menu);

        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane tab = new JTabbedPane(SwingConstants.TOP);

        JPanel tab1 = new JPanel();
        JLabel titreOnglet1 = new JLabel("Onglet 1");
        tab1.add(titreOnglet1);
        tab.addTab("onglet1", tab1);

        JPanel tab2 = new JPanel();
        JLabel titreOnglet2 = new JLabel("Onglet 2");
        tab2.add(titreOnglet2);
        tab.addTab("onglet2", tab2);

        tab.setOpaque(true);
        panel.add(tab);
        getContentPane().add(panel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);


    }
}
