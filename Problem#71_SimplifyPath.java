import  java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0)
            return "";
        if (path.compareTo("/") == 0)
            return "/";
        if (path.charAt(path.length()-1) != '/')
            path = path + "/";
        int i = path.indexOf("/");
        Stack<String> ans = new Stack();
        ans.push(path.substring(0, i));
        while (i < path.length() && path.charAt(i) == '/')
            i++;
        if (i < path.length()){
            int j = path.substring(i).indexOf("/") + i;
            while (j != -1){
                String temp = path.substring(i,j);
                if (temp.compareTo(".") == 0){
                    // do nothing
                } else if (temp.compareTo("..") == 0){
                    if (ans.peek().compareTo("..") != 0 && ans.peek().compareTo("") != 0)
                        ans.pop();
                    else if (ans.peek().compareTo("..") == 0)
                        ans.push(temp);
                } else
                    ans.push(temp);
                i = j;
                while (i < path.length() && path.charAt(i) == '/')
                    i++;
                if (i == path.length())
                    break;
                j = path.substring(i).indexOf("/") + i;
            }
        }
        StringBuilder result = new StringBuilder();
        Iterator<String> iterator = ans.iterator();
        while (iterator.hasNext()){
            result.append(iterator.next());
            result.append("/");
        }
        String resultStr = result.toString();
        if (resultStr.length() > 1)
            return resultStr.substring(0, resultStr.length()-1);
        else
            return resultStr;
    }


}
