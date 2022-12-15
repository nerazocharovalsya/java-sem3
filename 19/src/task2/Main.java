package task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> s = new ArrayList<>();
        s.add(new Student("Дима", 67, 12, 18));
        s.add(new Student("Аня", 57, 12, 18));
        s.add(new Student("Лёша", 93, 12, 19));
        s.add(new Student("Вова", 24, 2, 18));
        s.add(new Student("Таня", 66, 12, 18));

        new LabClassUI(s);
    }

}