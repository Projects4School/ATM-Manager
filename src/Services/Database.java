package Services;

import Models.Client;
import Models.Operation;

import java.sql.*;
import java.util.Map;

public class Database {
    private String DBPath = "database.db";
    private Connection connection = null;
    private Statement statement = null;
    private static Database _instance = null;

    public Database(String dBPath) {
        DBPath = dBPath;
        setInstance(this);
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connected : " + DBPath);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error of connection.");
        }
    }

    public void close() {
        try {
            connection.close();
            statement.close();
            System.out.println("Database closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, client.getClientId());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getName());
            preparedStatement.setString(4, client.getAddress());
            preparedStatement.setInt(5, client.getPostalCode());
            preparedStatement.setString(6, client.getCity());
            preparedStatement.setFloat(7, client.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client[] getAllClients() {
        int size = getColCount("clients");
        Client[] clients = new Client[size];
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM clients")) {
            int i = 0;
            while (rs.next()) {
                clients[i] = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getFloat(7));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public void newOperation(Operation operation) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO operations VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, operation.getOperationID());
            preparedStatement.setInt(2, operation.getType());
            preparedStatement.setFloat(3, operation.getMount());
            preparedStatement.setInt(4, operation.getDate());
            preparedStatement.setString(5, operation.getClientID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Operation[] getAllOperations() {
        int size = getColCount("operations");
        Operation[] operations = new Operation[size];
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM operations")) {
            int i = 0;
            while (rs.next()) {
                operations[i] = new Operation(rs.getString(1), rs.getString(5), rs.getInt(2), rs.getFloat(3), rs.getInt(4));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return operations;
    }

    public Float getClientBalance(String clientId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT balance FROM clients WHERE client_id = ?");
            preparedStatement.setString(1, clientId);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.getFloat(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.f;
        }
    }
    public void updateBalance(String clientId, Float newBalance) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE clients SET balance = ? WHERE client_id = ?");
            preparedStatement.setFloat(1, newBalance);
            preparedStatement.setString(2, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getColCount(String table) {
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + table)) {
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static void setInstance(Database db) {
        _instance = db;
    }
    public static Database getInstance() {
        return _instance;
    }
}
