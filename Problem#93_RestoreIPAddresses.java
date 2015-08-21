public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList();
        search(ans, new StringBuilder(), s, 0, 0);
        return ans;
    }
    
    private void search(List<String> ans, StringBuilder now, String s, int index, int step){
        if (step == 4){
            if (index == s.length())
                ans.add(now.toString().substring(0, now.length()-1));
            return;
        }
        if (index == s.length())
            return;
        int temp = now.length();
        now.append(s.substring(index, index+1));
        now.append(".");
        search(ans, now, s, index+1, step+1);
        now.delete(temp, temp+2);
        
        if (s.charAt(index) != '0' && index+1 < s.length()){
            now.append(s.substring(index, index+2));
            now.append(".");
            search(ans, now, s, index+2, step+1);
            now.delete(temp, temp+3);
            
            if (index+2 < s.length() && Integer.valueOf(s.substring(index, index+3)) <= 255){
                now.append(s.substring(index, index+3));
                now.append(".");
                search(ans, now, s, index+3, step+1);
                now.delete(temp, temp+4);
            }
        }
    }
}
