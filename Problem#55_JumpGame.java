public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farest = 0;
        int start[] = new int[n];
        for (int i = 0; i < n; i++){
            if (farest >= i+1)
                start[i] = farest + 1;
            else
                start[i] = i+1;
            if (i + nums[i] > farest)
                farest = i + nums[i];
        }
        
        boolean[] ans = new boolean[n];
        ans[0] = true;
        for (int i = 0; i < n; i++) {
            if (!ans[i])
                continue;
            for (int j = start[i]; j < Math.min(n, i + nums[i] + 1); j++)
                ans[j] = true;
        }
     
        return ans[n-1];
    }
}
