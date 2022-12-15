package task_11;

import java.util.Scanner;

public class Test11 {
    static int func11(){
        Scanner in = new Scanner(System.in);
        int first, second, ones = 0;
        first = in.nextInt();
        if (first == 0){
            second = in.nextInt();
            if (second == 0)
                return 0;
            if(second == 1){
                ones = 1;
            }
            else{
                ones = 0;
            }
        }else
            if(first == 1){
               ones = 1;
            }
            else{
                ones = 0;
            }
        return ones + func11();
    }
    public static void main(String[] args){
        System.out.println(func11());
    }
}
