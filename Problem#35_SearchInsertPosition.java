public class Solution {
    public int searchInsert(int[] nums, int target) {
        // boundary condition
        if (target < nums[0])
            return 0;
        else if (target > nums[nums.length - 1])
            return nums.length;
            
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        // use r to detect
        if (nums[r] < target)
            return r + 1;
        else
            return r - 1;
    }
}
