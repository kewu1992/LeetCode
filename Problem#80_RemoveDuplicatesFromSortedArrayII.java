public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int i, j;
        if (nums[0] == nums[1]){
            i = 2;
            j = 2;
            while (j < nums.length && nums[j] == nums[j-1])
                j++;
        } else {
            i = 1;
            j = 1;
        }
        
        while (j < nums.length){
            if ((j+1) < nums.length && nums[j+1] == nums[j]){
                nums[i] = nums[j];
                nums[i+1] = nums[j];
                i += 2;
                j++;
                while (j < nums.length && nums[j] == nums[j-1])
                    j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
