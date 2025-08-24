class MyCircularDeque {

    private final int capacity;
    private final Deque<Integer> dq;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.dq = new ArrayDeque<>();
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        dq.addFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        dq.addLast(value);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        dq.pollFirst();
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        dq.pollLast();
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return dq.peekFirst();
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return dq.peekLast();
    }

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return dq.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */