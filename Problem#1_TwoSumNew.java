import java.util.Arrays;

public class Solution {
    class Element implements Comparable<Element>{
        int index;
        int value;
        public int compareTo(Element that){
            return Integer.compare(this.value, that.value);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Element[] elements = new Element[nums.length];
        for (int i = 0; i < nums.length; i++){
            elements[i] = new Element();
            elements[i].value = nums[i];
            elements[i].index = i;
        }
        Arrays.sort(elements);
        int l = 0, r = elements.length - 1;
        while (l < r){
            if (elements[l].value + elements[r].value == target){
                int ans[] = new int[2];
                if (elements[l].index < elements[r].index){
                    ans[0] = elements[l].index + 1;
                    ans[1] = elements[r].index + 1;
                } else {
                    ans[0] = elements[r].index + 1;
                    ans[1] = elements[l].index + 1;
                }
                return ans;
            } else if (elements[l].value + elements[r].value < target)
                l++;
            else
                r--;
        }
        return null;
    }

}
