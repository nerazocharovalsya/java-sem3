package task7_8;

public class Book implements Printable{
    String name;
    Book(String name){
        this.name=name;
    }
    @Override
    public void print() {
        System.out.println(name);
    }
    public static void printBook(Printable[] printable){
        for (Printable p: printable) {
            if (p instanceof Book)
                p.print();
        }
    }
}
