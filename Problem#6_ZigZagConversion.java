public class Solution {
    public String convert(String s, int numRows) {
        if (s.compareTo("") == 0)
            return "";
        StringBuilder[] str = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            str[i] = new StringBuilder();
        int offset = 0;
        boolean flag = false;
        str[0].append(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            int index = (i + offset) % numRows;
            if (flag) index = numRows - 1 - index;
            str[index].append(s.charAt(i));
            if (index == 0 || index == (numRows - 1)) {
                flag = !flag;
                offset = (offset + 1) % numRows;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++)
            ans.append(str[i].toString());
        return ans.toString();
    }

}
