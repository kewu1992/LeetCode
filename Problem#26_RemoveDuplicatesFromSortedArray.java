public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums.length;
        int i = 1, j = 1;
        while (j < nums.length){
            while (j < nums.length && nums[j] == nums[j-1])
                j++;
            if (j == nums.length)
                break;
            nums[i++] = nums[j];
            j++;
        }
        return i;
    }
}
