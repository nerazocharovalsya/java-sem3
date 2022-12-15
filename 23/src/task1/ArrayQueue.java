package task1;

// один
//экземпляр очереди с использованием переменных класса
public class ArrayQueue {
    private final int START_CAPACITY = 10; // начальная емкость
    private Object array[]; // массив
    private int size; // размер
    private int head; // начало
    private int tail; // конец

    public ArrayQueue() {
        array = new Object[START_CAPACITY];
        size = head = tail = 0;
    }


    // Предусловие: capacity > 0
    // Постусловие: если необходимая capacity больше чем текущая
    // Постусловие: удваиваем capacity
    // Инвариант: если head < tail (удваиваем capacity)
    private void ensureCapacity(int capacity) {
        if (capacity >= array.length) {
            Object[] temp = new Object[array.length << 1];
            int count = tail < head ? array.length - head : size;
            System.arraycopy(array, head, temp, 0, count);
            if (tail < head)
                System.arraycopy(array, 0, temp, count, tail);
            array = temp;
            head = 0;
            tail = size;
        }
    }

    // Предусловие: value != null
    // Постусловие: queue[size - 1] = element
    // Постусловие: size++
    public void enqueue(Object element) { // добавить элемент в массив
        if (element != null) {
            ensureCapacity(size + 1);
            array[tail] = element;
            tail = (tail + 1) % array.length;
            size++;
        }
    }

    // Предусловие: size > 0
    // Постусловие: Result = queue[0]
    public Object element() { // первый элемент в очереди
        if (size > 0) {
            return array[head];
        }
        return -999999999;
    }

    // Предусловие: size > 0
    // Постусловие: Result = queue[0]
    // Постусловие: size--
    public Object dequeue() { // удалить и вернуть первый элемент в очереди
        if(size > 0) {
            Object result = element();
            array[head] = null;
            size--;
            head = (head + 1) % array.length;
            return result;
        }
        return null;
    }

    // Постусловие: Result = size
    public int size() { // текущий размер очереди
        return size;
    }

    // Постусловие: Result = size > 0?
    public boolean isEmpty() { // является ли очередь пустой
        return size == 0;
    }

    // Инвариант: size = 0;
    // Постусловие: Пустая очередь
    public void clear() {
        size = head = tail = 0;
        array = new Object[START_CAPACITY];
    }

    // Постусловие: Result = queue[0...size - 1]
    public Object[] toArray() {
        Object[] temp = new Object[size];
        int count = tail < head ? array.length - head : size;
        System.arraycopy(array, head, temp, 0, count);
        if (tail < head)
            System.arraycopy(array, 0, temp, count, tail);
        return temp;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " " + queue.dequeue());
        }
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.clear();
        System.out.println("Очередь пустая: " + queue.isEmpty());
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Object[] arr = queue.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
