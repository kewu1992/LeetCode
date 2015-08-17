public class Solution {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int[] ansBefore = new int[2];
        ansBefore[0] = Integer.MAX_VALUE;
        ansBefore[1] = Integer.MAX_VALUE;
        int count = 0;
        int ans = x / 2;
        while (ans * ans != x){
            ansBefore[count] = ans;
            count = (count + 1) % 2;
            ans = (ans + x / ans) / 2;
            if (ans == ansBefore[0] || ans == ansBefore[1])
                break;
        }
        if (ans == ansBefore[0] || ans == ansBefore[1])
            return Integer.min(ansBefore[0], ansBefore[1]);
        return ans;
    }
}
