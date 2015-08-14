import java.util.*;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean isMatchBefore[][] = new boolean[s.length() + 1][p.length() + 1];
        isMatchBefore[0][0] = true;
        for (int i = 1; i < s.length() + 1; i++)
            isMatchBefore[i][0] = false;
        for (int i = 1; i < p.length() + 1; i++)
            isMatchBefore[0][i] = isMatchBefore[0][i-1] && (p.charAt(i-1) == '*');

        for (int i = 1; i < s.length() + 1; i++)
            for (int j = 1; j < p.length() + 1; j++){
                if (isMatchBefore[i-1][j-1]){
                    if (p.charAt(j-1) == '?')
                        isMatchBefore[i][j] = true;
                    else if (s.charAt(i-1) == p.charAt(j-1))
                        isMatchBefore[i][j] = true;
                }
                if (isMatchBefore[i][j-1]){
                    if (p.charAt(j-1) == '*')
                        isMatchBefore[i][j] = true;
                }
                if (isMatchBefore[i-1][j]){
                    if (p.charAt(j-1) == '*')
                        isMatchBefore[i][j] = true;
                }
            }
        return isMatchBefore[s.length()][p.length()];
    }

}
