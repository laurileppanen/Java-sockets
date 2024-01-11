package fi.utu.tech.assignment6;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

    public static void main(String[] args) {
        fi.utu.tech.assignment6.Server s = new fi.utu.tech.assignment6.Server();
        s.run();
    }

    @Override
    public void run() {
        Hub h = new Hub();
        try (ServerSocket ss = new ServerSocket(4000)) {
            while (true) {
                fi.utu.tech.assignment6.ClientHandler ch = new fi.utu.tech.assignment6.ClientHandler(ss.accept(), h);
                ch.setDaemon(true);
                ch.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
