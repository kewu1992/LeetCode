import java.util.*;

public class Solution {
    public void solveSudoku(char[][] board) {
        boolean isExistetRow[][] = new boolean[9][9];
        boolean isExistetColumn[][] = new boolean[9][9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.'){
                    int index = board[i][j] - '1';
                    isExistetRow[i][index] = true;
                    isExistetColumn[j][index] = true;
                }
        search(board, 0, 0, isExistetRow, isExistetColumn);

    }

    private boolean search(char[][] board, int row, int column, boolean[][] isExistedRow, boolean[][] isExistedColumn){
        if (row == 9)
            return true;
        boolean success = false;
        
        if (board[row][column] != '.'){
            if ((row + 1) % 3 == 0 && (column + 1) % 3 == 0) {
                boolean[] isExisted = new boolean[9];
                boolean flag = true;
                for (int j = row - 2; j <= row && flag; j++)
                    for (int k = column - 2; k <= column; k++) {
                        int index = board[j][k] - '1';
                        if (isExisted[index]) {
                            flag = false;
                            break;
                        } else
                            isExisted[index] = true;
                    }
                if (flag) {
                    if (column == 8)
                        success = search(board, row + 1, 0, isExistedRow, isExistedColumn);
                    else
                        success = search(board, row, column + 1, isExistedRow, isExistedColumn);
                }
            } else {
                if (column == 8)
                    success = search(board, row + 1, 0, isExistedRow, isExistedColumn);
                else
                    success = search(board, row, column + 1, isExistedRow, isExistedColumn);
            }
        } else {
            for (int i = 0; i < 9; i++) {
                if (!isExistedRow[row][i] && !isExistedColumn[column][i]) {
                    board[row][column] = (char) (i + '1');
                    isExistedRow[row][i] = true;
                    isExistedColumn[column][i] = true;
                    if ((row + 1) % 3 == 0 && (column + 1) % 3 == 0) {
                        boolean[] isExisted = new boolean[9];
                        boolean flag = true;
                        for (int j = row - 2; j <= row && flag; j++)
                            for (int k = column - 2; k <= column; k++) {
                                int index = board[j][k] - '1';
                                if (isExisted[index]) {
                                    flag = false;
                                    break;
                                } else
                                    isExisted[index] = true;
                            }
                        if (flag) {
                            if (column == 8)
                                success = search(board, row + 1, 0, isExistedRow, isExistedColumn);
                            else
                                success = search(board, row, column + 1, isExistedRow, isExistedColumn);
                        }
                    } else {
                        if (column == 8)
                            success = search(board, row + 1, 0, isExistedRow, isExistedColumn);
                        else
                            success = search(board, row, column + 1, isExistedRow, isExistedColumn);
                    }
                    if (success)
                        break;
                    else {
                        isExistedRow[row][i] = false;
                        isExistedColumn[column][i] = false;
                        board[row][column] = '.';
                    }
                }
            }    
        }
        return success;
    }
}
