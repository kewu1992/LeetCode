public class Solution {
    private class Element{
        int x, y;
        Element(int i, int j){
            x = i;
            y = j;
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0)
            return;
        int n = board[0].length;
        if (n == 0)
            return;
        boolean[][] hasVisited = new boolean[m][n];
        Queue<Element> queue = new LinkedList();
        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O') {
                queue.add(new Element(i, 0));
                hasVisited[i][0] = true;
            }
            if (board[i][n-1] == 'O') {
                queue.add(new Element(i, n-1));
                hasVisited[i][n-1] = true;
            }
        }
        
        for (int i = 0; i < n; i++){
            if (board[0][i] == 'O'){
                queue.add(new Element(0, i));
                hasVisited[0][i] = true;
            }
            if (board[m-1][i] == 'O'){
                queue.add(new Element(m-1, i));
                hasVisited[m-1][i] = true;
            }
        }
                
        while (!queue.isEmpty()){
            Element temp = queue.remove();
            int i = temp.x;
            int j = temp.y;
            hasVisited[i][j] = true;
            if (i > 0 && board[i-1][j] == 'O' && !hasVisited[i-1][j]) {
                queue.add(new Element(i-1, j));
                hasVisited[i-1][j] = true;
            }
            if (i+1 < m && board[i+1][j] == 'O' && !hasVisited[i+1][j]){
                queue.add(new Element(i+1, j));
                hasVisited[i+1][j] = true;
            }  
            if (j > 0 && board[i][j-1] == 'O' && !hasVisited[i][j-1]) {
                queue.add(new Element(i, j-1));
                hasVisited[i][j-1] = true;
            }
            if (j+1 < n && board[i][j+1] == 'O' && !hasVisited[i][j+1]) {
                queue.add(new Element(i, j+1));
                hasVisited[i][j+1] = true;
            }
        }
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!hasVisited[i][j])
                    board[i][j] = 'X';
    }
    
}
