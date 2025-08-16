class MyCircularQueue {

    private final int[] q;
    private final int cap;
    private int head;
    private int size;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.cap = k;
        this.head = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        int tail = (head + size) % cap;
        q[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % cap;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return q[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        int tail = (head + size - 1) % cap;
        return q[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */