public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0)
            return 0;
        int last = s.length()-1;
        while (last >= 0 && s.charAt(last) == ' ')
            last--;
        if (last < 0)
            return 0;
        int first = last-1;
        while (first >= 0 && s.charAt(first) != ' ')
            first--;
        return last - first;
    }
}
