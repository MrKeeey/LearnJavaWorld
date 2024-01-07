package LearnWithBook.chapter10;
import java.util.Calendar;
import java.util.Date;

public class dateCalendar {
    public static void main(String[] args) {
        System.out.println(String.format("%tc", new Date()));
        System.out.println(String.format("%tr", new Date()));

        System.out.println(String.format("%tB %td - %tA", new Date(), new Date(), new Date()));
        Date today = new Date();
        System.out.println(String.format("%tB %td - %tA", today, today, today));        //same
        System.out.println(String.format("%tB %<td - %<tA", today));                    //same but sort

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(cal.HOUR_OF_DAY));

        if(cal.get(cal.HOUR_OF_DAY) >= 12){
            System.out.println(cal.get(cal.HOUR_OF_DAY) + " PM");
        }else{
            System.out.println(cal.get(cal.HOUR_OF_DAY) + " AM");
        }
    }
}
