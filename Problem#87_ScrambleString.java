public class Solution {
    int[][][] isMatch;
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        isMatch = new int[len][len][len+1];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                for (int k = 0; k < len+1; k++)
                    isMatch[i][j][k] = -1;
                    
        return search(s1, s2, 0, 0, len);
    }
    
    private boolean search(String s1, String s2, int start1, int start2, int len){
        if (len == 0)
            return true;
        
        if (isMatch[start1][start2][len] != -1)
            return (isMatch[start1][start2][len] == 1);
            
        if (len == 1){
            if (s1.charAt(start1) == s2.charAt(start2))
                isMatch[start1][start2][len] = 1;
            else
                isMatch[start1][start2][len] = 0;
            return (isMatch[start1][start2][len] == 1);
        }
        
        for (int pivot = 1; pivot < len; pivot++){
            if (search(s1, s2, start1, start2, pivot) && search(s1, s2, start1+pivot, start2+pivot, len-pivot)){
                isMatch[start1][start2][len] = 1;
                return true;
            }
            if (search(s1, s2, start1, len-pivot+start2, pivot) && search(s1, s2, start1+pivot, start2, len-pivot)){ 
                isMatch[start1][start2][len] = 1;
                return true;
            }
        }
            
        isMatch[start1][start2][len] = 0;
        return false;
    }
}
