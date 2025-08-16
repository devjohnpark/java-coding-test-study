// 232. Implement Queue using Stacks(스택을 이용한 큐 구현)

class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public int accessFront(String operation) {
        int result = 0;

        while(!in.isEmpty()) {
            out.push(in.pop());
        }

        if(operation == "pop") {
            result = out.pop();
        } else {
            result = out.peek();
        }
        
        while(!out.isEmpty()) {
            in.push(out.pop());
        }

        return result;
    }

    public MyQueue() {
        
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        return accessFront("pop");
    }
    
    public int peek() {
        return accessFront("peek");
    }
    
    public boolean empty() {
        return in.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */