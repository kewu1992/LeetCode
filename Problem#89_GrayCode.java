public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new LinkedList();
        if (n == 0){
            ans.add(0);
            return ans;
        }
        ans.add(0);
        ans.add(1);
        for (int i = 2; i <= n; i++){
            for (int j = ans.size() - 1; j >= 0; j--)
                ans.add(ans.get(j) | (1 << (i-1)));
        }
        return ans;
    }
}
