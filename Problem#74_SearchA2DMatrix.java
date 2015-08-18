public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length-1; i++)
            if (matrix[i][0] <= target && target < matrix[i+1][0]){
                if (Arrays.binarySearch(matrix[i], target) < 0)
                    return false;
                else
                    return true;
            }
        if (Arrays.binarySearch(matrix[matrix.length-1], target) < 0)
            return false;
        else
            return true;
    }
}
