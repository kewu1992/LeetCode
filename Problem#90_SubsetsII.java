public class Solution {
    int count[];
    Map<Integer, Integer> counter;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        count = new int[nums.length];
        counter = new HashMap();
        count[0] = 0;
        counter.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i-1])
                count[i] = count[i-1] + 1;
            else {
                count[i] = 0;
                counter.put(nums[i], 0);
            }
        List<List<Integer>> ans = new LinkedList();
        search(ans, new LinkedList(), nums, 0);
        return ans;
    }
    
    private void search(List<List<Integer>> ans, List<Integer> now, int[] nums, int step){
        if (step == nums.length){
            List<Integer> temp = new LinkedList();
            Iterator<Integer> iterator = now.iterator();
            while (iterator.hasNext()){
                temp.add(iterator.next());
            }
            ans.add(temp);
            return;
        }
        
        search(ans, now, nums, step+1);
        
        if (counter.get(nums[step]) == count[step]){
            now.add(nums[step]);
            counter.put(nums[step], count[step] + 1);
            search(ans, now, nums, step+1);
            counter.put(nums[step], count[step]);
            now.remove(now.size()-1);
        }
    }
}
