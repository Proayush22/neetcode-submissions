class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
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
