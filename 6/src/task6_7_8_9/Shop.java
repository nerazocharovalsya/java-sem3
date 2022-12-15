package task6_7_8_9;

import java.util.ArrayList;

public class Shop {
    public ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args){
        Shop shop = new Shop();
        shop.books.add(new Book("Книга 1"));
        shop.books.add(new Book("Книга 2"));
        shop.books.add(new Book("Книга 3"));
        shop.books.add(new Book("Книга 4"));
        shop.books.add(new Book("Книга 5"));
        for(int i = 0; i < shop.books.size(); i++){
            shop.books.get(i).print();
        }
    }
}
