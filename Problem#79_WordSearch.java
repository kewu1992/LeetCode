public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (word.charAt(0) == board[i][j]){
                    isVisited[i][j] = true;
                    if (search(board, word, 1, isVisited, i, j))
                        return true;
                    isVisited[i][j] = false;
                }
        return false;
    }
    
    private boolean search(char[][] board, String word, int now, boolean[][] isVisited, int row, int col){
        if (now == word.length())
            return true;
        if (row-1 >= 0 && board[row-1][col] == word.charAt(now) && !isVisited[row-1][col]){
            isVisited[row-1][col] = true;
            if (search(board, word, now+1, isVisited, row-1, col))
                return true;
            isVisited[row-1][col] = false;
        }
        if (row+1 < board.length && board[row+1][col] == word.charAt(now) && !isVisited[row+1][col]){
            isVisited[row+1][col] = true;
            if (search(board, word, now+1, isVisited, row+1, col))
                return true;
            isVisited[row+1][col] = false;
        }
        if (col-1 >= 0 && board[row][col-1] == word.charAt(now) && !isVisited[row][col-1]){
            isVisited[row][col-1] = true;
            if (search(board, word, now+1, isVisited, row, col-1))
                return true;
            isVisited[row][col-1] = false;
        }
        if (col+1 < board[0].length && board[row][col+1] == word.charAt(now) && !isVisited[row][col+1]){
            isVisited[row][col+1] = true;
            if (search(board, word, now+1, isVisited, row, col+1))
                return true;
            isVisited[row][col+1] = false;
        }
        return false;
    }
}
