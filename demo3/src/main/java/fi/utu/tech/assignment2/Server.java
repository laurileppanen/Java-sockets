package fi.utu.tech.assignment2;

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
            System.out.println("Odotetaan asiakkaan yhdistämistä");
            Socket cs = ss.accept();
            System.out.println("Asiakas yhdisti");

            var is = cs.getInputStream();
            byte[] vastaanotettu = is.readAllBytes();
            String vastaanotettuMerkkijonona = new String(vastaanotettu, "utf-8");
            System.out.println(vastaanotettuMerkkijonona);

            cs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

