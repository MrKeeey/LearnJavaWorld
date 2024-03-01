package LearnWithBook.App;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class MusicServer {

    ArrayList<ObjectOutputStream> clientOutputStreams;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList<ObjectOutputStream>();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("Got a connection");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void tellEveryone(Object one, Object two) {
        Iterator<ObjectOutputStream> it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) it.next();
                out.writeObject(one);
                out.writeObject(two);
                System.out.println("fine");
            } catch (Exception exception) {
                System.out.println("here");
                exception.printStackTrace();
            }
        }
    }

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket clientSocket;

        public ClientHandler(Socket socket) {
            try {
                clientSocket = socket;
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        @Override
        public void run() {
            Object o1 = null;
            Object o2 = null;
            try {
                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();
                    System.out.println("Read two objects.");
                    tellEveryone(o1, o2);
                }
            } catch (Exception exception) {
                boolean connected = clientSocket.isClosed() && !clientSocket.isConnected();
                if (!connected) {
                    System.out.println("Client left");
                }
            }
        }
    }
}
