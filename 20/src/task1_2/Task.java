package task1_2;

public class Task<T, V, K> {
    private T t;
    private V v;
    private K k;

    public Task(T t, V v, K k) {
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
        System.out.println("Объект типа V: " + v.getClass().getName() + "   Значение: " + v);
        System.out.println("Объект типа K: " + k.getClass().getName() + "   Значение: " + k);
    }

    public static void main(String[] args){
        Task<Integer, Boolean, String> task = new Task<>(20, true,"Java");
        task.show();
    }
}
