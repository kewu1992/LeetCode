public class Solution {
    private class Node{
        int index;
        Node next;
        Node(int index, Node next){
            this.index = index;
            this.next = next;
        }
    }
    private class Ans{
        int length;
        List<Integer> last;
        Ans(int l, int index){
            length = l;
            last = new LinkedList();
            last.add(index);
        }
        void add(int index){
            last.add(index);
        }
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        String[] dictWords = dict.toArray(new String[0]);
        Map<String, Integer> map = new HashMap();
        int n = dictWords.length;
        for (int i = 0; i < n; i++) 
            map.put(dictWords[i], i);
        
        int startIndex = 0, endIndex = 0;
        Node[] list = new Node[n];
        for (int i = 0; i < n; i++) {
            String s = dictWords[i];
            if (s.compareTo(start) == 0)
                startIndex = i;
            if (s.compareTo(end) == 0)
                endIndex = i;
            list[i] = null;
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char originCh = charArray[j];
                for (char ch = 'a'; ch <= 'z'; ch++){
                    charArray[j] = ch;
                    s = new String(charArray);
                    if (map.containsKey(s)){
                        Node temp = new Node(map.get(s), list[i]);
                        list[i] = temp;
                    }
                }
                charArray[j] = originCh;
            }
        }
        
        Ans[] ans = new Ans[n];
        ans[endIndex] = new Ans(1, -1);
        
        Queue<Integer> indexQueue = new LinkedList();
        indexQueue.add(endIndex);
        while (!indexQueue.isEmpty()){
            int i = indexQueue.remove();
            if (i == startIndex)
                break;
            Node p = list[i];
            while (p != null) {
                if (ans[p.index] == null){
                    ans[p.index] = new Ans(ans[i].length + 1, i);
                    indexQueue.add(p.index);
                } else if (ans[p.index].length == ans[i].length + 1){
                    ans[p.index].add(i);
                }
                p = p.next;
            }
        }
        
        List<List<String>> result = new LinkedList();
        if (ans[startIndex] != null)
            search(result, new LinkedList(), ans, dictWords, startIndex);
        return result;  
    }
    
    private void search(List<List<String>> result, List<String> now, Ans[] ans, String[] dictWords, int step){
        if (step == -1){
            List<String> temp = new LinkedList();
            Iterator<String> iterator = now.iterator();
            while (iterator.hasNext())
                temp.add(iterator.next());
            result.add(temp);
            return;
        }
        
        now.add(dictWords[step]);
        Iterator<Integer> iterator = ans[step].last.iterator();
        while (iterator.hasNext())
            search(result, now, ans, dictWords, iterator.next());
        now.remove(now.size() - 1);
    }
}
