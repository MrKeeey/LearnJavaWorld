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
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.33;


        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton start = new JButton("Start");
        buttonBox.add(start);
        JButton stop = new JButton("StopStop");
        buttonBox.add(stop);
        buttonBox.setSize(100, 100);

        Box nameBox = new Box(BoxLayout.PAGE_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }



        buttonBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
        nameBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        frame.getContentPane().add(nameBox, constraints);
        constraints.gridx = 1;
        frame.getContentPane().add(buttonBox, constraints);


        //frame.setSize(300, 300);
        //frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }
}
