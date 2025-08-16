class MyCircularQueue {
    int[] arr;      
    int size;       
    int rear;
    int front;
    int count;      // arr에 삽입된 요소의 개수

    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);

        size = k;
        count = 0;
        rear = -1;
        front = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } 

        rear = (rear + 1) % size;
        arr[rear] = value;

        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } 
        
        arr[front] = -1;
        front = (front + 1) % size;
        count--;

        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } 

        return arr[rear];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return size == count;
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