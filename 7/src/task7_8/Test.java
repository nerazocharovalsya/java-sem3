package task7_8;

public class Test {
    public static void main(String[] args){
        Book book1 = new Book("Book 1");
        Book book2 = new Book("Book 2");
        Book book3 = new Book("Book 3");
        Book book4 = new Book("Book 4");
        Magazine magazine1 = new Magazine("Magazine 1");
        Magazine magazine2 = new Magazine("Magazine 2");
        Magazine magazine3 = new Magazine("Magazine 3");
        Magazine magazine4 = new Magazine("Magazine 4");
        Printable[] printables = {book1, book2, magazine4, magazine3, book3, magazine1, magazine2, book4};
        Book.printBook(printables);
        Magazine.printMagazines(printables);
    }
}
