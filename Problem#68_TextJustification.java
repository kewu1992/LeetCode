import  java.util.*;


public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<String>();
        int i = 0;
        while (i < words.length){
            int j = i + 1;
            int remain = maxWidth - words[i].length();
            while (j < words.length && remain - (words[j].length()+1) >= 0) {
                remain -= (words[j].length()+1);
                j++;
            }
            if (j == words.length){
                remain += j-i-1;
                StringBuilder temp = new StringBuilder();
                while (i < j){
                    temp.append(words[i]);
                    if (remain > 0) {
                        temp.append(' ');
                        remain--;
                    }
                    i++;
                }
                while (remain > 0){
                    temp.append(' ');
                    remain--;
                }
                ans.add(temp.toString());
            } else {

                if (j-i-1 == 0){
                    StringBuilder temp = new StringBuilder();
                    temp.append(words[i]);
                    while (remain > 0) {
                        temp.append(' ');
                        remain--;
                    }
                    ans.add(temp.toString());

                } else {
                    remain += j-i-1;
                    int spaceNum = remain / (j-i-1);
                    char[] spaces = new char[spaceNum];
                    for (int k = 0; k < spaceNum; k++)
                        spaces[k] = ' ';
                    String space = String.valueOf(spaces);
                    int extra = remain % (j-i-1);
                    StringBuilder temp = new StringBuilder();
                    while (i < j-1){
                        temp.append(words[i]);
                        temp.append(space);
                        if (extra > 0){
                            temp.append(' ');
                            extra--;
                        }
                        i++;
                    }
                    temp.append(words[i]);
                    ans.add(temp.toString());
                }
                i++;
            }
        }
        return ans;
    }


}
