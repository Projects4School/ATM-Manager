package Services;

import Models.Client;

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
