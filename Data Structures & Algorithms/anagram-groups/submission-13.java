class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> anagrams = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            ArrayList<Integer> c = new ArrayList<>(Collections.nCopies(26, 0));
            for(int j = 0; j < strs[i].length(); j++){
                int ascii = (strs[i].charAt(j)) - 97;
                c.set(ascii, c.get(ascii) + 1);
            }
            if(anagrams.containsKey(c)){
                anagrams.get(c).add(strs[i]);
            }
            else{
                ArrayList list = new ArrayList<>();
                list.add(strs[i]);
                anagrams.put(c, list);
            }
        }
        return new ArrayList<>(anagrams.values());
    }
}
