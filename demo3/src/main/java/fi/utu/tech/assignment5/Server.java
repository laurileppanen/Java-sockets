package fi.utu.tech.assignment5;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

    public static void main(String[] args) {
        fi.utu.tech.assignment5.Server s = new fi.utu.tech.assignment5.Server();
        s.run();
    }

    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(4000)) {
            while (true) {
                fi.utu.tech.assignment5.ClientHandler ch = new fi.utu.tech.assignment5.ClientHandler(ss.accept());
                ch.setDaemon(true);
                ch.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
