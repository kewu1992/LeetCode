public class Solution {
    public int numTrees(int n) {
        int[] ans = new int[n+1];
        ans[0] = 1;
        for (int i = 1; i <= n; i++){
            ans[i] = 0;
            for (int j = 1; j <= i; j++)
                ans[i] += ans[j-1] * ans[i-j];
        }
        return ans[n];
    }
}
