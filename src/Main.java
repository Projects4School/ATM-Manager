import Services.Database;
import UI.Window;

import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Database connexion = new Database("ATM-Database.db");
        connexion.connect();

        new Window();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                connexion.close();
                System.out.println("Closed process thread.");
            }
        }, "exit-thread"));
    }
}