class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        pq.stream().sorted().forEach(item -> System.out.print(item + " "));
        int last = Integer.MIN_VALUE;
        int curr = 0;
        int count = 1;
        int longest = 1;
        for(int i = 0; i < nums.length; i++){
            curr = pq.peek();
            System.out.print("\n" + last + " " + curr + " " + count);

            if(curr == last + 1){
                count++;
            }
            else if(curr != last){
                if(count > longest){
                    longest = count;
                }
                count = 1;
            }
            last = curr;
            pq.remove(curr);
        }
        if(count > longest){
            longest = count;
        }
        return longest;
    }
}
