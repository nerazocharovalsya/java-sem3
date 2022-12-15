package task2;

public interface Queue {

    // Предусловие: value != null
    // Постусловие: queue[size - 1] = element
    // Постусловие: size++
    void enqueue(Object element);

    // Предусловие: size > 0
    // Постусловие: Result = queue[0]
    Object element();

    // Предусловие: size > 0
    // Постусловие: Result = queue[0]
    // Постусловие: size--
    Object dequeue();

    // Постусловие: Result = size
    int size();

    // Постусловие: Result = size > 0?
    boolean isEmpty();

    // Инвариант: size = 0;
    // Постусловие: Пустая очередь
    void clear();

    // Постусловие: Result = queue[0...size - 1]
    Object[] toArray();
}
