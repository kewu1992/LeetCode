public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        if (n == 0)
            return true;
        boolean[] ans = new boolean[n+1];
        ans[0] = true;
        for (int i = 0; i < n; i++){
            for (String word : wordDict)
                if ((i+1 - word.length() >= 0) && (ans[i+1-word.length()]) && (s.substring(i+1-word.length(), i+1).compareTo(word) == 0)) {
                    ans[i+1] = true;
                    break;
                }
        }
        return ans[n];
    }
}
