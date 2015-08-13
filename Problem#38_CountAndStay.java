public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int t = 1; t < n; t++){
            StringBuilder temp = new StringBuilder();
            int count = 1;
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++){
                if (c == s.charAt(i))
                    count++;
                else {
                    temp.append(count);
                    temp.append(c);
                    c = s.charAt(i);
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(c);
            s = temp.toString();    
        }
        return s;
    }
}
