import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++){
            String hashStr = sortString(strs[i]);
            if (!map.containsKey(hashStr)){
                List<String> temp = new LinkedList();
                temp.add(strs[i]);
                map.put(hashStr, temp);
            } else {
                List<String> temp = map.get(hashStr);
                temp.add(strs[i]);
            }
        }
        List<List<String>> ans = new LinkedList();
        Iterator<List<String>> iterator = map.values().iterator();
        while (iterator.hasNext())
            ans.add(iterator.next());
        return ans;
    }

    private String sortString(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++)
            for (int j = i + 1; j < c.length; j++)
                if (c[i] > c[j]){
                    char temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }
        return String.valueOf(c);
    }

}
