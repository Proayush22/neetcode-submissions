class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        //point to actual last index so that <= works properly
        while(l <= r){

            //need to do l + cuz otherwise it will give numbers outside the bound
            int compare = nums[l + (r - l) / 2];
            int index = l + (r - l) / 2;

            if(compare > target){
                r = index - 1;
            }
            else if(compare < target){
                l = index + 1;
            }
            else if(compare == target){
                return index;
            }
        }
        return -1;
    }
}
