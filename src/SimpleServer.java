import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен и ожидает подключения...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress().getHostAddress());

// Создаем новый поток для обслуживания подключения
                new Thread(new ClientHandler(clientSocket)).start();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Сообщение от клиента: " + inputLine);
                out.println("Эхо: " + inputLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при общении с клиентом: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Не удалось закрыть сокет: " + e.getMessage());
            }
        }
    }
}