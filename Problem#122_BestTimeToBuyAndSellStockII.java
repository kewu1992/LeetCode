/* DP
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1)
            return 0;
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 0;
        for (int i = 1; i < n; i++){
            ans[i+1] = ans[i];  // not buy or sell stock
            for (int j = 0; j < i; j++) // buy stock in j and sell in i
                ans[i+1] = Integer.max(ans[i+1], ans[j] + prices[j] - prices[i]);
        }
        return ans[n];
    }
}
*/

/* O(n) solution */

public class Solution{
    public int maxProfit(int[] prices){
        int n = prices.length;
        if (n == 0 || n == 1)
            return 0;
        int ans = 0;
        for (int i = 1; i < n; i++)
            if (prices[i] - prices[i-1] > 0)
                ans += prices[i] - prices[i-1];
        return ans;
    }
}
