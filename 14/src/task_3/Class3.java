package task_3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Class3 {
    public static ArrayList<String> findRubEurUsd(String s){
        Pattern p  = Pattern.compile("\\d+(\\.\\d+)?\\s?((USD)|(EUR)|(RUB))");
        Matcher m = p.matcher(s);
        ArrayList<String> ans = new ArrayList<>();
        while (m.find()){
            ans.add(m.group());
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(findRubEurUsd("12.3 RUB, fejhge12 EUdsfrg3.789 USD, 25.98 USD, 44 ERR, 0.004 EU"));
    }
}
