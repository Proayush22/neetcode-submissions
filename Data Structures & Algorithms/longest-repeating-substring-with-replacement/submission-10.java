class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int l = 0;
        int r = 0;
        int len = 0;
        int max = 0;
        while(r < s.length()){
            if(map.containsKey(c[r])){
                map.put(c[r], map.get(c[r]) + 1);
                len++;
            }
            else{
                map.put(c[r], 1);
                len++;
            }
            while(len - Collections.max(map.values()) > k){
                map.put(c[l], map.get(c[l]) - 1);
                l++;
                len--;
            }
            if(len > max){
                max = len;
            }
            r++;
        }
        return max;
    }
}
