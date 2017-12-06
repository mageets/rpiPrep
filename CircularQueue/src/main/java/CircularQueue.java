import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private T[] data;
    private int front, back;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 5;

    public CircularQueue() {
        capacity = DEFAULT_CAPACITY;
        data = (T[])new Object[capacity];
        front = 0;
        back = 0;
    }

    public CircularQueue(int initialCapacity) {
        data = (T[])new Object[initialCapacity];
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return front == back;
    }

    public void enqueue(T item) {
        data[back] = item;
        back = (back + 1) % capacity;
    }

    public T dequeue() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        T itemToRemove = data[front];
        front = (front + 1) % capacity;
        return itemToRemove;
    }

    public T peek() {
        return data[front];
    }
}
