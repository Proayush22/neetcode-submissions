class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int area = 0;
        for(int i = 0; i < heights.length; i++){
            for(int j = heights.length - 1; j > i; j--){
                if(heights[j] > heights[i])
                    area = (j - i) * heights[i];
                else
                    area = (j - i) * heights[j];
                
                if(area > max)
                    max = area;
            }
        }
        return max;
    }
}

