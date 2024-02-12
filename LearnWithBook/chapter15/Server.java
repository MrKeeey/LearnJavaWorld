package LearnWithBook.chapter15;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.",
            "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
            "You might want to rethink that haircut."};

    public static void main(String[] args) {
        Server server = new Server();
        server.go();
    }

    public void go() {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Started");

            while(true) {

                Socket chatSocket = server.accept();
                System.out.println("Connected");

                PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);

                writer.close();
                System.out.println("End work");

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
