class Solution {
    public int findDuplicate(int[] nums) {
        //tortoise and hare algorithm, useful for cycles

        //the index numbers create a cycle so we go through with slow and fast algorithm
        //first step of flloyds is always fast and small pointer intersecting
        int fast = 0;
        int slow = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        //for this problem we need to put the fast pointer back at the start and increment by 1
        //this is part of the proof, the number it meets at is the duplicate
        fast = 0;
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}