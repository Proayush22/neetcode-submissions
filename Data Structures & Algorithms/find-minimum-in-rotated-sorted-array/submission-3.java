class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            //3,4,5,6,1,2
            //3,  5.   2
            //4,5,0,1,2,3
            //4.  0.    3
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }

            //5 6 1 2 3 4

            //4,5,6,7,8,9
            //mid has to either be the lowest number or it has to be to the left
            else if(nums[mid] < nums[right]){
                right = mid;                
            }
            
        }
        return nums[left];
    }
}
