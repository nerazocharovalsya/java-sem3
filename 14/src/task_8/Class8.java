package task_8;

import java.util.Arrays;
import java.util.function.Function;

public class Class8 {
    public static <T> T[] filter(T[] array, Function<? super T, Boolean> filter) {
        int offset = 0;

        for (int i = 0; i < array.length; i++) {
            if (!filter.apply(array[i])) {
                offset++;
            } else {
                array[i - offset] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length - offset);
    }


    public static void main(String[] args) {
        String array[] =
                new String[]{"1rewf ", "feefewf", "a", null, "1"};

        String[] newArray = filter(array, s -> s != null);
        for (int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }
    }
}
