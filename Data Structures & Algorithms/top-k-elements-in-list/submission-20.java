class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // getOrDefault replaces the if/else containsKey logic
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /*
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        */
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        /*
        Iterator<Map.Entry<Integer, Integer>> i = map.entryset.iterator();
        while(i.hasNext){
            Map.Entry<Integer, Integer> e = i.getNext();
            if(e.getNext)
        }
        */
        map.forEach((key, value) -> {
            if(buckets[value] == null) buckets[value] = new ArrayList<>();
            buckets[value].add(key);
        });
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = nums.length; i > 0 && result.size() < k; i--){
            if(buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();

    }
}
