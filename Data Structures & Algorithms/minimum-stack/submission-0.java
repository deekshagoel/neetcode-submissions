class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack();
        minstack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.empty() || val <= minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        int top = stack.peek();
        if(top == minstack.peek()){
            minstack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
