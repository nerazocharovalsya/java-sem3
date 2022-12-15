package task_1;

import java.util.Arrays;
import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Введите выражение:");
        String p = sc.nextLine();
        System.out.println(Arrays.toString(str.split(p)));
    }
}
