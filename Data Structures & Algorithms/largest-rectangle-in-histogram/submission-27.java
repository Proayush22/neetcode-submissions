class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> height = new Stack<>();
            Stack<Integer> index = new Stack<>();
            int maxArea = 0;

            for(int i = 0; i < heights.length; i++){
                int start = i;
                while(!height.empty() && height.peek() > heights[i]){
                    int poph = height.pop();
                    int popi = index.pop();
                    if(poph * (i - popi) > maxArea){
                        maxArea = poph * (i - popi);
                    }
                    start = popi;
                }
                height.push(heights[i]);
                index.push(start);

            }            


            while(!height.empty()){
                int poph = height.pop();
                int popi = index.pop();
                if(poph * (heights.length - popi) > maxArea){
                    maxArea = poph * (heights.length - popi);
                }

            }
            return maxArea;

        }
}

