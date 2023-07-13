package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Window extends JFrame {
    public Window() {
        super("ATM Manager");

        JMenuBar menu = new Menu();
        setJMenuBar(menu);

        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane tab = new JTabbedPane(SwingConstants.TOP);

        JPanel tab1 = new JPanel();
        JButton newClientBtn = new JButton("New User");
        newClientBtn.setBackground(Color.BLACK);
        newClientBtn.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modal modal = new Modal();
                modal.NewClientModal();
                modal.setVisible(true);
            }
        });
        tab1.add(newClientBtn);
        tab.addTab("Clients", tab1);

        JPanel tab2 = new JPanel();

        tab.addTab("Operations", tab2);

        tab.setOpaque(true);
        panel.add(tab);
        getContentPane().add(panel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);


    }
}
