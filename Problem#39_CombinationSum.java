import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        search(result, new LinkedList<Integer>(), candidates, 0, target);
        return result;
    }

    private void search(List<List<Integer>> result, List<Integer> now, int[] candidates, int n, int remain){
        if (n == candidates.length)
            return;
        if (remain < candidates[n])
            return;

        search(result, now, candidates, n+1, remain);

        now.add(candidates[n]);
        if (remain - candidates[n] > 0)
            search(result, now, candidates, n, remain - candidates[n]);
        else {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            Iterator<Integer> iterator = now.iterator();
            while (iterator.hasNext()){
                temp.add(iterator.next());
            }
            result.add(temp);
        }
        now.remove((Object)Integer.valueOf(candidates[n]));
    }

}
