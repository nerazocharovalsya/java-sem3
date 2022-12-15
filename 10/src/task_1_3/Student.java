package task_1_3;

public class Student implements Comparable{
    private int idNumber;
    private int GPA;
    private String name;
    private String surname;
    private String specialization;
    private int course;
    private int group;

    public Student(int idNumber, int GPA) {
        this.idNumber = idNumber;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idNumber=" + idNumber +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.GPA - ((Student) o).GPA;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
