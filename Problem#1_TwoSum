import java.util.Arrays;

public class Solution {
    class SortedNum implements Comparable<SortedNum>{
        int value;
        int index;

        @Override
        public int compareTo(final SortedNum other){
            return Integer.compare(this.value, other.value);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        SortedNum[] sortedNums = new SortedNum[nums.length];
        for (int i = 0; i < nums.length; i++){
            sortedNums[i] = new SortedNum();
            sortedNums[i].value = nums[i];
            sortedNums[i].index = i;
        }
        Arrays.sort(sortedNums);
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = lookUp(diff, sortedNums);
            if (index != -1 && index != i){
                int ans[] = new int[2];
                if (i < index){
                    ans[0] = i + 1;       // index is starting from 1
                    ans[1] = index + 1;
                } else {
                    ans[0] = index + 1;
                    ans[1] = i + 1;
                }
                return ans;
            }
        }
        return null;
    }

    int lookUp(int target, SortedNum[] nums){
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = (l + r) / 2;
            if (target == nums[m].value)
                return nums[m].index;
            else if (target < nums[m].value)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
}
