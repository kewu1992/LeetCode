public class Solution {
    public int romanToInt(String s) {
        StringBuilder ans = new StringBuilder();
        while (s.length() > 0){
            String digit = sub(s);
            ans.append(digit);
            if (digit.compareTo("8") == 0)
                s = s.substring(0, s.length() - 4);
            else if (digit.compareTo("3") == 0 || digit.compareTo("7") == 0)
                s = s.substring(0, s.length() - 3);
            else if (digit.compareTo("2") == 0 || digit.compareTo("4") == 0 || digit.compareTo("6") == 0 || digit.compareTo("9") == 0)
                s = s.substring(0, s.length() - 2);
            else if (digit.compareTo("1") == 0 || digit.compareTo("5") == 0)
                s = s.substring(0, s.length() - 1);
            s = divide10(s);
        }
        return Integer.valueOf(ans.reverse().toString());
    }

    private String sub (String origin){
        if (origin.length() >= 4 && origin.substring(origin.length()-4, origin.length()).compareTo("VIII") == 0)
            return "8";
        else if (origin.length() >= 3 && origin.substring(origin.length()-3, origin.length()).compareTo("III") == 0)
            return "3";
        else if (origin.length() >= 3 && origin.substring(origin.length()-3, origin.length()).compareTo("VII") == 0)
            return "7";
        else if (origin.length() >= 2 && origin.substring(origin.length()-2, origin.length()).compareTo("II") == 0)
            return "2";
        else if (origin.length() >= 2 && origin.substring(origin.length()-2, origin.length()).compareTo("IV") == 0)
            return "4";
        else if (origin.length() >= 2 && origin.substring(origin.length()-2, origin.length()).compareTo("VI") == 0)
            return "6";
        else if (origin.length() >= 2 && origin.substring(origin.length()-2, origin.length()).compareTo("IX") == 0)
            return "9";
        else if (origin.length() >= 1 && origin.substring(origin.length()-1, origin.length()).compareTo("I") == 0)
            return "1";
        else if (origin.length() >= 1 && origin.substring(origin.length()-1, origin.length()).compareTo("V") == 0)
            return "5";
        else
            return "0";

    }

    private String divide10(String origin){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < origin.length(); i++){
            if (origin.charAt(i) == 'X')
                s.append('I');
            else if (origin.charAt(i) == 'L')
                s.append('V');
            else if (origin.charAt(i) == 'C')
                s.append('X');
            else if (origin.charAt(i) == 'D')
                s.append('L');
            else if (origin.charAt(i) == 'M')
                s.append('C');
        }
        return s.toString();
    }

}
