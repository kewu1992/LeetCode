import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        if (digits.compareTo("") == 0)
            return ans;
        ans.add("");
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++){
            int index = Integer.valueOf(digits.substring(i,i+1)) - 2;
            String[] temp = ans.toArray(new String[0]);
            ans.clear();
            for (int j = 0; j < temp.length; j++)
                for (int k = 0; k < map[index].length(); k++)
                    ans.add(temp[j] + map[index].substring(k, k+1));
        }
        return ans;
    }

}
