class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 1;
        int r = 0; 
        int l = 0;
        int len = 0;
        char[] c = s.toCharArray();
        Set<Character> window = new HashSet<>();
        while(r < c.length){
            char curr = c[r];
            while(window.contains(curr)){
                window.remove(c[l]);
                l++;
            }
            
            window.add(c[r]);
            r++;
            if(window.size() > len){
                len = window.size();
            }

        }
        return len;
    }
}
