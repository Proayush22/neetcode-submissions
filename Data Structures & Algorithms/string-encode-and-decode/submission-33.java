class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            sb.append(strs.get(i) + "€");
        }
        
        return sb.toString();
        
    }

    public List<String> decode(String str) {
        //HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '€'){
                list.add(str.substring(i - count, i));
                count = 0;
                
            }
            else{
                count++;
            }
        }
        return list;
    }
}

