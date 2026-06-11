class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            if(!map1.containsKey(s1.charAt(i))){
                map1.put(s1.charAt(i), 1);
            }
            else {
                map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
            }
        }

        Map<Character, Integer> map2 = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r < s2.length()){
            if(!map2.containsKey(s2.charAt(r))){
                map2.put(s2.charAt(r), 1);
            }
            else {
                map2.put(s2.charAt(r), map2.get(s2.charAt(r)) + 1);
            }
            System.out.println(map2);
            if((r - l + 1) > s1.length()){
                if(map2.get(s2.charAt(l)) == 1){
                    map2.remove(s2.charAt(l));
                }
                else{
                    map2.put(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
                }
                l++;
                System.out.println("move l: " + map2);
            }   
            if(map1.equals(map2)){
                return true; 
            }
            r++;          
        }
        return false;
    }
}
