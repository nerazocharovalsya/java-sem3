package task_2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CompareDate {
    int year, month, day;
    Calendar calUser = Calendar.getInstance();
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd");

    public CompareDate(int yearU, int monthU, int dayU){
        calUser.set(Calendar.YEAR, yearU);
        calUser.set(Calendar.MONTH, monthU - 1);
        calUser.set(Calendar.DAY_OF_MONTH, dayU);
    }

    public CompareDate() {
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public void to1() {
        System.out.println("Введённая дата: " + sdf.format(calUser.getTime()));
    }

    public void to() {
        System.out.println("Настоящая дата: " + sdf.format(calUser.getTime()));
    }

    public void compareCal(){
        System.out.printf("Разница во времени: ");
        System.out.println(sdf.format(cal.getTime()).equals(sdf.format(calUser.getTime())));
    }

    public static void main(String[] args) {
        CompareDate compareDate = new CompareDate();
        compareDate.to();
        CompareDate compareDate1 = new CompareDate(1986, 2, 14);
        compareDate1.to1();
        System.out.println();
        compareDate1.compareCal();
        System.out.println();
        CompareDate compareDate2 = new CompareDate(2022, 10, 20);
        compareDate2.to1();
        System.out.println();
        compareDate2.compareCal();
        System.out.println();
    }
}
