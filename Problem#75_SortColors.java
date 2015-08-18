/* two passes
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i < j){
            while (i < j && (nums[i] == 0 || nums[i] == 1))
                i++;
            while (i < j && (nums[j] == 2 || nums[j] == 1))
                j--;
            if (i < j)
                exch(nums, i, j);
        }
        
        int end0, start2;
        if (j < i){
            end0 = j;
            start2 = i;
        } else {    // i == j
            if (nums[i] == 2){
                end0 = i-1;
                start2 = i;
            } else {
                end0 = i;
                start2 = i+1;
            }
        }
        
        i = 0;
        j = end0;
        while (i < j){
            while (i < j && nums[i] == 0)
                i++;
            while (i < j && nums[j] == 1)
                j--;
            if (i < j)
                exch(nums, i, j);
                
        }
        
        i = start2;
        j = nums.length-1;
        while (i < j){
            while (i < j && nums[i] == 1)
                i++;
            while (i < j && nums[j] == 2)
                j--;
            if (i < j)
                exch(nums, i, j);
        }
        
    }
    
    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
*/

// one pass
public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length-1;
        int i = 0;
        while (i <= two){
            if (nums[i] == 0){
                exch(nums, zero, i);
                if (nums[i] == 0)
                    i++;
                zero++;
            } else if (nums[i] == 2){
                exch(nums, two, i);
                two--;
            } else
                i++;
        }
        
    }
    
    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
