public class Solution {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = 0;
        for (int i = 1; i < height.length; i++)
            left[i] = Integer.max(left[i-1], height[i-1]);
        
        right[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--)
            right[i] = Integer.max(right[i+1], height[i+1]);
        
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            int max = Integer.min(left[i], right[i]);
            if (max - height[i] > 0)
                ans += max - height[i];
        }
        return ans;
    }
}
