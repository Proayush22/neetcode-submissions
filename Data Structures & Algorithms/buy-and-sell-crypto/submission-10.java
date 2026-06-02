class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int max = 0;
        while(r < prices.length){
            if(prices[r] - prices[l] > max){
                max = prices[r] - prices[l];
            }
            if(prices[r] - prices[l] <= 0){
                r++;
                l = r - 1;
            }
            else if(prices[r] - prices[l] > 0){
                r++;
            }
        }
        return max;
    }
}
