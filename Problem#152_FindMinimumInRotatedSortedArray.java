public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int i = 0, j = nums.length - 1;
        if (nums[i] < nums[j])  // no rotate
            return nums[0];
        while (i < j){
            if (i + 1 == j)
                break;
            int m = (i + j) / 2;
            if (nums[m] > nums[0])
                i = m+1;
            else
                j = m;
        }
        if (i == j)
            return nums[i];
        else
            return Integer.min(nums[i], nums[j]);
    }
}
