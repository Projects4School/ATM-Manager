package UI;

import javax.swing.*;

public class Menu extends JMenuBar {
    public Menu() {
        super();

        add(createUserMenu());
    }

    public static JMenu createUserMenu() {
        JMenu userMenu = new JMenu("Users");
        JMenuItem addUserItem = new JMenuItem("Add user");

        userMenu.add(addUserItem);
        return userMenu;
    }
}
