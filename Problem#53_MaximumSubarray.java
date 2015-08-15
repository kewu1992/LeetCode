public class Solution {
    public int maxSubArray(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        int result = ans[0];
        for (int i = 1; i < nums.length; i++) {
            if (ans[i-1] > 0)
                ans[i] = ans[i-1] + nums[i];
            else
                ans[i] = nums[i];
            if (result < ans[i])
                result = ans[i];
        }
        return result;
    }
}
