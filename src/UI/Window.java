package UI;

import Models.Client;
import Services.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    private JPanel rootPanel;
    private JTabbedPane tabbed1;
    private JButton newClientButton;
    private JTable table1;
    private JButton newOperationButton;
    private JTable table2;

    public Window() {
        JFrame frame = new JFrame("ATM Manager");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        updateClientTable();
        newClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewClientModal modal = new NewClientModal();
                modal.setVisible(true);
            }
        });

        newOperationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewOperationModal modal = new NewOperationModal();
                modal.setVisible(true);
            }
        });
    }

    public void updateClientTable() {
        Client[] clients = Database.getInstance().getAllClients();
        String[] head = {"ID", "Name", "Surname", "Address", "Postal Code", "City", "Balance"};
        DefaultTableModel model = new DefaultTableModel();
        for (String col : head) {
            model.addColumn(col);
        }

        for (Client client : clients) {
            model.addRow(client.toObject());
        }
        table1.setModel(model);
        table1.updateUI();
    }
}