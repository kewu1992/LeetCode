public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];
        ans[0][0] = 1;
        for (int i = 1; i < m; i++)
            if (obstacleGrid[i-1][0] == 0 && obstacleGrid[i][0] == 0)
                ans[i][0] = ans[i-1][0];
        for (int i = 1; i < n; i++)
            if (obstacleGrid[0][i-1] == 0 && obstacleGrid[0][i] == 0)
                ans[0][i] = ans[0][i-1];
            
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (obstacleGrid[i][j] == 0){
                    if (obstacleGrid[i-1][j] == 0)
                        ans[i][j] += ans[i-1][j];
                    if (obstacleGrid[i][j-1] == 0)
                        ans[i][j] += ans[i][j-1];
                }
        return ans[m-1][n-1];
    }
}
