package task_1;

public class StringTest {
    String s;
    //Напишите метод, который принимает в качестве параметра любую
    //строку, например “I like Java!!!”
    public void func1(){

    }
    //Распечатать последний символ строки. Используем метод String.charAt()
    public void func2(){
        System.out.println(s.charAt(s.length()-1));
    }
    //Проверить, заканчивается ли ваша строка подстрокой “!!!”.
    //Используем метод String.endsWith()
    public boolean func3(){
        return s.endsWith("!!!");
    }
    //Проверить, начинается ли ваша строка подстрокой “I like”.
    //Используем метод String.startsWith()
    public boolean func4(){
        return s.startsWith("I like");
    }
    //Проверить, содержит ли ваша строка подстроку “Java”. Используем
    //метод String.contains()
    public boolean func5(){
        return s.contains("Java");
    }
    //Найти позицию подстроки “Java” в строке “I like Java!!!”
    public int func6(){
        return s.indexOf("Java");
    }
    //Заменить все символы “а” на “о”
    public String func7(){
        return s.replace("a","o");
    }
    //Преобразуйте строку к верхнему регистру
    public String func8(){
        return s.toUpperCase();
    }
    //Преобразуйте строку к нижнему регистру
    public String func9(){
        return s.toLowerCase();
    }
    //Вырезать строку Java c помощью метода String.substring()
    public String func10(){
        return s.substring(s.indexOf("Java"), s.indexOf("Java") + 4);
    }

    public static void main(String[] args){
        StringTest stringTest = new StringTest();
        stringTest.s = "I like Java!!!";
        stringTest.func2();
        System.out.println(stringTest.func3());
        System.out.println(stringTest.func4());
        System.out.println(stringTest.func5());
        System.out.println(stringTest.func6());
        System.out.println(stringTest.func7());
        System.out.println(stringTest.func8());
        System.out.println(stringTest.func9());
        System.out.println(stringTest.func10());
    }
}
