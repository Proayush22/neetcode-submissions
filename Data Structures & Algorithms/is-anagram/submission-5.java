class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> svalues = new HashMap<>();
        HashMap<Character, Integer> tvalues = new HashMap<>();

        if(s.length() != t.length())
            return false;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char k = t.charAt(i);
            svalues.put(c, svalues.getOrDefault(c, 0) + 1);
            tvalues.put(k, tvalues.getOrDefault(k, 0) + 1);
        }

        if(svalues.equals(tvalues))
            return true;
        else
            return false;

    }
}

