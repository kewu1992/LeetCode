import java.util.*;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length - 1;
        while (n >= 0 && nums[n] <= 0)
            n--;
        for (int i = 0; i < n; i++)
            if (nums[i] <= 0){
                int temp = nums[i];
                nums[i] = nums[n];
                nums[n] = temp;
                while (n >= i && nums[n] <= 0)
                    n--;
            }
        for (int i = 0; i <= n; i++)
            nums[i] = - nums[i];
        for (int i = 0; i <= n; i++) {
            int temp = Math.abs(nums[i]);
            if (temp <= n + 1)
                nums[temp - 1] = Math.abs(nums[temp - 1]);
        }
        for (int i = 0; i <= n; i++)
            if (nums[i] < 0)
                return i+1;
        return n+2;
    }
}
