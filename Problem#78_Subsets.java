public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return new LinkedList();
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList();
        List<Integer> now = new LinkedList();
        Stack<Integer> step = new Stack();
        step.push(1);
        while (!step.isEmpty()){
            int i = step.pop();
            if (i == nums.length + 1){
                List<Integer> temp = new LinkedList();
                Iterator<Integer> iterator = now.iterator();
                while (iterator.hasNext())
                    temp.add(iterator.next());
                ans.add(temp);
                continue;
            }
            if (i > 0){
                now.add(nums[i-1]);
                step.push(-i);
                step.push(i + 1);
            } else {
                now.remove(now.size() - 1);
                step.push(-i + 1);
            }
        }
        return ans;
    }
}
