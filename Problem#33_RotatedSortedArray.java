/*  Notice the boundary condition and 
 *  Notice when l == m-1, when l == m
 */
import java.util.*;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length <= 3){    // boundary condition
            for (int i = 0; i < nums.length; i++)
                if (target == nums[i])
                    return i;
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l < r){
            if (l == r-1)
                break;
            int m = (l + r) / 2;
            if (nums[l] < nums[m])
                l = m;
            else
                r = m;
        }
        int pivotL = l, pivotR = r;
        
        if (pivotL >=0 && nums[0] <= target && target <= nums[pivotL])
            return binarySearch(nums, 0, pivotL, target);
        else
            return binarySearch(nums, pivotR, nums.length-1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        int l = start, r = end;
        while (l <= r){
            int m = (l + r) / 2;
            if (target == nums[m])
                return m;
            else if (target < nums[m])
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
}
