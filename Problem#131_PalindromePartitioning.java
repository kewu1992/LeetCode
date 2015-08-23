public class Solution {
    private boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList();
        int n = s.length();
        if (n == 0)
            return ans;
        isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
            searchPalindrome(s, i-1, i+1);
            searchPalindrome(s, i, i+1);
        }
        
        search(s, 0, ans, new LinkedList());
        return ans;
    }
    
    private void searchPalindrome(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            isPalindrome[l][r] = true;
            l--;
            r++;
        }
    }
    
    private void search(String s, int index, List<List<String>> ans, List<String> cur){
        if (index >= s.length()){
            List<String> temp = new LinkedList();
            Iterator<String> iterator = cur.iterator();
            while (iterator.hasNext())
                temp.add(iterator.next());
            ans.add(temp);
            return;
        }
        for (int i = index; i < s.length(); i++)
            if (isPalindrome[index][i]){
                cur.add(s.substring(index, i+1));
                search(s, i+1, ans, cur);
                cur.remove(cur.size() - 1);
            }
    }
}
