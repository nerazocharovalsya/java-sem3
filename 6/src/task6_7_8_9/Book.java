package task6_7_8_9;

public class Book implements Printable{
    public Book(String name) {
        this.name = name;
    }

    public String name;

    @Override
    public void print() {
        System.out.print(name + " ");
    }
}
