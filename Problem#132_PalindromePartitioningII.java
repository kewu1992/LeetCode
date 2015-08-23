public class Solution {
    private boolean[][] isPalindrome;
    public int minCut(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
            searchPalindrome(s, i-1, i+1);
            searchPalindrome(s, i, i+1);
        }
        
        int[] ans = new int[n+1];
        ans[0] = -1;
        for (int i = 0; i < n; i++){
            ans[i+1] = ans[i] + 1;
            for (int j = 0; j < i; j++)
                if (isPalindrome[j][i])
                    ans[i+1] = Integer.min(ans[i+1], ans[j] + 1);
        }
        return ans[n];
    }
    
    private void searchPalindrome(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            isPalindrome[l][r] = true;
            l--;
            r++;
        }
    }
}
