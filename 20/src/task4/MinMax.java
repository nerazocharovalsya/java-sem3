package task4;

import java.util.Arrays;
import java.util.Random;

public class MinMax<T extends Comparable<T>> {
    private T[] arr;

    public MinMax(T[] arr) {
        this.arr = arr;
    }

    public T getMinElement() {
        if (arr.length > 0) {
            T min = arr[0];
            for (T t : arr) {
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
            return min;
        }
        return null;
    }

    public T getMaxElement() {
        if (arr.length > 0) {
            T max = arr[0];
            for (T t : arr) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
            return max;
        }
        return null;
    }

    @Override
    public String toString() {
        return "MinMax<" + arr.getClass().getSimpleName() + ">{" + Arrays.toString(arr) + '}';
    }

    public static void main(String[] args) {
        MinMax<Character> aChar = new MinMax<>(new Character[]{'c', 'h', 'w', 'o'});
        printMinMaxInfo(aChar);
        System.out.println();

        MinMax<Integer> aInt = new MinMax<>(new Integer[]{
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100),
                new Random().nextInt(100)
        });
        printMinMaxInfo(aInt);
        System.out.println();

        MinMax<Double> aDouble = new MinMax<>(new Double[]{68.54, 71.75, 19.21, 7.88});
        printMinMaxInfo(aDouble);
    }

    public static void printMinMaxInfo(MinMax<?> arr) {
        System.out.println(arr);
        System.out.println("Минимальный элемент - \'" + arr.getMinElement() + '\'');
        System.out.println("Максимальный элемент - \'" + arr.getMaxElement() + '\'');
    }
}
