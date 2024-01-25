package LearnWithBook.chapter13;

import javax.swing.*;
import java.awt.*;

public class flowLayoutTestPanel {
    public static void main(String[] args) {
        flowLayoutTestPanel gui = new flowLayoutTestPanel();
        gui.go();
    }

    public void go(){

        JFrame frame = new JFrame("FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setBackground(Color.gray);
        panel2.setBackground(Color.gray);

        JButton button = new JButton("Shock me");
        JButton buttonTwo = new JButton("Bliss");
        JButton buttonThree = new JButton("Huh? Huh?");

        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.getContentPane().add(BorderLayout.WEST, panel2);

        frame.setSize(250, 200);
        frame.setVisible(true);

    }
}
