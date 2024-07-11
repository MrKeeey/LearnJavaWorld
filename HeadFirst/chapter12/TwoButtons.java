package HeadFirst.chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {
    JFrame frame;
    JLabel label;
    byte[] array = new byte[3];

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame("TwoButtons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelLisener());
        JButton colorButton = new JButton("Change Circle Color");
        colorButton.addActionListener(new ColorLisener());

        label = new JLabel("I'm a label!");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class LabelLisener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /* new Random().nextBytes(array);
            String generationString = new String(array, Charset.forName("UTF-8"));
            label.setText(" " + generationString + " ");*/
            label.setText(" Ouch! ");
        }
    }

    class ColorLisener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }
}
