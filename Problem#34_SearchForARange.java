import java.util.*;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums[0] == target)  // pay attention
            ans[0] = 0;
        else
            ans[0] = binarySearchLeft(nums, target);
        if (nums[nums.length - 1] == target)  // pay attention
            ans[1] = nums.length - 1;
        else
            ans[1] = binarySearchRight(nums, target);
        return ans;
    }

    private int binarySearchLeft(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while (l < r){
            if (l == r-1)
                break;
            int m = (l + r) / 2;
            if (nums[m] < target)
                l = m;
            if (nums[m] >= target)
                r = m;
        }
        if (nums[r] == target){
            if (nums[l] == target)
                return l;
            else
                return r;
        }
        else
            return -1;
    }

    private int binarySearchRight(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while (l < r){
            if (l == r-1)
                break;
            int m = (l + r) / 2;
            if (nums[m] <= target)
                l = m;
            if (nums[m] > target)
                r = m;
        }
        if (nums[l] == target){
            if (nums[r] == target)
                return r;
            else
                return l;
        }
        else
            return -1;
    }

}
