import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<String>();
        search(ans, 0, n, "");
        return ans;
    }

    private void search(List ans, int left, int n, String str){
        if (n == 0){
            while (left > 0){
                left--;
                str = str + ")";
            }
            ans.add(str);
            return;
        }

        if (n > 0)
            search(ans, left+1, n-1, str + "(");

        if (left > 0)
            search(ans, left-1, n, str + ")");
    }

}
