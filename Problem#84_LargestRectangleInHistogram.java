public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack();
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] > height[i]){
                int index = stack.pop();
                int right = i;
                int left = -1;
                if (!stack.isEmpty())
                    left = stack.peek();
                if (ans < (right - left - 1) * height[index])
                    ans = (right - left - 1) * height[index];
            } 
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int right = height.length;
            int index = stack.pop();
            int left = -1;
            if (!stack.isEmpty())
                left = stack.peek();
            if (ans < (right - left - 1) * height[index])
                ans = (right - left - 1) * height[index];
        }
        return ans;
    }
}
