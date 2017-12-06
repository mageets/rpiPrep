public class BasicStack {
    private int[] data;
    private int size;

    public BasicStack(){
        data = new int[100];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int i) {
        data[size] = i;
        size++;
    }

    public int pop() {
        return data[--size];
    }
}
