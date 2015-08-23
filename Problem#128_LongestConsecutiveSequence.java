public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap();
        int ans = 0;
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], true);
        Iterator<Integer> iterator = map.keySet().iterator();
        
        while (iterator.hasNext()){
            int index = iterator.next();
            if (map.get(index)){
                map.put(index, false);
                int len = 1;
                int up = index + 1;
                while (map.containsKey(up)){
                    map.put(up, false);
                    len++;
                    up++;
                }
                int down = index - 1;
                while (map.containsKey(down)){
                    map.put(down, false);
                    len++;
                    down--;
                }
                if (ans < len)
                    ans = len;
            }    
        }
        
        return ans;
    }
}
