public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] isExisted = new boolean[9];
        for (int row = 0; row < 9; row++){
            clear(isExisted);
            for (int column = 0; column < 9; column++)
                if (board[row][column] != '.'){
                    int index = board[row][column] - '1';
                    if (isExisted[index])
                        return false;
                    else
                        isExisted[index] = true;
                }
        }
        
        for (int column = 0; column < 9; column++){
            clear(isExisted);
            for (int row = 0; row < 9; row++)
                if (board[row][column] != '.'){
                    int index = board[row][column] - '1';
                    if (isExisted[index])
                        return false;
                    else
                        isExisted[index] = true;
                }
        }
        
        for (int row = 0; row < 9; row +=3)
            for (int column = 0; column < 9; column += 3)
                if (!checkSubSquare(board, row, column))
                    return false;
        return true;
    }
    
    private void clear(boolean[] array){
        for (int i = 0; i < array.length; i++)
            array[i] = false;
    }
    
    private boolean checkSubSquare(char[][] board, int startRow, int startColumn){
        boolean[] isExisted = new boolean[9];
        for (int i = startRow; i < startRow+3; i++)
            for (int j = startColumn; j < startColumn+3; j++)
                if (board[i][j] != '.'){
                    int index = board[i][j] - '1';
                    if (isExisted[index])
                        return false;
                    else
                        isExisted[index] = true;
                }
        return true;
    }  
}
