public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)     // overflow
            return Integer.MAX_VALUE;
            
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1;

        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        int ans = 0, multiplier = 1;

        while (lDividend >= (lDivisor << 1)) {
            lDivisor = lDivisor << 1;
            multiplier = multiplier << 1;
        }
        while (lDividend >= lDivisor){
            lDividend = lDividend - lDivisor;
            ans += multiplier;
            if (lDividend == 0)
                break;
            while (lDividend < lDivisor && lDivisor > divisor){
                lDivisor = lDivisor >> 1;
                multiplier = multiplier >> 1;
            }
        }
        if (sign < 0)
            return -ans;
        else
            return ans;
    }

}
