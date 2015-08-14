import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] index = new int[nums.length];
        count[0] = 0;
        index[0] = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i-1]) {
                count[i] = count[i - 1] + 1;
                index[i] = index[i - 1];
            } else {
                count[i] = 0;
                index[i] = i;
            }

        List<List<Integer>> ans = new LinkedList();
        List<Integer> now = new LinkedList<Integer>();
        search(ans, now, nums, new int[nums.length], count, index, 0);
        return ans;
    }

    private void search(List<List<Integer>> ans, List<Integer> now, int[] nums, int[] nowCount, int[] count, int[] index, int n){
        if (n == nums.length){
            List<Integer> temp = new LinkedList<Integer>();
            Iterator<Integer> iterator = now.iterator();
            while (iterator.hasNext())
                temp.add(iterator.next());
            ans.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++)
            if (nowCount[index[i]] == count[i]){
                nowCount[index[i]]++;
                now.add(nums[i]);
                int temp = now.size();
                search(ans, now, nums, nowCount, count, index, n+1);
                now.remove(temp - 1);
                nowCount[index[i]]--;
            }
    }

}
