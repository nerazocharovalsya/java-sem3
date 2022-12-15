package task2;

import java.util.ArrayList;

public class TestStudent {
    private  static StudentComp comp = new StudentComp();

    public static void qSort(Object[] array, int high, int low){
        if(array == null || array.length == 0) return;
        if(high <= low) return;

        Object middle = array[(low + high)/2];
        ArrayList<Object> left = new ArrayList<>();
        ArrayList<Object> right = new ArrayList<>();
        ArrayList<Object> eq = new ArrayList<>();
        for(int i = low; i <= high; i++){
            if(comp.compare(array[i], middle) > 0){
                right.add(array[i]);
            }
            else if (comp.compare(array[i], middle) < 0)
                left.add(array[i]);
            else eq.add(array[i]);
        }
        Object[] leftArr;
        Object[] rightArr;
        if(left.size()>0) {
            leftArr = left.toArray();
            qSort(leftArr, left.size() - 1, 0);
            System.arraycopy(leftArr, 0, array, low, left.size());
        }
        System.arraycopy(eq.toArray(), 0, array, low+left.size(), eq.size());

        if(right.size() > 0) {
            rightArr = right.toArray();
            qSort(rightArr, right.size() - 1, 0);
            System.arraycopy(rightArr, 0, array, low+left.size() + eq.size(), right.size());
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student(11, 56),
                new Student(12, 89),
                new Student(13, 32),
                new Student(14, 75)
        };
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        // Быстрая по GPA
        System.out.println();
        qSort(students, students.length-1, 0);
        for (Student s : students) {
            System.out.println(s);
        }
    }
}