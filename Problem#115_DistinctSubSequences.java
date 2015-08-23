public class Solution {
    public int numDistinct(String s, String t) {
        int diff = s.length() - t.length();
        if (diff < 0)
            return 0;
        int[] ans = new int[diff+1];
        ans[0] = 1;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = Integer.min(i+1, diff); j >= 1 ; j-- ){
                int temp = ans[j];
                ans[j] = ans[j-1];
                if (i+1 > j){
                    if ((i-j) < t.length() && s.charAt(i) == t.charAt(i-j))
                        ans[j] += temp;
                }
            }
            if (i < t.length() && s.charAt(i) == t.charAt(i))
                ans[0] = ans[0];
            else
                ans[0] = 0;
        }
        return ans[diff];
    }
     
}
