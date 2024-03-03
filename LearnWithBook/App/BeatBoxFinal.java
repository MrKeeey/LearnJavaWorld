package LearnWithBook.App;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.Timer;

public class BeatBoxFinal {

    String work = "";
    JFrame theFrame;
    JPanel mainPanel;
    JList incomingList;
    JTextField userMessage;
    JTextField loginField;
    JFrame saveFrame;
    ArrayList<JCheckBox> checkboxList;
    int nextNum;
    Vector<String> listVector = new Vector<String>();
    String userName;
    ObjectOutputStream out;
    ObjectInputStream in;
    HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();

    Sequencer sequencer;
    Sequence sequence;
    Sequence mySequence = null;
    Track track;
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat","Acoustic Snare", "Crash Cymbal", "Hand Clap",
                                "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
                                "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBoxFinal().startName();
    }

    public void startName() {

        theFrame  = new JFrame("Login");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel loginLabel = new JLabel("Enter your name:");
        loginField = new JTextField(20);
        JButton loginEnter = new JButton("Enter");
        loginEnter.addActionListener(new StartLoginEnterButtonListener());

        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        loginPanel.add(loginEnter);

        theFrame.getContentPane().add(BorderLayout.CENTER, loginPanel);
        theFrame.setBounds(50, 50, 400, 80);
        theFrame.pack();
        theFrame.setVisible(true);

    }

    public void startUp() {
        try {

            Socket socket = new Socket("localhost", 5000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            Thread remote = new Thread(new RemoteReader());
            remote.start();

        } catch (Exception exception) {
            System.out.println("Couldn't connect - you'll have to play alone.");
        }
        setUpMidi();
        buildGui();
    }

    public void buildGui() {

        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkboxList = new ArrayList<JCheckBox>();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(2, 10, 2, 2);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        constraints.ipadx = 10;
        constraints.ipady = 10;
        constraints.weightx = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonPanel.add(start, constraints);

        constraints.weightx = 0.3;
        constraints.gridx = 1;
        constraints.gridy = 0;
        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonPanel.add(stop, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JButton unTempo = new JButton("Tempo Up");
        unTempo.addActionListener(new MyUpTempoListener());
        buttonPanel.add(unTempo, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonPanel.add(downTempo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JButton saveCheckboxInstruments = new JButton("Save Build");
        saveCheckboxInstruments.addActionListener(new SaveCheckboxInstrumentsListener());
        buttonPanel.add(saveCheckboxInstruments, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton loadCheckboxInstruments = new JButton("Load Build");
        loadCheckboxInstruments.addActionListener(new LoadCheckboxInstrumentsListener());
        buttonPanel.add(loadCheckboxInstruments, constraints);

        incomingList = new JList();
        incomingList.addListSelectionListener(new MyListSelectionListener());
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane theList = new JScrollPane(incomingList);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 10, 10, 2);
        buttonPanel.add(theList, constraints);
        incomingList.setListData(listVector);

        userMessage = new JTextField(19);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 10, 2, 2);
        buttonPanel.add(userMessage, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.ipadx = 3;
        constraints.ipady = 3;
        constraints.anchor = GridBagConstraints.EAST;
        JButton sendIt = new JButton("Send It");
        sendIt.addActionListener(new MySendListener());
        buttonPanel.add(sendIt, constraints);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonPanel);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        theFrame.setBounds(50, 50, 800, 450);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    public void buildTrackAndStart() {

        ArrayList<Integer> trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i ++) {
            trackList = new ArrayList<Integer>();
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) checkboxList.get(j + (16 * i));
                if (jc.isSelected()) {
                    int key = instruments[i];
                    trackList.add(key);
                    //trackList.add(new Integer(key));
                } else trackList.add(null);
            }
            makeTracks(trackList);
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

    public class StartLoginEnterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!loginField.getText().equals("")) {
                userName = loginField.getText();
                theFrame.setVisible(false);
                theFrame.dispose();
                startUp();
            }
        }
    }

    public class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    public class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .97));
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

            //saveCurrentBuild();
            //guiForSaveCurrentBuild();
            //new SaveCheckboxInstrumentsListener().actionPerformed(e);

            boolean[] checkboxState = new boolean[256];

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

    public class MySendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkBoxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()) {
                    checkBoxState[i] = true;
                }
            }
            try {
                if (!userMessage.getText().equals("")) {
                    out.writeObject(userName + ": " + userMessage.getText());
                    out.writeObject(checkBoxState);
                }
            } catch (Exception exception) {
                System.out.println("Sorry dude. Couldn't send it to the server.");
            }
            userMessage.setText("");
        }
    }

    public class MyListSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent le) {
            if (!le.getValueIsAdjusting()) {
                String selected = (String) incomingList.getSelectedValue();
                if (selected != null) {
                    //saveCurrentBuild();
                    guiForSaveCurrentBuild();
                    if (!saveFrame.isVisible()) {                                              //need to wait
                        boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
                        changeSequence(selectedState);
                        sequencer.stop();
                        buildTrackAndStart();
                    }
                }
            }
        }
    }

    public void guiForSaveCurrentBuild() {

        saveFrame  = new JFrame("Save");
        JPanel savePanel = new JPanel();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(2, 2, 20, 2);
        savePanel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        JLabel saveLabel = new JLabel("Save your current build?");
        savePanel.add(saveLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        JButton saveYes = new JButton("Yes");
        saveYes.addActionListener(new SaveCurrentBuildYesButtonListener());
        savePanel.add(saveYes, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.EAST;
        JButton saveNo = new JButton("No");
        saveNo.addActionListener(new SaveCurrentBuildNoButtonListener());
        savePanel.add(saveNo, constraints);

        saveFrame.getContentPane().add(BorderLayout.CENTER, savePanel);
        saveFrame.setBounds(100, 100, 250, 150);
        saveFrame.setVisible(true);

    }

    public boolean[] saveCurrentBuild () {

        boolean[] checkBoxState = new boolean[256];

        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = checkboxList.get(i);
            if (checkBox.isSelected()) {
                checkBoxState[i] = true;
            }
        }
        return checkBoxState;
    }

    public void saveInFileCurrentBuild(boolean[] checkBoxState) {

        JFileChooser fileSave = new JFileChooser();
        fileSave.showSaveDialog(theFrame);

        if (fileSave.getSelectedFile() != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileSave.getSelectedFile()))) {
                oos.writeObject(checkBoxState);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }

    public class SaveCurrentBuildYesButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //saveInFileCurrentBuild(saveCurrentBuild());
            new SaveCheckboxInstrumentsListener().actionPerformed(e);
            saveFrame.setVisible(false);
            saveFrame.dispose();
        }
    }

    public class SaveCurrentBuildNoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveFrame.setVisible(false);
            saveFrame.dispose();
        }
    }

    public class RemoteReader implements Runnable {
        boolean[] checkBoxState = null;
        String nameToShow = null;
        Object obj = null;

        public void run() {
            try {
                while ((obj = in.readObject()) != null) {
                    System.out.println("Got an object form server.");
                    System.out.println(obj);
                    nameToShow = (String) obj;
                    checkBoxState = (boolean[]) in.readObject();
                    otherSeqsMap.put(nameToShow, checkBoxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public class MyPlayMineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (mySequence != null) {
                sequence = mySequence;
            }
        }
    }

    public void changeSequence (boolean[] checkBoxState) {
        for (int i = 0; i < 256; i++) {
            JCheckBox check = (JCheckBox) checkboxList.get(i);
            if (checkBoxState[i]) {
                check.setSelected(true);
            } else check.setSelected(false);
        }
    }

    public void makeTracks (ArrayList list) {
        Iterator it = list.iterator();
        for (int i = 0; i < 16; i++) {
            Integer num = (Integer) it.next();
            if (num != null) {
                int numKey = num.intValue();
                track.add(makeEvent(144, 9, numKey, 100, i));
                track.add(makeEvent(128, 9, numKey, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent (int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return event;
    }

}
