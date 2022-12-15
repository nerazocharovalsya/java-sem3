package task3;

public class Task3<T extends String, V extends Animal, K extends Number>{
    private T t;
    private V v;
    private K k;

    public Task3(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public void show(){
        System.out.println("Объект типа T: " + t.getClass().getName() + "   Значение: " + t);
        System.out.println("Объект типа V: " + v.getClass().getName() + "   Значение: " + v.getName());
        System.out.println("Объект типа K: " + k.getClass().getName() + "   Значение: " + k);
    }

    public static void main(String[] args){
        Task3<String, Cat, Integer> task3 = new Task3<>("Java",new Cat("August"), 345);
        task3.show();
        System.out.println();
        System.out.println(task3.t.compareTo("Java"));
    }
}
