package LearnWithBook.chapter15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
    public void go() {

        JFrame frame = new JFrame("Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();

        incoming = new JTextArea(15,50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        setUpNetworking();
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);

    }
    private void setUpNetworking() {
        try {

            socket = new Socket("localhost", 5000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Connected");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                writer.println(outgoing.getText());
                writer.flush();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null){
                    System.out.println("Read " + message);
                    incoming.append(message);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
