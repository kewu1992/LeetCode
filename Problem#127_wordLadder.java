public class Solution {
    private class Node{
        int index;
        Node next;
        Node(int index, Node next){
            this.index = index;
            this.next = next;
        }
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Iterator<String> iterator = wordDict.iterator();
        Map<String, Integer> map = new HashMap();
        int n = 0;
        while (iterator.hasNext()){
            map.put(iterator.next(), n++);
        }
        int start = 0, end = 0;
        Node[] list = new Node[n];
        iterator = wordDict.iterator();
        for (int i = 0; i < n; i++) {
            String s = iterator.next();
            if (s.compareTo(beginWord) == 0)
                start = i;
            if (s.compareTo(endWord) == 0)
                end = i;
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
        
        int[] ans = new int[n];
        ans[start] = 1;
        Queue<Integer> indexQueue = new LinkedList();
        indexQueue.add(start);
        while (!indexQueue.isEmpty()){
            int i = indexQueue.remove();
            Node p = list[i];
            while (p != null) {
                if (ans[p.index] == 0){
                    ans[p.index] = ans[i] + 1;
                    if (p.index == end)
                        break;
                    else
                        indexQueue.add(p.index);
                }
                p = p.next;
            }
        }
        return ans[end];
    }
}
