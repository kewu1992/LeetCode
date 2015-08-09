public class Solution {
    public int myAtoi(String str) {
        int ans = 0;
        int i = 0;
        boolean flag = false;

        while ((i < str.length()) && (str.charAt(i) == ' '))
            i++;

        if ((i < str.length()) && (str.charAt(i) == '+' || str.charAt(i) == '-')){
            if (str.charAt(i) == '-')
                flag = true;
            i++;
        }

        while (i < str.length() && '0' <= str.charAt(i) && str.charAt(i) <= '9'){
            int lastAns = ans;
            ans *= 10;
            /* check overflow */
            if (flag && ans / 10 != lastAns)
                return -2147483648;
            else if (!flag && ans / 10 != lastAns )
                return  2147483647;
            if (flag)
                ans -= str.charAt(i) - '0';
            else
                ans += str.charAt(i) - '0';
            /* check overflow */
            if (flag && ans > 0)
                return -2147483648;
            else if (!flag && ans < 0)
                return 2147483647;
            i++;
        }
        return ans;
    }

}
