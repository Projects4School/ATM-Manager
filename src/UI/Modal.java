package UI;

import javax.swing.*;

public class Modal extends JDialog {
    public Modal() {
        super();
        setModalityType(ModalityType.APPLICATION_MODAL);
    }

    public void NewClientModal() {
        setTitle("New Client");

        JTextField name = new JTextField("Name");
        add(name);
    }
}
