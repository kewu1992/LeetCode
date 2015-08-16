public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int startRow = 0;
        int endRow = n;
        int startColumn = 0;
        int endColumn = n;
        int direction = 0;  // 0 for left, 1 for down, 2 for right, 3 for up
        int count = 0;
        int nowR = 0, nowC = 0;
        while (count < n*n){
            matrix[nowR][nowC] = count + 1;
            count++;
            if (direction == 0){
                if (nowC < endColumn - 1)
                    nowC++;
                else{
                    direction = direction + 1;
                    nowR++;
                    startRow++;
                }
            } else if (direction == 1){
                if (nowR < endRow - 1)
                    nowR++;
                else {
                    direction = direction + 1;
                    nowC--;
                    endColumn--;
                }
            } else if (direction == 2){
                if (nowC > startColumn)
                    nowC--;
                else {
                    direction = direction + 1;
                    nowR--;
                    endRow--;
                }
            } else {
                if (nowR > startRow)
                    nowR--;
                else {
                    direction = 0;
                    nowC++;
                    startColumn++;
                }
            }
        }
        return matrix;
    }
}
