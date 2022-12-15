package task10;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

enum names{
    apple, lenovo, msi, acer, asus, hp, dell;
}

public class Shop implements Consult {
    public ArrayList<Computer> computers = new ArrayList<>();
    public void addComputer(Computer computer){
        computers.add(computer);
    }
    public void deleteComputer(names name){
        for(int i = 0; i < computers.size(); i++){
            if(computers.get(i).getName().equals(name)){
                computers.remove(i);
            }
        }
    }
    public void findComputer(names name){
        boolean flag = false;
        for(int i = 0; i < computers.size(); i++){
            if(computers.get(i).getName().equals(name)) {
                flag = true;
            }
        }
        if(flag){
            System.out.println("Есть в наличии");
        }
        else{
            System.out.println("Нет в наличии");
        }
    }

    public static void main(String[] args){
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        String name;
        for(int i = 0; i < 7; i++) {
            shop.addComputer(new Computer(names.values()[new Random().nextInt(names.values().length)]));
        }
        shop.findComputer(names.apple);
    }
}
