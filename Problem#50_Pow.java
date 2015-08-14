import java.util.*;

public class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || n == 1)
            return x;
        if (n == 0)
            return 1;

        long nn = n;
        if (n < 0)
            nn = -(long)n;

        int count = (int)(Math.log(nn) / Math.log(2));
        double pow;
        count = 0;
        long pow2 = 1;

        double ans = x;
        while (pow2 * 2 <= nn){
            pow2 *= 2;
            count++;
            ans = ans * ans;
        };
        pow = ans;

        nn = nn - pow2;
        while (nn > 0){
            while (pow2 > nn){
                pow2 /= 2;
                count--;
                pow = Math.sqrt(pow);
            }
            nn = nn - pow2;
            ans *= pow;
        }

        if (n % 2 == 1 && x < 0)
            ans = -ans;
        
        if (n < 0)
            return 1 / ans;
        else
            return ans;
    }


}
