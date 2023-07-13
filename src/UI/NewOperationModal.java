package UI;

import Models.Client;
import Models.Operation;
import Services.Database;
import UI.Components.ComboItem;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class NewOperationModal extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox<ComboItem> comboBox1;
    private JComboBox<ComboItem> comboBox2;
    private JSpinner spinner1;

    public NewOperationModal() {
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

        Client[] clients = Database.getInstance().getAllClients();
        for (Client client : clients) {
            comboBox1.addItem(new ComboItem(String.format("%s (%s %s)", client.getClientId(), client.getName(), client.getSurname()), client.getClientId()));
        }

        comboBox2.addItem(new ComboItem("Deposit", "0"));
        comboBox2.addItem(new ComboItem("Withdraw", "1"));

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String clientId = ((ComboItem) Objects.requireNonNull(comboBox1.getSelectedItem())).getValue();
        Integer type = Integer.parseInt(((ComboItem) Objects.requireNonNull(comboBox2.getSelectedItem())).getValue());
        Float mount = Float.parseFloat(spinner1.getModel().getValue().toString());
        Date now = new Date();
        Operation operation = new Operation(UUID.randomUUID().toString(), clientId, type, mount, (int)now.getTime());
        Float balance = Database.getInstance().getClientBalance(clientId);
        if(type == 0)
            balance += mount;
        else if(type == 1)
            balance -= mount;

        Database.getInstance().updateBalance(clientId, balance);
        Database.getInstance().newOperation(operation);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
