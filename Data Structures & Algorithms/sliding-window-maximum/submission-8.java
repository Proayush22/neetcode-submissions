class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = 0;

        while(r < nums.length){
            //expand window first then shrink

            //if the last element is smaller than element at r and 
            //deque is not empty then remove it and add the new element
            //at r bc its guaranteed to be bigger
            while(!deque.isEmpty() && deque.peekLast() < nums[r]){
                deque.pollLast();
            }
                
            deque.offerLast(nums[r]);
            r++;

            if(r - l > k){
                // Auto-unboxing handles comparing the Integer object to the int primitive safely
                if(deque.getFirst() == nums[l]){
                    deque.pollFirst();
                }
                l++;
            }

            if(r - l == k)
                list.add(deque.getFirst());
        }

        int[] n = new int[list.size()];
        for(int i = 0; i < n.length; i++){
            n[i] = list.get(i);
        }
        return n;
    }
}
