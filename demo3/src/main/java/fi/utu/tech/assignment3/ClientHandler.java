package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
    Socket cs;

    public ClientHandler(Socket cs) {
        this.cs = cs;
    }

    @Override
    public void run() {
        try (var is = cs.getInputStream()) {
            byte[] vastaanotettu = is.readAllBytes();
            String vastaanotettuMerkkijonona = new String(vastaanotettu, "utf-8");
            System.out.println(vastaanotettuMerkkijonona);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
