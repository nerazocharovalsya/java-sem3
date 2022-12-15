package task_12;

import java.util.Scanner;

public class Test12 {
    static void func12(){
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        if (num == 0) {
            return;
        }

        if (num % 2 != 0) {
            System.out.println(num);
            func12();
        }
        else {
            func12();
        }
    }
    public static void main(String[] args){
        func12();
    }
}
