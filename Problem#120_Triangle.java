public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
       if (n == 0)
            return 0;
       int[][] ans = new int[2][n];
       int last = 0, now = 0;
       ans[0][0] = triangle.get(0).get(0);
       for (int i = 1; i < n; i++){
           now = 1 - last;
           ans[now][0] = ans[last][0] + triangle.get(i).get(0);;
           for (int j = 1; j < i; j++){
               ans[now][j] = Integer.min(ans[last][j-1], ans[last][j]) + triangle.get(i).get(j);
           }
           ans[now][i] = ans[last][i-1] + triangle.get(i).get(i);;
           last = now;
       }
       
       int min = ans[now][0];
       for (int i = 1; i < n; i++)
            min = Integer.min(min, ans[now][i]);
       return min;
    }
}
