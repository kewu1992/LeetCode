public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        LinkedList<Integer> deque = new LinkedList();
        for (int i = 0; i < k; i++){
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.removeLast();
            deque.addLast(i);
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++){
            if (i-k == deque.getFirst())
                deque.removeFirst();
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.removeLast();
            deque.addLast(i);
            ans[i-k+1] = nums[deque.getFirst()];
        }
        return ans;
    }
}
