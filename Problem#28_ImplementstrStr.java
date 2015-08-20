public class Solution {
    
    int prev[];     // it is length, not index
    
    public int strStr(String haystack, String needle) {
        if (needle.compareTo("") == 0)
            return 0;
        else if (haystack.compareTo("") == 0)
            return -1;
            
        calP(needle);
        int j = 0;  // haystack[i] has matched with the previous j characters of needle
        for (int i = 0; i < haystack.length(); i++){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = prev[j];
            if (haystack.charAt(i) == needle.charAt(j)) // here j is used for index = (j + 1) - 1
                j++;
            if (j == needle.length()){
                return i - j + 1;
                // j = prev[j];
            }
        }
        return -1;
    }
    
    private void calP(String str){
        prev = new int[str.length() + 1];
        prev[1] = 0;
        int j = 0;
        for (int i = 1; i < str.length(); i++){
            while (j > 0 && str.charAt(i) != str.charAt(j)) j = prev[j];
            if (str.charAt(i) == str.charAt(j))
                j++;
            prev[i + 1] = j;    // str.charAt(i) is str[i+1]
        }
    }
}
