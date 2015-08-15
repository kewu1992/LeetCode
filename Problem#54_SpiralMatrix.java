import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new LinkedList();
        int startRow = 0;
        int endRow = matrix.length;
        int startColumn = 0;
        int endColumn = matrix[0].length;
        int direction = 0;  // 0 for left, 1 for down, 2 for right, 3 for up
        int count = endRow * endColumn;
        List<Integer> ans = new LinkedList();
        int nowR = 0, nowC = 0;
        while (count > 0){
            ans.add(matrix[nowR][nowC]);
            count--;
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
        return ans;
    }

}
