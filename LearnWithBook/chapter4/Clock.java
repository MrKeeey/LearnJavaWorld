package LearnWithBook.chapter4;

public class Clock {
    String time;

    void setTime(String t) {
        time = t;
    }

    String getTime(){
        return time;
    }
}

class ClockTest{
    public static void main(String[] args) {
        Clock clock = new Clock();

        clock.setTime("19:54");
        String timenow = clock.getTime();
        System.out.println("Time: " + timenow);
    }
}