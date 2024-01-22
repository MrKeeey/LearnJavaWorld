package LearnWithBook.chapter12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer2 implements ControllerEventListener {

    static JFrame frame = new JFrame("Animation");
    static boolean flag = false;

    public static void main(String[] args) {
        MiniMusicPlayer2 miniplayer = new MiniMusicPlayer2();
        miniplayer.go();
    }

    public void go() {
        try {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            drawPanel2 drawpanel2 = new drawPanel2();
            frame.getContentPane().add(BorderLayout.CENTER, drawpanel2);
            //frame.setContentPane(drawpanel2);
            //frame.setBounds(30, 30, 400, 400);
            frame.setSize(400, 400);
            frame.setVisible(true);

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i += 4){
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void controlChange(ShortMessage event) {
        flag = true;
        frame.repaint();
        try {
            Thread.sleep(50);
        } catch(Exception ex) {
             ex.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {

            ShortMessage msg = new ShortMessage();
            msg.setMessage(comd, chan, one, two);
            event = new MidiEvent(msg, tick);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }

    class drawPanel2 extends JPanel {
        public void paintComponent (Graphics graphics) {

            if (flag) {
                System.out.println("la");
                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                Color randomColor = new Color(red, green, blue);

                int x = (int) ((Math.random() * 250) + 10);
                int y = (int) ((Math.random() * 250) + 10);
                int width = (int) ((Math.random() * 80) + 10);
                int height = (int) ((Math.random() * 80) + 10);

                graphics.setColor(randomColor);
                graphics.fillRect(x, y, width, height);
                flag = false;

            }
        }
    }
}
