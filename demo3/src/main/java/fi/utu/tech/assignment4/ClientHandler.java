package fi.utu.tech.assignment4;


import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    Socket cs;

    public ClientHandler(Socket cs) {
        this.cs = cs;
    }

    @Override
    public void run() {
        try (var is = cs.getInputStream(); var os = cs.getOutputStream()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
            String seuraavaViesti;
            while ((seuraavaViesti = in.readLine()) != null) {
                System.out.println(seuraavaViesti);
                if (seuraavaViesti.equals("Morjesta")) {
                    out.println("Terve");
                    out.flush();
                } else if (seuraavaViesti.equals("Kuitti")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Yhteys suljettu");
        }
    }
}
