import java.util.*;

public class Solution {
    int ans = 0;
    int done;
    public int totalNQueens(int n) {
        done = (1 << n) - 1;
        search(0, 0, 0);
        return ans;
    }
    private void search(int column, int dig, int rdig){
        if (column == done){
            ans++;
            return;
        }

        int availablePosition = done & ~(column | dig | rdig);
        int pos = availablePosition & (-availablePosition);
        while (pos > 0){
            availablePosition = availablePosition - pos;
            search(column+pos, (dig+pos) >> 1, (rdig+pos) << 1);
            pos = availablePosition & (-availablePosition);
        }
    }
}
