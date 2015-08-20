public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack();
        for (int i = 0; i < tokens.length; i++){
            String temp = tokens[i];
            if (temp.compareTo("+") == 0 || temp.compareTo("-") == 0 || temp.compareTo("*") == 0 || temp.compareTo("/") == 0){
                int a = num.pop();
                int b = num.pop();
                char op = temp.charAt(0);
                switch(op){
                case '+': num.push(b+a); break;
                case '-': num.push(b-a); break;
                case '*': num.push(b*a); break;
                case '/': num.push(b/a); break;
                }
            } else
                num.push(Integer.valueOf(temp));
        }
        return num.pop();
    }
}
