public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i-1])
                left[i] = left[i-1] + 1;
            else 
                left[i] = 1;
        int[] right = new int[n];
        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--)
            if (ratings[i] > ratings[i+1])
                right[i] = right[i+1] + 1;
            else
                right[i] = 1;
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += Integer.max(left[i], right[i]);
        return ans;
    }
}
