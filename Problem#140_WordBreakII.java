public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        List<String> result = new LinkedList();
        if (n == 0)
            return result;
        List<Integer>[] ans = new LinkedList[n+1];
        ans[0] = new LinkedList();
        ans[0].add(0);
        for (int i = 0; i < n; i++){
            ans[i+1] = new LinkedList();
            for (String word : wordDict)
                if ((i+1 - word.length() >= 0) && (!ans[i+1-word.length()].isEmpty()) && (s.substring(i+1-word.length(), i+1).compareTo(word) == 0)) {
                    ans[i+1].add(i+1-word.length());
                }
        }
        search(result, new StringBuilder(), s, ans, n);
        
        return result;
    }
    private void search(List<String> result, StringBuilder word, String s, List<Integer>[] ans, int step){
        if (step == 0){
            result.add(word.toString());
            return;
        }
        if (step != s.length())
            word.insert(0, ' ');
        for (int i = 0; i < ans[step].size(); i++){
            word.insert(0, s.substring(ans[step].get(i), step));
            search(result, word, s, ans, ans[step].get(i));
            word.delete(0, step - ans[step].get(i));
        }
        word.delete(0, 1);
    }
}
