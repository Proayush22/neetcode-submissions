class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pt1 = 0;
        int pt2 = numbers.length - 1;

        while(pt1 < pt2) {
            if(numbers[pt2] + numbers[pt1] > target){
                pt2--;
            }
            if(numbers[pt2] + numbers[pt1] < target){
                pt1++;
            }
            if(numbers[pt2] + numbers[pt1] == target){
                return new int[] {pt1 + 1, pt2 + 1};
            }
        }
        return new int[]{};
    }
}
