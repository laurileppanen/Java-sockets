package fi.utu.tech.assignment4;

import fi.utu.tech.assignment3.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

    public static void main(String[] args) {
        Server s = new Server();
        s.run();
    }

    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(4000)) {
            while (true) {
                fi.utu.tech.assignment4.ClientHandler ch = new fi.utu.tech.assignment4.ClientHandler(ss.accept());
                ch.setDaemon(true);
                ch.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
