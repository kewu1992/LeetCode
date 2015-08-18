public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < t.length(); i++)
            if (map.containsKey(t.charAt(i)))
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            else
                map.put(t.charAt(i), 1);
     
        int toBeFinished = map.size();
        int i = 0;
        while (i < s.length() && !map.containsKey(s.charAt(i)))
            i++;
        int j = i;
        while (toBeFinished > 0){
            if (j == s.length())
                break;
            if (map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0)
                    toBeFinished--;
            }
            j++;
        }
        if (toBeFinished == 0){
             while (true){
                if (map.containsKey(s.charAt(i))){
                    if (map.get(s.charAt(i)) < 0){
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    } else
                        break;
                 }
                 i++;
             }
             String ans = s.substring(i, j);
             while (j < s.length()){
                 while (j < s.length() && s.charAt(j) != s.charAt(i)){
                     if (map.containsKey(s.charAt(j)))
                        map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                     j++;
                 }
                 if (j < s.length()){
                     map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                     j++;
                     while (true){
                         if (map.containsKey(s.charAt(i))){
                             if (map.get(s.charAt(i)) < 0){
                                 map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                             } else
                                break;
                         }
                         i++;
                     }
                     String temp = s.substring(i, j);
                     if (ans.length() > temp.length())
                        ans = temp;
                 }
             }
             return ans;
        } else
            return "";
    }
}
