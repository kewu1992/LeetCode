public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int ans[] = new int[s.length()];
        if (s.charAt(0) != '0')
            ans[0] = 1;
        else
            ans[0] = 0;
        if (s.length() == 1)
            return ans[0];
            
        int temp = Integer.valueOf(s.substring(0, 2));
        if (temp > 26){
            if (temp % 10 == 0)
                ans[1] = 0;
            else 
                ans[1] = 1;
        } else if (temp == 20 || temp == 10){
            ans[1] = 1;
        } else if (temp > 10){
            ans[1] = 2;
        } else
            ans[1] = 0;
        
        for (int i = 2; i < s.length(); i++){
            ans[i] = 0;
            if (s.charAt(i) != '0')
                ans[i] += ans[i-1];
            if (Integer.valueOf(s.substring(i-1, i+1)) <= 26 && Integer.valueOf(s.substring(i-1, i+1)) >= 10)
                ans[i] += ans[i-2];
        }
        
        return ans[s.length()-1];
    }
    
}
