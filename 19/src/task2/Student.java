package task2;

public class Student implements Comparable<Student>{
    private String name;
    private int gpa, group, age;

    public static final AgeComparator AGE_COMP = new AgeComparator();
    public static final GpaComparator GPA_COMP = new GpaComparator();
    public static final GroupComparator GROUP_COMP = new GroupComparator();

    public Student(String name, int gpa, int group, int age) {
        this.name = name;
        this.gpa = gpa;
        this.group = group;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setFio(String name) {
        if(name.equals(""))
            throw new EmptyStringException();
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name = '" + name + '\'' +
                ", gpa = " + gpa +
                ", groupNum=" + group +
                ", age = " + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}