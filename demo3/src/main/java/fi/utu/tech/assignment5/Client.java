package fi.utu.tech.assignment5;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 4000)) {
            var os = s.getOutputStream();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
            out.println("LIGHT;QUERY");
            out.println("LIGHT;ON;3");
            out.println("LIGHT;OFF;2");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
