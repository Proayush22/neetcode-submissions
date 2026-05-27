class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int area = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            if(heights[r] > heights[l]){
                area = (r - l) * heights[l];
                l++;
            }
            else{
                area = (r - l) * heights[r];
                r--;
            }
                
            if(area > max)
                max = area;
        }
        
        return max;
    }
}

