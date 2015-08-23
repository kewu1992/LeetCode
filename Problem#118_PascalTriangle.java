public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList();
        if (numRows == 0)
            return ans;
        List<Integer> now = new LinkedList();
        now.add(1);
        ans.add(now);
        if (numRows == 1)
            return ans;
        List<Integer> last = now;
        for (int i = 2; i <= numRows; i++){
            now = new LinkedList();
            now.add(1);
            for (int j = 0; j < last.size()-1; j++)
                now.add(last.get(j) + last.get(j+1));
            now.add(1);
            ans.add(now);
            last = now;
        }
        
        return ans;
    }
}
