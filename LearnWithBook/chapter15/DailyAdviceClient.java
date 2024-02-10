package LearnWithBook.chapter15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DailyAdviceClient {
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go() {

        try {

            Socket chatSocket = new Socket("127.0.0.1", 4242);

            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
            writer.println("Hello!");
            writer.println("I'm Meow ><");
            writer.close();

            //Socket socket = new Socket("127.0.0.1", 4242);
            InputStreamReader inputStreamReader = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String advice = reader.readLine();
            System.out.println(advice);

            reader.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
