class Solution {
    public int search(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;

        //when trying to narrow down to a single number and check it you have to have <=
        while(l <= r){
            int m = l + (r - l) / 2;

            if(nums[m] == target){
                return m;
            }

            if(nums[m] >= nums[l]){
                //when mid is greater than left, the left side is perfectly sorted

                //compare if target in left, otherwise search right
                if(nums[l] <= target && target <= nums[m]){
                    r = m - 1;
                }
                else{
                    l = m + 1;
                }
            }
            else {
                //mid is smaller than left, right is perfectly sorted

                //target num between the sorted numbers on right
                if(target >= nums[m] && target <= nums[r]){
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }

        }
        return -1;
    }
}