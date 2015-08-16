public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0){
            int temp = Integer.valueOf(a.substring(i,i+1)) + Integer.valueOf(b.substring(j,j+1)) + carry;
            ans.append(temp % 2);
            carry = temp / 2;
            i--;
            j--;
        }
        while (i >= 0 || j >= 0){
            int temp;
            if (i >= 0){
                temp = Integer.valueOf(a.substring(i,i+1)) + carry;
                i--;
            } else{
                temp = Integer.valueOf(b.substring(j,j+1)) + carry;
                j--;
            }
            ans.append(temp % 2);
            carry = temp / 2;
        }
        if (carry > 0)
            ans.append(1);
        return ans.reverse().toString();
    }
}
