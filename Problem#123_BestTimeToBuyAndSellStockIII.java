public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int last = 0;
        int max = 0;
        for (int i = 1; i < n; i++){
            if (last > 0)
                last = last + prices[i] - prices[i-1];
            else
                last = prices[i] - prices[i-1];
            if (max < last)
                max = last;
            leftMax[i] = max;
        }
        
        int[] rightMax = new int[n];
        rightMax[n-1] = 0;
        last = 0;
        max = 0;
        for (int i = n-2; i >= 0; i--) {
            if (last > 0)
                last = last + prices[i+1] - prices[i];
            else
                last = prices[i+1] - prices[i];
            if (max < last)
                max = last;
            rightMax[i] = max;
        }
        
        int ans = Integer.max(leftMax[n-1], rightMax[0]);   // just one transcation
        for (int i = 1; i <= n-2; i++)
            if (ans < leftMax[i] + rightMax[i+1])
                ans = leftMax[i] + rightMax[i+1];
        return ans;
    }
}
