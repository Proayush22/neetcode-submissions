class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        if(val < min){
            min = val;
        }
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if(minStack.empty()){
            min = Integer.MAX_VALUE;
        }
        else{
            min = minStack.peek();
        }
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
