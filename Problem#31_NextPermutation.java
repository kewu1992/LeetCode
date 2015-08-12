import java.util.*;

public class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        for (int i = nums.length - 2; i >= 0; i--){
            for (int j = nums.length-1; j > i; j--){
                if (nums[j] > nums[i]){
                    exch(nums, i, j);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                sort(nums, i+1);
                break;
            }
        }

        if (!flag){
           sort(nums, 0);
        }
    }

    private void sort(int[] nums, int start){
        for (int j = start; j < nums.length; j++)
            for (int k = j+1; k < nums.length; k++)
                if (nums[j] > nums[k])
                    exch(nums, j, k);
    }

    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
