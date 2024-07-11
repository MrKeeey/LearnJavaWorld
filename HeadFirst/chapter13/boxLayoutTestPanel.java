package HeadFirst.chapter13;

import javax.swing.*;
import java.awt.*;

public class boxLayoutTestPanel {

    public static void main(String[] args) {
        boxLayoutTestPanel gui = new boxLayoutTestPanel();
        gui.go();
    }

    public void go() {

        JFrame frame = new JFrame("BoxLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Shock Me");
        JButton buttonTwo = new JButton("Bliss");
        JButton buttonThree = new JButton("Huh? Huh?");

        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250, 200);
        frame.setVisible(true);

    }

}
