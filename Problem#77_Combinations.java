public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList();
        search(ans, new LinkedList(), n, 1, k);
        return ans;
    }
    
    private void search(List<List<Integer>> ans, List<Integer> now, int n, int step, int remain){
        if (remain == 0){
            List<Integer> temp = new LinkedList();
            Iterator<Integer> iterator = now.iterator();
            while (iterator.hasNext())
                temp.add(iterator.next());
            ans.add(temp);
            return;
        }
        if (step == n+1)
            return;
        
        int index = now.size();
        now.add(step);
        search(ans, now, n, step+1, remain-1);
        now.remove(index);
        
        search(ans, now, n, step+1, remain);
    }
}
