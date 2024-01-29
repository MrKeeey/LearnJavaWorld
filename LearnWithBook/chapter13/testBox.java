package LearnWithBook.chapter13;

import javax.swing.*;
import java.awt.*;

public class testBox {

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
            "Low-mid Tom", "High Agogo", "Open Hi Conga"};

    public static void main(String[] args) {
        testBox gui = new testBox();
        gui.go();
    }
    public void go() {

        JFrame frame = new JFrame("Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(2, 2, 2, 2);

        JPanel buttonBox = new JPanel();
        buttonBox.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = 10;
        constraints.ipady = 10;
        JButton start = new JButton("Start");
        buttonBox.add(start, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipadx = 0;
        constraints.ipady = 0;
        JButton stop = new JButton("StopStop");
        buttonBox.add(stop, constraints);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        buttonBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
        nameBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        frame.getContentPane().add(BorderLayout.WEST, nameBox);
        frame.getContentPane().add(BorderLayout.EAST, buttonBox);

        //frame.setSize(300, 300);
        //frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }
}
