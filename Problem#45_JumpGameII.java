public class Solution {
    public int jump(int[] nums) {
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
        
        int[] ans = new int[n];
        ans[n-1] = 0;
        for (int i = n - 2; i >= 0; i--){
            ans[i] = -1;
            for (int j = start[i]; j < Math.min(n, i + nums[i] + 1); j++)
                if (ans[j] != -1){
                    if (ans[i] == -1 || ans[i] > ans[j] + 1)
                        ans[i] = ans[j] + 1;
                }
        }
        return ans[0];
    }
}
