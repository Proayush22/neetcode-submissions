class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        String numbers = "";
        for(int i = 0; i < nums.length; i++){
            numbers += (nums[i].toString() + " ");
        }
        */

        HashMap<Integer, Integer> numbs = new HashMap<>();
        int[] indexes = new int[2];
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            /*
            if(numbers.contains(diff.toString())){
                return 
            }
            */
            if(numbs.containsKey(diff)){
                indexes[0] = numbs.get(diff);
                indexes[1] = i;
                return indexes;
            }
            numbs.put(nums[i], i);

        }
        return null;
    }
}
