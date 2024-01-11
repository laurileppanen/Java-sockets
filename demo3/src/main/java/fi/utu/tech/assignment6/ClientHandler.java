package fi.utu.tech.assignment6;


import java.io.*;
import java.net.Socket;

import static java.lang.System.out;

public class ClientHandler extends Thread {
    Socket cs;
    Hub hub;

    public ClientHandler(Socket cs, Hub h) {
        this.hub = h;
        this.cs = cs;
    }

    @Override
    public void run() {
        try (var is = cs.getInputStream(); var os = cs.getOutputStream()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
            String seuraavaViesti;
            while ((seuraavaViesti = in.readLine()) != null) {
                var jaaViesti = seuraavaViesti.split(";");
                if (jaaViesti.length > 1 && !jaaViesti[0].equals("LIGHT")) {
                    continue;
                }
                if (jaaViesti[1].equals("ON")) {
                    var id = Integer.parseInt(jaaViesti[2]);
                    hub.turnOffLight(id);
                } else if (jaaViesti[1].equals("QUERY")) {
                    var lights = hub.getLights();
                    StringBuilder sb = new StringBuilder();
                    for (var l : lights) {
                        var s = String.format("%d:%s;", l.getId(), l.isPowerOn() ? "ON" : "OFF");
                        sb.append(s);
                    }
                    out.println(sb.toString());
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
