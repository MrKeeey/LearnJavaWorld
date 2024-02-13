package LearnWithBook.chapter15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {

    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
    public void go() {

        JFrame frame = new JFrame("Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        setUpNetworking();
        frame.setSize(400, 200);
        frame.setVisible(true);

    }
    private void setUpNetworking() {
        try {

            socket = new Socket("localhost", 5000);
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
                writer.close();

            } catch (Exception exception) {
                exception.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
}
