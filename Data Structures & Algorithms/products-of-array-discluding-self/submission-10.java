class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total_product = 1;
        int zero_product = 1;
        int zero_count = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(nums[i] != 0){
                total_product *= nums[i];
                zero_product *= nums[i];
                
            }
            else if(zero_count == 0){
                total_product = 0;
                zero_count++;
            }
            else{
                total_product = 0;
                zero_product = 0;
                zero_count++;
            }
        }
        
        int[] arr = new int[size]; 
        for(int j = 0; j < size; j++){
            if(zero_count == 1){
                if(nums[j] == 0)
                    arr[j] = zero_product;
                else
                    arr[j] = 0;
            }
            else if(zero_count >= 2){
                arr[j] = 0;
            }
            else{
                arr[j] = total_product / nums[j];
            }
        }
        return arr;

    }
}  
