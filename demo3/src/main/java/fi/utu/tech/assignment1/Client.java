package fi.utu.tech.assignment1;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 4000)) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
