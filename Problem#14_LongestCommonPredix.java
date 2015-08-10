public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ansStr = strs[0];
        for (int i = 1; i < strs.length; i++)
            ansStr = findPrefix(ansStr, strs[i]);
        return ansStr;
    }

    private String findPrefix(String s1, String s2){
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i))
            i++;
        return s1.substring(0, i);
    }

}
