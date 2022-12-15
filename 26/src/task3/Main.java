package task3;

public class Main {
    public static void main(String[] args) {
        var hash = new Hash();
        hash.add("Строка1");
        hash.add("Строка2");
        hash.add("Строка3");
        System.out.println(hash.find("Строка1"));
        hash.delete("Строка1");
        System.out.println(hash.find("Строка1"));
    }
}