package task5_6;

public class ProcessStrings implements StringFunc{
    String s;
    @Override
    public int StrSize() {
        return s.length();
    }

    @Override
    public String StrUneven() {
        String ss = "";
        for(int i = 1; i < s.length(); i+=2){
            ss += s.charAt(i);
        }
        return ss;
    }

    @Override
    public String StrReverse() {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args){
        ProcessStrings strings = new ProcessStrings();
        strings.s = "abcdefg";
        System.out.println(strings.StrSize());
        System.out.println(strings.StrUneven());
        System.out.println(strings.StrReverse());
    }
}
