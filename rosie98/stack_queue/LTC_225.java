import java.util.*;

class MyStack {

    // 1. Deque 사용
    // Deque<Integer> deque;

    // 2. 한 개의 Queue 사용
    Queue<Integer> q;

    public MyStack() {
        // deque = new LinkedList<>();

        q = new LinkedList<>();
    }
    
    public void push(int x) {
        // deque.offer(x);

        q.offer(x);
    }
    
    public int pop() {
        // return deque.pollLast();

        for(int i=0; i<q.size()-1; i++) {
            q.offer(q.poll());
        }

        int data = q.poll();

        return data;
    }
    
    public int top() {
        // return deque.getLast();

        for(int i=0; i<q.size()-1; i++) {
            q.offer(q.poll());
        }

        int data = q.poll();
        q.offer(data);

        return data;
    }
    
    public boolean empty() {
        // return deque.isEmpty();

        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */