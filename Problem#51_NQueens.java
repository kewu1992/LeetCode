import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<List<String>>();
        search(ans, new int[n], n, 0, new boolean[n], new boolean[2*n], new boolean[2*n]);
        return ans;
    }
    private void search(List<List<String>> ans, int[] now, int n, int row, boolean[] column, boolean[] dig, boolean[] rdig){
        if (row == n){
            List<String> temp = new LinkedList<String>();
            char[] s = new char[n];
            for (int i = 0; i < n; i++)
                s[i] = '.';
            for (int i = 0; i < n; i++) {
                s[now[i]] = 'Q';
                temp.add(String.valueOf(s));
                s[now[i]] = '.';
            }
            ans.add(temp);
            return;
        }

        for (int i = 0; i < n; i++)
            if (!column[i] && !dig[row-i+n-1] && !rdig[row+i]){
                column[i] = true;
                dig[row-i+n-1] = true;
                rdig[row+i] = true;
                now[row] = i;
                search(ans, now, n, row + 1, column, dig, rdig);
                column[i] = false;
                dig[row-i+n-1] = false;
                rdig[row+i] = false;
            }
    }

}
