package task_6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Class6 {
    public static boolean checkEmail(String s){
        Matcher m = Pattern.compile(
                "[a-zA-Z0-9]+[a-zA-Z0-9!#$%&'*+\\-/=?^_`{|}~.]*@[a-zA-Z0-9\\-_.]+\\.[a-zA-Z]+"
        ).matcher(s);
        return m.find() && m.group().equals(s);
    }
    public static void main(String[] args){
        System.out.println(checkEmail("dlknf@gmail.com"));
        System.out.println(checkEmail(".lkfd fdklk@gmail.com"));
        System.out.println(checkEmail("lkdfklnfd@gmail"));
        System.out.println(checkEmail("ldkpwppw@g@mail.ru"));
    }
}
