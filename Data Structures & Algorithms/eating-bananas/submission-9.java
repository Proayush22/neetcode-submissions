class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max)
                max = piles[i];
        }

        int r = max;
        int l = 1;
        //we are essentailly using this as the eating range from 0 to the length

        while(l < r){
            //mid is the eating rate
            int mid = l + (r - l) / 2;

            long hours = 0;
            for(int i = 0; i < piles.length; i++){
                if(piles[i] % mid == 0){
                    hours += piles[i] / mid;
                }
                else {
                    hours += (piles[i] / mid + 1); 
                }
            }
            //finished eating faster
            if(hours <= h){
                r = mid;
            }
            //slower
            else if(hours > h){
                l = mid + 1;
            }
        }
        return l;
    }
}
