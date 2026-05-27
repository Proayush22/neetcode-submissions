class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            if(heights[r] > heights[l]){
                if(((r - l) * heights[l]) > area)
                    area = (r - l) * heights[l];
                l++;
            }
            else{
                if(((r - l) * heights[r]) > area)
                    area = (r - l) * heights[r];
                r--;
            }

        }
        
        return area;
    }
}

