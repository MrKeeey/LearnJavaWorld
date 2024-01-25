package LearnWithBook.chapter13;

import javax.swing.*;
import java.awt.*;

public class borderLayoutTestFrame {

    public static void main(String[] args) {
        borderLayoutTestFrame gui = new borderLayoutTestFrame();
        gui.go();
    }

    public void go() {

        JFrame frame = new JFrame("BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton east = new JButton("East");
        JButton west = new JButton("Big West Button");
        JButton north = new JButton("North");
        JButton south = new JButton("South");
        JButton center = new JButton("Small Center");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        north.setFont(new Font("ARIAL", Font.BOLD, 30));
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
