import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList();
        List<Integer> now = new LinkedList<Integer>();
        search(ans, now, nums, new boolean[nums.length], 0);
        return ans;
    }

    private void search(List<List<Integer>> ans, List<Integer> now, int[] nums, boolean[] flag, int n){
        if (n == nums.length){
            List<Integer> temp = new LinkedList<Integer>();
            Iterator<Integer> iterator = now.iterator();
            while (iterator.hasNext())
                temp.add(iterator.next());
            ans.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++)
            if (!flag[i]){
                flag[i] = true;
                now.add(nums[i]);
                search(ans, now, nums, flag, n+1);
                now.remove((Object)Integer.valueOf(nums[i]));
                flag[i] = false;
            }
    }

}
