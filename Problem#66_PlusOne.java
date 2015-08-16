public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] ans = new int[digits.length + 1];
        for (int i = digits.length-1; i >= 0; i--){
            int temp = digits[i] + carry;
            ans[i+1] = temp % 10;
            carry = temp / 10;
        }    
        if (carry == 1){
            ans[0] = 1;
            return ans;
        } else
            return Arrays.copyOfRange(ans, 1, ans.length);
    }
}
