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
                    //because you come to this when you need to add a smaller number
                    //the number you are popping is where the area for the smaller number truly starts 
                    //so the amount of numbers you pop is where the start will end up and put that index
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

