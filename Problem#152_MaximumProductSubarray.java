public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        product[0] = nums[0];
        for (int i = 1; i < n; i++)
            if (product[i-1] != 0)
                product[i] = product[i-1] * nums[i];
            else
                product[i] = nums[i];
        int i = n-1;
        while (i >= 0){
            while (i >= 0 && product[i] == 0)   
                i--;
            i--;
            while (i >= 0 && product[i] != 0) {
                product[i] = product[i+1];
                i--;
            }
        }
        int ans = product[0];
        for (i = 0; i < n; i++)
            ans = Integer.max(ans, product[i]);
        
        i = 0;
        while (i < n){
            while (i < n && product[i] == 0)    i++;
            if (i < n){
                if (product[i] < 0) {
                    int temp = product[i];
                    while (temp < 0){
                        temp /= nums[i];
                        i++;
                    }
                    if (!(temp == 1 && (i >= n || product[i] == 0)))
                        ans = Integer.max(ans, temp);
                }
            }
            while (i < n && product[i] != 0)    i++;
        }
        
        i = n-1;
        while (i >= 0){
            while (i >= 0 && product[i] == 0)   i--;
            if (i >= 0){
                if (product[i] < 0) {
                    int temp = product[i];
                    while (temp < 0){
                        temp /= nums[i];
                        i--;
                    }
                    if (!(temp == 1 && (i < 0 || product[i] == 0)))
                        ans = Integer.max(ans, temp);
                }
            }
            while (i >= 0 && product[i] != 0)   i--;
        }
        return ans;
    }
}
