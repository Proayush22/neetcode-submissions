class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int mrow = 0;

        while(left < right){
            mrow = left + (right - left) / 2;
            if(target < matrix[mrow][0]){
                right = mrow - 1;
            } else if(target > matrix[mrow][matrix[mrow].length - 1]){
                left = mrow + 1;
            }
            else {
                left = mrow;
                right = mrow;
            }
        }
        
        mrow = left;
        left = 0;
        right = matrix[mrow].length - 1;
        System.out.println(mrow);
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target < matrix[mrow][mid]){
                right = mid - 1;

            } else if (target > matrix[mrow][mid]) {
                left = mid + 1;

            } else if (target == matrix[mrow][mid]) {
                return true;

            }
        }
        return false;


    }
}
