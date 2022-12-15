package task_10;

import java.util.Scanner;

public class Test10 {
    static int func10(int n, int a){
        if (n == 0) {
            return a;
        }
        else {
            return func10(n / 10, 10 * a + n % 10);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        System.out.println(func10(t,0));
    }
}
