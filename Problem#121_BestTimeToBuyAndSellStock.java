public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int min = prices[0];
        int profit = prices[0] - min;
        for (int i = 1; i < prices.length; i++){
            if (profit < prices[i] - min)
                profit = prices[i] - min;
            if (min > prices[i])
                min = prices[i];
        }
        return profit;
    }
}
