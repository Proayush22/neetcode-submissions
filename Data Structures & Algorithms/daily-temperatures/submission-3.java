class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> position = new Stack<>();
        int var = 0;
        int p = 0;

        for(int i = 0; i < temperatures.length; i++){
            var = temperatures[i];
            while(!stack.empty() && var > stack.peek()){
                p = position.pop();
                res[p] = i - p;
                stack.pop();
            }
            stack.push(var);
            position.push(i);
        }
        
        while(!stack.empty()){
            var = stack.pop();
            p = position.pop();
            res[p] = 0;
        }
        return res;
    }
}
