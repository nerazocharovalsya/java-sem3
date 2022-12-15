package task_4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    public Date date;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm");
    public Time(){
        date = new Date();
        Long time = date.getTime();
        time = time + (60 * 60 * 24 * 1000 * 7);
        System.out.println(sdf.format(date));
        System.out.println(sdf.format(cal.getTime()));
    }

    public static void main(String[] args){
        Time time = new Time();
    }
}
