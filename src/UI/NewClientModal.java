package UI;

import Models.Client;
import Services.Database;

import javax.swing.*;
import java.awt.event.*;
import java.util.UUID;

public class NewClientModal extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField adressTextField;
    private JTextField postalCodeTextField;
    private JTextField cityTextField;

    public NewClientModal() {
        setContentPane(contentPane);
        setModal(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setMinimumSize(getPreferredSize());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        Client client = new Client(UUID.randomUUID().toString(), nameTextField.getText(), surnameTextField.getText(), adressTextField.getText(), Integer.parseInt(postalCodeTextField.getText()), cityTextField.getText(), 0.f);
        Database.getInstance().addClient(client);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
