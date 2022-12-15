package task_1;

import java.util.Date;
import java.util.Scanner;
public class Developer {
    static String surname;
    static Date start;
    static Date finish;
    static String doSurname() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите фамилию разработчика ");
        surname = in.nextLine();
        System.out.println("Фамилия разработчика " + surname);
        return surname;
    }
    static Date start() {
        Date start = new Date();
        start.getDate();
        System.out.println("Дата начала " + start);
        return start;
    }
    static Date finish() {
        Date finish = new Date();
        Long time = finish.getTime();
        time = time + (60 * 60 * 24 * 1000 * 7);
        finish = new Date(time);
        System.out.println("Дата окончания " + finish);
        return finish;
    }
    public static void main(String[] args) {
        doSurname();
        start();
        finish();
    }
}