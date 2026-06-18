class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int x = 0;
        for(int i = 0; i < tokens.length; i++){
            
            if(tokens[i].equals("+")){
                x = stack.pop() + stack.pop();
                stack.push(x);

            } else if(tokens[i].equals("-")){
                int y = stack.pop();
                x = stack.pop() - y;
                stack.push(x);

            } else if(tokens[i].equals("*")){
                x = stack.pop() * stack.pop();
                stack.push(x);

            } else if(tokens[i].equals("/")){
                int y = stack.pop();
                x = stack.pop() / y;
                stack.push(x);

            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            System.out.println(stack);
        }
        return stack.pop();
    }
}
