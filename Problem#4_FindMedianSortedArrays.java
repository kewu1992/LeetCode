import java.util.HashSet;
import java.util.Set;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            int[] nums;
            if (nums1.length == 0){
                nums = nums2;
            } else
                nums = nums1;
            int n = nums.length;
            if (n % 2 == 0)
                return ((nums[n / 2 - 1] + nums[n / 2]) / 2.0);
            else
                return nums[n / 2];
        }

        int n = nums1.length + nums2.length;
        if (n % 2 == 0){
            int m1 = findMedian(n / 2 - 1, nums1, nums2);
            int m2 = findMedian(n / 2, nums1, nums2);
            return (m1 + m2) / 2.0;
        } else {
            return findMedian(n / 2, nums1, nums2);
        }
    }

    private int findMedian(int left, int[] nums1, int[] nums2){ // left is how many numbers should be at left
        int l = 0, r = nums1.length - 1;

        while (l <= r){
            int m = (l + r) / 2;
            if (left < m) {
                r = m - 1;
                continue;
            }
            if ((nums1.length + nums2.length - 1 - left) < (nums1.length - 1 - m)) {
                l = m + 1;
                continue;
            }
            int flag = lookUp(nums1[m], nums2, left - m);   //  m is the # of nums at the left of nums1[m] in nums1
            if (flag == 0)
                return nums1[m];
            else if (flag == 1)
                r = m - 1;
            else
                l = m + 1;
        }

        l = 0;
        r = nums2.length - 1;
        while (l <= r){
            int m = (l + r) / 2;
            if (left < m) {  // m is too big
                r = m - 1;
                continue;
            }
            if ((nums1.length + nums2.length - 1 - left) < (nums2.length - 1 - m)) { // m is too small
                l = m + 1;
                continue;
            }
            int flag = lookUp(nums2[m], nums1, left - m);
            if (flag == 0)
                return nums2[m];
            else if (flag == 1)
                r = m - 1;
            else
                l = m + 1;
        }

        return 0;   // should never reach here
    }

    private int lookUp(int target, int[] nums, int left){
        if (left == 0) {
            if (target <= nums[0])
                return 0;
            else
                return 1;   // bigger
        } else if (left == nums.length){
            if (target >= nums[nums.length - 1])
                return 0;
            else
                return -1;  // smaller
        } else {
            if (nums[left - 1] <= target && target <= nums[left])
                return 0;
            else if (target < nums[left - 1])
                return -1;
            else
                return 1;
        }
    }

}
