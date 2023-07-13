package Services;

import Models.Client;

import java.sql.*;

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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, client.getClientId());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getName());
            preparedStatement.setString(4, client.getAddress());
            preparedStatement.setInt(4, client.getPostalCode());
            preparedStatement.setString(4, client.getCity());
            preparedStatement.setFloat(4, client.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void setInstance(Database db) {
        _instance = db;
    }
    public static Database getInstance() {
        return _instance;
    }
}
