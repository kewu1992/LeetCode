import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set set = new HashSet();
        int ans = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++){
            if (last < i)
                last = i;
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            while ((last + 1) < s.length() && !set.contains(s.charAt(last + 1)))
                set.add(s.charAt(++last));
            if (ans < (last - i + 1))
                ans = last - i + 1;
            set.remove(s.charAt(i));
        }
        return ans;
    }
}
