import  java.util.*;


public class Solution {
    private int[] factorial;
    public String getPermutation(int n, int k) {
        factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++)
            factorial[i] = factorial[i-1] * (i+1);
        return search(new StringBuilder(), n, k-1, n-2, new boolean[n]);
    }

    private String search(StringBuilder ans, int n, int remain, int now, boolean[] hasUsed){
        if (remain == 0){
            for (int i = 0; i < n; i++)
                if (!hasUsed[i])
                    ans.append(i+1);
            return ans.toString();
        }
        int count = 0;
        while (remain - factorial[now] >= 0){
            remain -= factorial[now];
            count++;
        }

        for (int i = 0; i < n; i++)
            if (!hasUsed[i]){
                if (count == 0){
                    ans.append(i+1);
                    hasUsed[i] = true;
                    break;
                } else
                    count--;
            }
        return search(ans, n, remain, now-1, hasUsed);
    }
}
