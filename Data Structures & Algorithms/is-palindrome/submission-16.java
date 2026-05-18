class Solution {
    public boolean isPalindrome(String s) {
        int ptr1 = 0;
        int ptr2 = s.length() - 1;

        while(ptr1 < ptr2){
            Character c1 = s.charAt(ptr1);
            Character c2 = s.charAt(ptr2);
            if(isAlphanumeric(c1) && isAlphanumeric(c2)){
                if(Character.toLowerCase(c1) == Character.toLowerCase(c2)){
                    ptr1++;
                    ptr2--;

                }
                else{
                    return false;
                }
            }
            else if(!isAlphanumeric(c1)){
                ptr1++;
            }
            else if(!isAlphanumeric(c2)){
                ptr2--;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(Character c){
        if(c == null){
            return false;
        }
        int n = (int)c;
        if((n >= 48 && n <= 57) || (n >= 65 && n <= 90) || (n >= 97 && n <= 122)){
            return true;
        }
        else{
            return false;
        }
    }
}
