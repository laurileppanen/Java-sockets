package fi.utu.tech.assignment5;

import java.io.*;
import java.net.Socket;

import static java.lang.System.out;

public class ClientHandler extends Thread {
    Socket cs;

    public ClientHandler(Socket cs) {
        this.cs = cs;
    }

    @Override
    public void run() {
        try (var is = cs.getInputStream(); var os = cs.getOutputStream()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String seuraavaViesti;
            while ((seuraavaViesti = in.readLine()) != null) {
                out.println(seuraavaViesti);
                var jaaViesti = seuraavaViesti.split(";");
                if (jaaViesti.length > 1 && !jaaViesti[0].equals("LIGHT")) {
                    continue;
                }
                if (jaaViesti[1].equals("ON")) {
                    var id = Integer.parseInt(jaaViesti[2]);
                    System.out.printf("Asetetaan valo %d ON %n", id);
                } else if (jaaViesti[1].equals("QUERY")) {
                    out.println("Query-komento vastaanotettu");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.println("Yhteys suljettu");
        }
    }
}
