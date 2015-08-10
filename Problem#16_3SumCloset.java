import java.util.Arrays;

public class Solution {

    /*  O(n2logn)
    public int threeSumClosest(int[] nums, int target) {
        int ans = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++){
                int k = binaryFind(nums, target - nums[i] - nums[j], j);
                int diff = Math.abs(target - nums[i] - nums[j] - nums[k]);
                if (ans == -1 || Math.abs(ans-target) > diff)
                    ans = nums[i] + nums[j] + nums[k];
            }
        return ans;
    }

    private int binaryFind(int[] nums, int target, int j){
        int ans = -1;
        int l = j + 1, r = nums.length - 1;
        while (l <= r){
            int m = (l + r) / 2;
            if (ans == -1 || (Math.abs(target - nums[ans]) > Math.abs(target - nums[m])))
                ans = m;
            if (nums[m] == target)
                return ans;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return ans;
    }
    */
    
    // O(n)
    public int threeSumClosest(int[] nums, int target){
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int temp = findCloest(nums, target - nums[i], i);
            if (Math.abs(target - nums[i] - temp) < Math.abs(target - ans))
                ans = temp + nums[i];
        }
        return ans;
    }

    private int findCloest(int[] nums, int target, int i){
        int lo = i + 1;
        int hi = nums.length - 1;
        int ans = nums[lo] + nums[hi];
        while (lo < hi){
            if (Math.abs(target - nums[lo] - nums[hi]) < Math.abs(target - ans))
                ans = nums[lo] + nums[hi];
            if (nums[lo] + nums[hi] == target)
                return ans;
            else if (nums[lo] + nums[hi] < target)
                lo++;
            else
                hi--;
        }
        return ans;
    }
}
