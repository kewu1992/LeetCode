import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i + 1; j < nums.length-2; j++){
                if (j > (i+1) && nums[j] == nums[j-1])
                    continue;
                int lo = j+1;
                int hi = nums.length - 1;
                int twoSumTarget = target - nums[i] - nums[j];
                while (lo < hi){
                    if (nums[lo] + nums[hi] == twoSumTarget){
                        List<Integer> temp = new LinkedList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);
                        ans.add(temp);
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if (nums[lo] + nums[hi] < twoSumTarget)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return ans;
    }

}
