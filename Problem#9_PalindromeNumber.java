public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        StringBuilder s = new StringBuilder();
        while (x > 0){
            s.append(x % 10);
            x /= 10;
        }
        int i = 0, j = s.length() - 1;
        while (i <= j){
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
