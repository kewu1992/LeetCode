public class Solution {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        boolean flag = false;
        if (x < 0){
            x = -x;
            flag = true;
        }
        StringBuilder ans = new StringBuilder();
        if (flag)
            ans.append('-');
        while (x > 0){
            int digit = x % 10;
            x = x / 10;
            ans.append(digit);
        }

        try {
            return Integer.valueOf(ans.toString());
        } catch (NumberFormatException e){
            return 0;
        }
    }
}
