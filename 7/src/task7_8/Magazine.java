package task7_8;

public class Magazine implements Printable{
    String name;
    Magazine(String name){
        this.name=name;
    }
    @Override
    public void print() {
        System.out.println(name);
    }
    public static void printMagazines(Printable[] printable){
        for (Printable p: printable) {
            if (p instanceof Magazine)
                p.print();
        }
    }
}
