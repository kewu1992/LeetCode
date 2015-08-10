import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  Method of deduplicate
 *   1) make sure i < j < k (so that nums[i] <= nums[j] <= nums[k])
 *   2) make sure only use the first equivalent number when looping i and j
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])  // deduplicate
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > (i+1) && nums[j] == nums[j-1])  // deduplicate
                    continue;
                int k = findNum(nums, i, j);
                if (k != -1) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    private int findNum(int[] nums, int i, int j){
        int l = 0, r = nums.length - 1;
        int target = 0 - nums[i] - nums[j];
        while (l <= r){
            int m = (l + r) / 2;
            if (nums[m] == target){
                while (m < nums.length && nums[m] == target && (m <= i || m <= j))
                    m++;
                if (m < nums.length && nums[m] == target)
                    return m;
                else
                    return -1;
            }
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}
