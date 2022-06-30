import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8089;
        while (true){
            ServerSocket serverSocket = new ServerSocket(port);
            try (Socket clientSocket = serverSocket.accept()) {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("New connection accepted");

                String name = in.readLine();

                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            }
        }

    }
}
