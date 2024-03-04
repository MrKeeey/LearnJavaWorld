package LearnWithBook.AppendixB;

public class TestEnum {
    public enum Members {
        JERRY,
        BOBBY,
        PHIL
    }

    enum Names {
        JERRY("Solo guitar") { public String sing() {
            return "Sad";
        }},
        BOBBY("Ritm guitar") { public String sing() {
            return "Hard";
        }},
        PHIL("Bass guitar");

        private String instruments;

        Names (String instruments) {
            this.instruments = instruments;
        }

        public String getInstruments() {
            return instruments;
        }
        public String sing() {
            return "Rarely";
        }
    }

    public static void main(String[] args) {

        Members m = Members.JERRY;
        if (m.equals(Members.JERRY)) {
            System.out.println("This is JERRY");
        }
        if (m == Members.BOBBY) System.out.println("This is BOBBY");

        m = Members.PHIL;
        switch (m) {
            case JERRY: System.out.println("Sing");
            case BOBBY: System.out.println("Dance");
            case PHIL: System.out.println("Smile");
        }

        for (Names n : Names.values()) {
            System.out.print(n);
            System.out.print(", instrument: " + n.getInstruments());
            System.out.println(", sounds: " + n.sing());
        }

    }
}
