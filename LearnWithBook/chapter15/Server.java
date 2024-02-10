package LearnWithBook.chapter15;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.go();
    }

    public void go() {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Started");

            Socket chatSocket = server.accept();
            System.out.println("Connected");

            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
            writer.println("Hello!");
            writer.print("I'm Meow ><");

            System.out.println("End work");
            writer.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
