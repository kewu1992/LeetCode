public class Solution {
    public String intToRoman(int num) {
        StringBuilder digits = new StringBuilder();
        while (num > 0){
            int digit = num % 10;
            num /= 10;
            digits.append(digit);
        }
        digits = digits.reverse();

        String ans = new String();
        for (int i = 0; i < digits.length(); i++) {
            ans = times10(ans);
            ans = add(ans, digits.charAt(i));
        }
        return ans;
    }

    private String add(String origin, char value){
        if (value == '1')
            return origin + "I";
        else if (value == '2')
            return origin + "II";
        else if (value == '3')
            return origin + "III";
        else if (value == '4')
            return origin + "IV";
        else if (value == '5')
            return origin + "V";
        else if (value == '6')
            return origin + "VI";
        else if (value == '7')
            return origin + "VII";
        else if (value == '8')
            return origin + "VIII";
        else if (value == '9')
            return origin + "IX";
        else
            return origin;
    }

    private String times10(String origin){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < origin.length(); i++){
            if (origin.charAt(i) == 'I')
                s.append('X');
            else if (origin.charAt(i) == 'V')
                s.append('L');
            else if (origin.charAt(i) == 'X')
                s.append('C');
            else if (origin.charAt(i) == 'L')
                s.append('D');
            else if (origin.charAt(i) == 'C')
                s.append('M');
        }
        return s.toString();
    }

}
