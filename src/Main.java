import Services.Database;
import UI.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new Window();
        Database connexion = new Database("ATM-Database.db");
        connexion.connect();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                connexion.close();
                System.out.println("Closed process thread.");
            }
        }, "exit-thread"));
    }
}