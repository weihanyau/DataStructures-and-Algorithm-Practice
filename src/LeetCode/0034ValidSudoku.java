package LeetCode;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean ans = true;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    ans = checkRow(board, i, j) && checkColumn(board, i, j) && checkBox(board, i, j);
                    if(!ans){
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
    public boolean checkRow(char[][] board, int row, int column){
        for(int i = 0; i < 9; i++){
            if(i != column && board[row][i] == board[row][column]){
                System.out.println(1);
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(char[][] board, int row, int column){
        for(int i = 0; i < 9; i++){
            if(i != row && board[i][column] == board[row][column]){
                System.out.println(2);
                return false;
            }
        }
        return true;
    }

    public boolean checkBox(char[][] board, int row, int column){
        for(int i = row/3 * 3; i < row/3 * 3 + 3; i++){
            for(int j = column/3 * 3; j < column/3 * 3 + 3; j++){
                if(i != row && j != column && board[i][j] == board[row][column]){
                    System.out.println(3);
                    return false;
                }
            }
        }
        return true;
    }
}
