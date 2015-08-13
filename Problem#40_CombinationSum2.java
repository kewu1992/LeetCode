import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] count = new int[candidates.length];
        count[0] = 0;
        for (int i = 1; i < candidates.length; i++)
            if (candidates[i] == candidates[i-1])
                count[i] = count[i-1] + 1;
            else
                count[i] = 0;

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        search(result, new LinkedHashMap<Integer, Integer>(), candidates, 0, target, count);
        return result;
    }

    private void search(List<List<Integer>> result, LinkedHashMap<Integer, Integer> now, int[] candidates, int n, int remain, int[] count){
        if (n == candidates.length)
            return;
        if (remain < candidates[n])
            return;

        search(result, now, candidates, n+1, remain, count);

        int numExisted = 0;
        if (now.containsKey(candidates[n]))
            numExisted = now.get(candidates[n]);
        if (numExisted < count[n])
            return;

        now.put(candidates[n], numExisted + 1);
        if (remain - candidates[n] > 0)
            search(result, now, candidates, n+1, remain - candidates[n], count);
        else {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            Iterator<Integer> iterator = now.keySet().iterator();
            while (iterator.hasNext()){
                int key = iterator.next();
                for (int i = 0; i < now.get(key); i++)
                    temp.add(key);
            }
            result.add(temp);
        }
        if (numExisted > 0)
            now.put(candidates[n], numExisted);
        else
            now.remove(candidates[n]);
    }

}
