class Solution {
    public int trap(int[] height) {
        int area = 0;
        int l = 0;
        int r = height.length - 1;

        int max = 0;
        int[] maxl = new int[height.length];
        int[] maxr = new int[height.length];
        for(int i = height.length - 1; i >= 0; i--){
            if(height[i] > max){
                max = height[i];
            }
            maxl[i] = max;

        }
        max = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > max){
                max = height[i];
            }
            maxr[i] = max;

        }
        for(int i = 1; i < height.length - 1; i++){
            if(Math.min(maxl[i], maxr[i]) - height[i] > 0){
                area += Math.min(maxl[i], maxr[i]) - height[i];
            }
        }
        /*
        if(height.length == 2 || )
            return 0;
        for(int i = 1; i < height.length - 1; i++){
            // solve using a formaula min(l (max of all left),  (max of all right)) - h[i] which gives you the amount of water at each block for any block on the graph
            if(height[i - 1] > height[l]){
                height[]
            }
            //if the formula gives a negative number then its not a water block
            System.out.println(Math.min(l , r) - height[i]);
            if(Math.min(l, r) - height[i] < 0){
                area += -(Math.min(l, r) - height[i]);
            }
        }
        */
        return area;
    }
}
