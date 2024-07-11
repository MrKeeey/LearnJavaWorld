package HeadFirst.chapter10;

import java.util.Calendar;
import java.util.Date;

public class dateCalendar {
    public static void main(String[] args) {
        //use date
        System.out.println(String.format("%tc", new Date()));
        System.out.println(String.format("%tr", new Date()));

        System.out.println(String.format("%tB %td - %tA", new Date(), new Date(), new Date()));
        Date today = new Date();
        System.out.println(String.format("%tB %td - %tA", today, today, today));        //same
        System.out.println(String.format("%tB %<td - %<tA", today));                    //same but sort

        //use calendar
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(cal.HOUR));

        if(cal.get(cal.HOUR_OF_DAY) > 12){
            System.out.println((cal.get(cal.HOUR_OF_DAY)-12) + " PM");
        }else{
            System.out.println(cal.get(cal.HOUR_OF_DAY) + " AM");
        }

        cal.set(1992,7,15,14,32, 45);
        System.out.println("Date now:     " + cal.getTime());

        long day = cal.getTimeInMillis();
        day += 1000 * 60 * 60;
        cal.setTimeInMillis(day);
        System.out.println("+ 1 hour:     " + cal.getTime());
        cal.add(cal.DATE, 15);
        System.out.println("+ 15 days:    " + cal.getTime());
        cal.roll(cal.DATE, 15);
        System.out.println("Roll 15 days: " + cal.getTime());
        cal.set(cal.DATE, 1);
        System.out.println("Now is 1 num: " + cal.getTime());
    }
}
