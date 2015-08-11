public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int i = 0, j = nums.length-1;
        while (i < j){
            while (i < j && nums[i] != val)
                i++;
            while (i < j && nums[j] == val)
                j--;
            if (i < j){
                nums[i] = nums[j];
                i++;
                j--;
            }
        }
        if (i == j){
            if (nums[i] == val)
                return j;
            else
                return j+1;
        } else
            return j+1;
    }
}
