package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    public static void main(String[] args) {
        Server s = new Server();
        s.run();
    }

    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(4000)) {
            while (true) {
                ClientHandler ch = new ClientHandler(ss.accept());
                ch.setDaemon(true);
                ch.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
