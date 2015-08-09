public class Solution {
    public String longestPalindrome(String s) {
        if (s.compareTo("") == 0)
            return "";
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = findPalindrome(i - 1, i + 1, s);
            if (temp.length() > ans.length())
                ans = temp;
            temp = findPalindrome(i, i + 1, s);
            if (temp.length() > ans.length())
                ans = temp;
        }
        return ans;
    }

    private String findPalindrome(int lo, int hi, String s){
        int i = lo, j = hi;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
