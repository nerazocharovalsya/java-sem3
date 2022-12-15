package task4;

import java.util.Scanner;

public class MathFunc implements MathCalculable{
    public MathFunc(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    int n1, n2, n3, n4;
    @Override
    public int stepen() {
        return (int) Math.pow(n1,n2);
    }

    @Override
    public double modul() {
        return Math.sqrt(n3 * n3 + n4 * n4);
    }

    public static void main(String[] args){
        System.out.println("Введите число и степень");
        Scanner scanner = new Scanner(System.in);
        int n1, n2, n3, n4;
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        System.out.println("Введите комплексное число");
        n3 = scanner.nextInt();
        n4 = scanner.nextInt();
        MathCalculable func = new MathFunc(n1,n2,n3,n4);
        System.out.println(func.stepen());
        System.out.println(func.modul());
        System.out.println(func.pi);
    }
}
