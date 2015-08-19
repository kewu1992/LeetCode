public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++){
            height[i] = 0;
            left[i] = 0;
            right[i] = n;
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++){
            int curLeft = 0;
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1'){
                    left[j] = Integer.max(left[j], curLeft);
                    height[j]++;
                } else {
                    curLeft = j + 1;
                    height[j] = 0;
                    left[j] = 0;
                    right[j] = n;
                }
            int curRight = n;
            for (int j = n-1; j >= 0; j--)
                if (matrix[i][j] == '1'){
                    right[j] = Integer.min(right[j], curRight);
                    if (ans < (right[j] - left[j]) * height[j])
                        ans = (right[j] - left[j]) * height[j];
                } else 
                    curRight = j;
        }
        return ans;
    }
}
