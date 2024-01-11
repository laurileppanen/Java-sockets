package fi.utu.tech.assignment3;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 4000)) {
            var os = s.getOutputStream();
            String moro = "Morjesta";
            byte[] moroB = moro.getBytes("utf-8");
            os.write(moroB);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
