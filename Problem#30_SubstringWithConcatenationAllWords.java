/*    1. Notice the use of hashMap (instead of binary search), hashMap can used for histogram!
 *    2. Notice how to maintian a window
 *    3. Notice how to use a queue to help maintain a window
 *    4. Notice how to detect the sucess pattern, using finishWords so that some words in the window can less than or more than the expected
 *    5. Notice using a new hashMap for counting, so that it is time-saving to reset the counters when encounter an invalid word
 *
 */
import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == "" || words.length == 0)
            return new LinkedList<Integer>();
        int len = words[0].length();
        int len2 = s.length() - len + 1;

        Map<String, Integer> wordsCounts = new HashMap();
        for (int i = 0; i < words.length; i++)
            if (wordsCounts.containsKey(words[i]))
                wordsCounts.put(words[i], wordsCounts.get(words[i]) + 1);
            else
                wordsCounts.put(words[i], 1);

        Map<String, Integer> counts = new HashMap<String, Integer>();
        List<Integer> ans = new LinkedList<Integer>();
        List<String> queue = new LinkedList<String>();
        int finishWords = 0;

        for (int l = 0; l < len; l++){
            queue.clear();
            finishWords = 0;
            counts.clear();
            for (int i = l; i < len2; i+=len){
                String word = s.substring(i, i+len);
                if (wordsCounts.containsKey(word)){
                    if (counts.containsKey(word))
                        counts.put(word, counts.get(word) + 1);
                    else
                        counts.put(word, 1);
                    if (counts.get(word) == wordsCounts.get(word))
                        finishWords++;
                    else if (counts.get(word) == wordsCounts.get(word) + 1)
                        finishWords--;
                    queue.add(word);
                    if (queue.size() > words.length){
                        word = queue.remove(0);
                        counts.put(word, counts.get(word) - 1);
                        if (counts.get(word) == wordsCounts.get(word))
                            finishWords++;
                        else if (counts.get(word) == wordsCounts.get(word) - 1)
                            finishWords--;
                    }
                    if (finishWords == wordsCounts.size()){
                        ans.add(i + len - len * words.length);
                    }
                } else {
                    queue.clear();
                    finishWords = 0;
                    counts.clear();
                }
            }
        }
        return ans;
    }

}
