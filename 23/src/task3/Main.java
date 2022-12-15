package task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Subtract(new Multiply(new Const(2), new Variable("x")), new Const(3)).evaluate(5,0,0));
        System.out.println(new Subtract(new Const(5), new Const(10)).evaluate(0,0,0));
        System.out.println("Введите x: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(new Add(new Subtract(new Multiply(new Variable("x"), new Variable("x")), new Multiply(new Const(2), new Variable("x"))), new Const(1)).evaluate(a,0,0));
    }
}
