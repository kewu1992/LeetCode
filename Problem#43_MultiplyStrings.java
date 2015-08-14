import java.util.*;

public class Solution {
    public String multiply(String num1, String num2) {
        int[] numsInt1 = new int[num1.length()];
        for (int i = 0; i < num1.length(); i++)
            numsInt1[num1.length() - i - 1] = num1.charAt(i) - '0';
        int[] numsInt2 = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++)
            numsInt2[num2.length() - i - 1] = num2.charAt(i) - '0';
        if (num1.length() < num2.length()){
            int[] temp = numsInt1;
            numsInt1 = numsInt2;
            numsInt2 = temp;
        }

        int[] ans = new int[num1.length() + num2.length()];

        for (int i = 0; i < numsInt2.length; i++){
            int[] tempAns = new int[numsInt1.length + 1];
            int carry = 0;
            for (int j = 0; j < numsInt1.length; j++){
                int temp = numsInt2[i] * numsInt1[j] + carry;
                tempAns[j] = temp % 10;
                carry = temp / 10;
            }
            tempAns[numsInt1.length] = carry;
            add(ans, tempAns, i);
        }

        StringBuilder ansStr = new StringBuilder();
        int i = ans.length - 1;
        while (i > 0 && ans[i] == 0)
            i--;
        for (; i >= 0; i--)
            ansStr.append(ans[i]);

        return ansStr.toString();
    }

    private void add(int[] n1, int[] n2, int multiplier){
        int carry = 0;
        int i = 0;
        while (i < n2.length){
            int temp = n1[i + multiplier] + n2[i] + carry;
            n1[i + multiplier] = temp % 10;
            carry = temp / 10;
            i++;
        }
        while (carry > 0){
            int temp = n1[i + multiplier] + carry;
            n1[i + multiplier] = temp % 10;
            carry = temp / 10;
            i++;
        }
    }

}
