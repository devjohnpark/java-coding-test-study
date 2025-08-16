// 225. Implement Stack using Queues(큐를 이용한 스택 구현)

class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
    }
    
    public void push(int x) {
        if(queue.isEmpty()) {
            queue.offer(x);
        } else {
            int cnt = 1;

            queue.offer(x);

            while(queue.size() != cnt) {
                queue.offer(queue.poll());
                cnt++;
            }
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
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