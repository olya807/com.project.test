import java.io.*;
import java.net.*;

public class SimpleEchoServer {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Echo Server запущен на порту 8080.");

            while (true) try (Socket clientSocket = serverSocket.accept();
                              PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                              BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Сервер получил: " + inputLine);
                    out.println("Эхо: " + inputLine);
                }
            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port 8080 or listening for a connection");
                System.out.println(e.getMessage());
            }
        }
    }
}