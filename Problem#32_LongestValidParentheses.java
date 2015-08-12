import java.util.*;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int parter[] = new int[s.length()];

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
                parter[i] = -1;
            } else {
                if (stack.isEmpty()){
                    parter[i] = -1;
                } else {
                    int index = stack.pop();
                    parter[index] = i;
                    parter[i] = index;
                }
            }
        }

        int count = 0, ans = 0;
        for (int i = 0; i < s.length(); i++)
            if (parter[i] >= 0){
                count++;
            } else {
                if (ans < count)
                    ans = count;
                count = 0;
            }
        if (ans < count)
            ans = count;
        
        return ans;
    }
}
