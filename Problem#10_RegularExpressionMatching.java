public class Solution {
    public boolean isMatch(String s, String p) {

        StringBuilder simplePBuilder = new StringBuilder();
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) != '*')
                simplePBuilder.append(p.charAt(i));
        String simpleP = " " + simplePBuilder.toString();   //  appending an extra character
        boolean isStar[] = new boolean[simpleP.length()];
        int j = 1;
        for (int i = 0; i < p.length(); i++){
            if (p.charAt(i) == '*')
                isStar[j - 1] = true;
            else{
                isStar[j] = false;
                j++;
            }
        }

        s = " " + s;    // appending an extra character

        boolean isBeforeMatch[][] = new boolean[s.length()][simpleP.length()];
        isBeforeMatch[0][0] = true;
        for (int i = 1; i < s.length(); i++)
            isBeforeMatch[i][0] = false;
        for (int i = 1; i < simpleP.length(); i++)
            isBeforeMatch[0][i] = isStar[i] && isBeforeMatch[0][i - 1];

        for (int i = 1; i < s.length(); i++)
            for (j = 1; j < simpleP.length(); j++){
                isBeforeMatch[i][j] = false;
                if (isBeforeMatch[i - 1][j - 1]){
                    if (simpleP.charAt(j) == '.' )
                        isBeforeMatch[i][j] = true;
                    else if (s.charAt(i) == simpleP.charAt(j))
                        isBeforeMatch[i][j] = true;
                }
                if (isBeforeMatch[i][j - 1]){
                    if (isStar[j])
                        isBeforeMatch[i][j] = true;
                }
                if (isBeforeMatch[i - 1][j]){
                    if (isStar[j]){
                        if (simpleP.charAt(j) == '.' )
                            isBeforeMatch[i][j] = true;
                        else if (s.charAt(i) == simpleP.charAt(j))
                            isBeforeMatch[i][j] = true;
                    }
                }
            }
        return isBeforeMatch[s.length() - 1][simpleP.length() - 1];
    }

}
