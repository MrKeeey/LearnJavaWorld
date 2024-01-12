package LearnWithBook.chapter11;

import javax.sound.midi.*;

public class TestExceptions {
    public static void main(String[] args) {

        String test = "yes";
        try {
            System.out.println("Start try");
            doRisky(test);
            System.out.println("End try");
        } catch (MidiUnavailableException se) {
            System.out.println("Scary Exception");
        } finally {
            System.out.println("Finally");
        }
        System.out.println("End of main");
    }

    static void doRisky(String test) throws MidiUnavailableException {
        Sequencer sequencer = MidiSystem.getSequencer();
        System.out.println("Start risky");
        if ("yes".equals(test)) {
            throw new MidiUnavailableException();
        }
        System.out.println("End risky");
    }
}
