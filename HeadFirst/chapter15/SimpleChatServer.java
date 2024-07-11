package HeadFirst.chapter15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleChatServer {

    ArrayList clientOutputStreams;
    public static void main(String[] args) {
        new SimpleChatServer().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList<>();
        try {

            ServerSocket serverSocket = new ServerSocket(5000);
            while(true) {

                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
                System.out.println("Got a connection");

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void tellEveryone(String message) {
        Iterator iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {

                PrintWriter writer = (PrintWriter) iterator.next();
                writer.println(message);
                writer.flush();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket clientSocket) {
            try {

                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {

                while((message = reader.readLine()) != null) {
                    System.out.println("ReadS " + message);
                    tellEveryone(message);
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
