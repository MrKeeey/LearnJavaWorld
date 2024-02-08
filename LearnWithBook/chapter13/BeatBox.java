package LearnWithBook.chapter13;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class BeatBox {

    JFrame theFrame;
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
                                "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
                                "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {

        new BeatBox().biuldGui();
    }

    public void biuldGui() {

        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        buttonBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton saveCheckboxInstruments = new JButton("Save Instruments");
        saveCheckboxInstruments.addActionListener(new SaveCheckboxInstrumentsListener());
        buttonBox.add(saveCheckboxInstruments);

        JButton loadCheckboxInstruments = new JButton("Load Instruments");
        loadCheckboxInstruments.addActionListener(new LoadCheckboxInstrumentsListener());
        buttonBox.add(loadCheckboxInstruments);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);
        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            checkboxList.add(checkBox);
            mainPanel.add(checkBox);
        }

        setUpMidi();

        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void buildTrackAndStart() {

        int[] trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxList.get(j + (16 * i));
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0 ,15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(comd, chan, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return event;
    }

    public class MyStartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.5));
        }
    }

    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .5));
        }
    }

    public class SaveCheckboxInstrumentsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            boolean[] checkboxState = new boolean[256];

            for (int i = 0; i < 256; i++) {
                JCheckBox checkBox = checkboxList.get(i);
                if (checkBox.isSelected()) {
                    checkboxState[i] = true;
                }
            }

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(theFrame);

            //try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Z:\\NW\\y\\LearnWorld\\LearnWithBook\\chapter13\\Checkbox.ser"))) {
            if (fileSave.getSelectedFile() != null) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileSave.getSelectedFile()))) {
                    oos.writeObject(checkboxState);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        }
    }

    public class LoadCheckboxInstrumentsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            boolean[] checkboxState = null;

            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(theFrame);

            if (fileOpen.getSelectedFile() != null) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileOpen.getSelectedFile()))) {
                    checkboxState = (boolean[]) ois.readObject();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            for (int i = 0; i < 256; i++) {
                JCheckBox checkBox = checkboxList.get(i);
                if (checkboxState[i]) {
                    checkBox.setSelected(true);
                } else {
                    checkBox.setSelected(false);
                }
            }

            sequencer.stop();
            buildTrackAndStart();

        }
    }
}
