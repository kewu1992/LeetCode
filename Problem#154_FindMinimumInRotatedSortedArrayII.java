public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int i = 0, j = nums.length - 1;
        if (nums[i] < nums[j])  // no rotate
            return nums[0];
        int ans = nums[0];
        while (i <= j){
            int m = (i + j) / 2;
            if (nums[m] > nums[i]) {
                ans = Integer.min(ans, nums[i]);
                i = m+1;
            } else if (nums[m] < nums[i]) {
                ans = Integer.min(ans, nums[m]);
                j = m-1;
            } else {
                ans = Integer.min(ans, nums[i]);
                i++;
            }
        }
        return ans;
    }
}
