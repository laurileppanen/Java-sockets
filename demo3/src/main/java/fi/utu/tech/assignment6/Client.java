package fi.utu.tech.assignment6;


import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 4000)) {
            var is = s.getInputStream();
            var os = s.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
            out.println("LIGHT;QUERY");
            out.flush();
            System.out.println(in.readLine());
            out.println("LIGHT;ON;2");
            out.println("LIGHT;OFF;1");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
