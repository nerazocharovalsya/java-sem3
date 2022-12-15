package task2;

public class LinkedQueue extends AbstractQueue {
    private Node tail;
    private Node head;

    protected void enqueueRealisation(Object element) {
        tail = new Node(element, null, tail);
        if (head == null)
            head = tail;
        else
            tail.next.prev = tail;
    }

    protected Object elementRealisation() {
        return head.value;
    }

    protected void dequeueRealisation() {
        if (head.prev != null) head.prev.next = null;
        head = head.prev;

    }

    private class Node {
        Object value;
        Node prev;
        Node next;

        Node(Object element, Node prev, Node next) {
            value = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        AbstractQueue queue = new LinkedQueue();
        queue.enqueue(5);
        queue.clear();
        queue.enqueue(3);
        queue.enqueue(9);
        System.out.println(queue.dequeue());
        System.out.println(queue.element());
    }
}