import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 8083;

        try (Socket clienSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))
        ) {
            System.out.println("Connect " + host);
            String resp = in.readLine();
            System.out.println(resp);

            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println(host + ", ip address: " + inetAddress.getHostAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
