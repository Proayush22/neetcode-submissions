class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char num = board[i][j];
                System.out.print(num);
                if(num != '.' && (!set.add(num + "row" + i) || !set.add(num + "col" + j) || !set.add(num + "cor" + i/3 + j/3)))
                    return false;
            }
        }
        return true;
    }
}
