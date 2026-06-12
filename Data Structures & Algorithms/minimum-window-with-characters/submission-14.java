class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        String leastStr = "";
        int len = s.length();

        for(int i = 0; i < t.length(); i++){
            if(!map1.containsKey(t.charAt(i))){
                map1.put(t.charAt(i), 1);
            }
            else{
                map1.put(t.charAt(i), map1.get(t.charAt(i)) + 1);
            }
        }

        int have = 0;
        int need = map1.size();
        int l = 0;
        int r = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            if(map1.containsKey(c)){
                if(map2.containsKey(c)){
                    map2.put(c, map2.get(c) + 1);
                }
                else{
                    map2.put(c, 1);
                }
                if(map2.get(c) >= map1.get(c) && (map2.get(c) - 1) < map1.get(c)){
                    have++;
                }
            }
            while(have == need){
                if(map1.containsKey(s.charAt(l))){
                    if(map2.get(s.charAt(l)) - 1 < map1.get(s.charAt(l))){
                        have--;
                        if((r - l) < len){
                            leastStr = s.substring(l, r + 1);
                            len = r - l;
                        }
                    }
                    map2.put(s.charAt(l), map2.get(s.charAt(l)) - 1);

                }
                l++;
            }

            r++;
        }
        return leastStr;
    }
}
