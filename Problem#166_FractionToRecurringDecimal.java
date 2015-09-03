public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        int sign1 = numerator < 0 ? -1 : 1;
        int sign2 = denominator < 0 ? -1 : 1;
        long lnumerator = Math.abs((long)numerator);
        long ldenominator = Math.abs((long)denominator);
        Map<Long, Integer> map = new HashMap();
        StringBuilder ans = new StringBuilder();
        ans.append(lnumerator / ldenominator);
        lnumerator = lnumerator % ldenominator;
        if (lnumerator > 0) {
            ans.append('.');
            map.put(lnumerator, ans.length());
        }
        while (lnumerator > 0) {
            lnumerator *= 10;
            long div = lnumerator / ldenominator;
            ans.append(div);
            lnumerator %= ldenominator;
            if (map.containsKey(lnumerator)){
                ans.insert((int)map.get(lnumerator), '(');
                ans.append(')');
                break;
            } else {
                map.put(lnumerator, ans.length());
            }
        }
        if (sign1 * sign2 < 0 && !ans.toString().equals("0"))
            return "-" + ans.toString();
        else
            return ans.toString();
    }
}
