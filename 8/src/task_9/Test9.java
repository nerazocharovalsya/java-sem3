package task_9;

import java.util.Scanner;

public class Test9 {
    static int func9(int a, int b){
        if(a == 0){ //все единицы
            return 1;
        }
        if(a == 1){ //один ноль, остальные единицы
            return b + 1;
        }
        if(a > 1 && b == 0){ //больше одного нуля и нет единиц
            return 0;
        }
        // заканчивается на ...10 или ...1
        return func9(a,b - 1) + func9(a - 1,b - 1);
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(func9(a,b));
    }
}
