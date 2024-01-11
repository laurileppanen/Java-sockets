package fi.utu.tech.assignment4;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 4000)) {
            var is = s.getInputStream();
            var os = s.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
            out.println("Morjesta");
            out.flush();
            var answer = in.readLine();
            if (answer.equals("Terve")) {
                System.out.println("Varmistus saatu");
                out.println("Kuitti");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
