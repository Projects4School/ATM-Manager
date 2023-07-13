package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {
    JFrame Frame = null;

    public Menu() {
        super();

        add(createUserMenu());
    }

    public static JMenu createUserMenu() {
        JMenu userMenu = new JMenu("Client");
        JMenuItem addUserItem = new JMenuItem("Add client");
        addUserItem.setAction(new AbstractAction() {
            {
                putValue( Action.NAME, "New Client..." );
                putValue( Action.MNEMONIC_KEY, KeyEvent.VK_N );
                putValue( Action.SHORT_DESCRIPTION, "New client (CTRL+N)" );
                putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK ) );
            }

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        userMenu.add(addUserItem);
        return userMenu;
    }
}
