public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3)
            return false;
        boolean[][] isMatch = new boolean[n1+1][n2+1];
        isMatch[0][0] = true;
        for (int i = 1; i < n1+1; i++)
            isMatch[i][0] = isMatch[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        for (int i = 1; i < n2+1; i++)
            isMatch[0][i] = isMatch[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        for (int i = 1; i < n1+1; i++)
            for (int j =1; j < n2+1; j++){
                if (isMatch[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)))
                    isMatch[i][j] = true;
                else if (isMatch[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)))
                    isMatch[i][j] = true;
                else
                    isMatch[i][j] = false;
            }
        
        return isMatch[n1][n2];
    }
}
