package task_3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Student {
    public String name;
    public SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy");
    public SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
    public SimpleDateFormat sdf3 = new SimpleDateFormat("MMMM d, yyyy");
    public Calendar cal = Calendar.getInstance();

    public Student(String name) {
        this.name = name;
        int year = 2000 + (int)(Math.random()*10);
        int month = (int)(Math.random()*12);
        int day = 1+(int)(Math.random()*28);
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);
    }

    @Override
    public String toString(){
        return "Student{" +
                "name=" + name +
                ", date=" + getDate((int)(Math.random()*3)) +
                '}';
    }

    public String getDate(int n){
        switch (n){
            case 0:
                return sdf1.format(cal.getTime());
            case 1:
                return sdf2.format(cal.getTime());
            case 2:
                return sdf3.format(cal.getTime());
            default:
                return "";
        }
    }

    public static void main(String[] args){
        Student student1 = new Student("Alex");
        System.out.println(student1);
    }
}
