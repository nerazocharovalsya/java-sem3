package task_13;

import java.util.Scanner;

public class Test13 {
    static void func13(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n > 0) {
            int m = in.nextInt();
            System.out.println(n);
            if (m > 0) {
                func13();
            }
        }
    }
    public static void main(String[] args){
        func13();
    }
}
