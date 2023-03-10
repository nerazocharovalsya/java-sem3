package task1;

//  очередь в виде
//абстрактного типа данных (с явной передачей ссылки на
//экземпляр очереди)
public class ArrayQueueADT {
    private static final int START_CAPACITY = 10;
    private Object array[];
    private int size;
    private int head;
    private int tail;

    public ArrayQueueADT() {
        array = new Object[START_CAPACITY];
        size = head = tail = 0;
    }

    private static void ensureCapacity(ArrayQueueADT adt, int capacity) {
        if (capacity >= adt.array.length) {
            Object[] temp = new Object[adt.array.length << 1];
            int count = adt.tail < adt.head ? adt.array.length - adt.head : adt.size;
            System.arraycopy(adt.array, adt.head, temp, 0, count);
            if (adt.tail < adt.head)
                System.arraycopy(adt.array, 0, temp, count, adt.tail);
            adt.array = temp;
            adt.head = 0;
            adt.tail = adt.size;
        }
    }

    public static void enqueue(ArrayQueueADT adt, Object element) {
        assert element != null;
        ensureCapacity(adt, adt.size + 1);
        adt.array[adt.tail] = element;
        adt.tail = (adt.tail + 1) % adt.array.length;
        adt.size++;
    }

    public static Object element(ArrayQueueADT adt) {
        assert adt.size > 0;
        return adt.array[adt.head];
    }

    public static Object dequeue(ArrayQueueADT adt) {
        assert adt.size > 0;
        Object result = element(adt);
        adt.array[adt.head] = null;
        adt.size--;
        adt.head = (adt.head + 1) % adt.array.length;
        return result;
    }

    public static int size(ArrayQueueADT adt) {
        return adt.size;
    }

    public static boolean isEmpty(ArrayQueueADT adt) {
        return adt.size == 0;
    }

    public static void clear(ArrayQueueADT adt) {
        adt.size = adt.head = adt.tail = 0;
        adt.array = new Object[START_CAPACITY];
    }

    public static Object[] toArray(ArrayQueueADT adt) {
        Object[] temp = new Object[adt.size];
        int count = adt.tail < adt.head ? adt.array.length - adt.head : adt.size;
        System.arraycopy(adt.array, adt.head, temp, 0, count);
        if (adt.tail < adt.head)
            System.arraycopy(adt.array, 0, temp, count, adt.tail);
        return temp;
    }

    public static void main(String[] args) {
        ArrayQueueADT queue = new ArrayQueueADT();
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        while (!ArrayQueueADT.isEmpty(queue)) {
            System.out.println(ArrayQueueADT.size(queue) + " " + ArrayQueueADT.dequeue(queue));
        }
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        ArrayQueueADT.clear(queue);
        System.out.println("Очередь пустая: " + ArrayQueueADT.isEmpty(queue));
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue,i);
        }
        Object[] arr = ArrayQueueADT.toArray(queue);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
