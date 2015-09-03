public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int n = nums.length;
        int max = nums[0], min = nums[0];
        for (int i = 1; i < n; i++){
            min = Integer.min(min, nums[i]);
            max = Integer.max(max, nums[i]);
        }
        int smallestGap = (max - min + n-2) / (n-1);
        int[] minBucket = new int[n];
        int[] maxBucket = new int[n];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for (int num : nums){
            int index = (num - min) / smallestGap;
            minBucket[index] = Integer.min(minBucket[index], num);
            maxBucket[index] = Integer.max(maxBucket[index], num);
        }
        
        int ans = 0;
        int prev = min;
        
        for (int i = 0; i < n; i++){
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE)
                continue;
            ans = Integer.max(ans, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        
        ans = Integer.max(ans, max - prev);
        return ans;
    }
}
