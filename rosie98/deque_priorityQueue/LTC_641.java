class MyCircularDeque {
    Deque<Integer> deque;
    int capacity;

    public MyCircularDeque(int k) {
        deque = new LinkedList<>();
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        
        deque.offerFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        deque.offer(value);
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        deque.poll();
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        deque.pollLast();
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return deque.peek();
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return deque.peekLast();
    }
    
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    
    public boolean isFull() {
        return deque.size() == capacity;
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