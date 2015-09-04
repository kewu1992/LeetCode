public class Solution {
    class Element implements Comparable<Element>{
        public int value;
        Element(int val){
            value = val;
        }
        @Override
        public int compareTo(Element other){
            /*
            int a = this.value;
            int b = other.value;
            if (a == b)
                return 1;
            ArrayList<Integer> s1 = new ArrayList();
            ArrayList<Integer> s2 = new ArrayList();
            while (a > 0){
                s1.add(a % 10);
                a = a / 10;
            }
            while (b > 0){
                s2.add(b % 10);
                b = b / 10;
            }
            int n1 = s1.size(), n2 = s2.size();
            if (n1 == 0)
                return -1;
            if (n2 == 0)
                return 1;
            int i = n1-1, j = n2-1;
            while (true) {
                if (s1.get(i) > s2.get(j))
                    return 1;
                else if (s1.get(i) < s2.get(j))
                    return -1;
                else {
                    i = (i - 1 + n1) % n1;
                    j = (j - 1 + n2) % n2;
                    if (i == n1-1 && j == n2-1)
                        break;
                }
            }
            return 1;
            */
            
            String a = String.valueOf(this.value);
            String b = String.valueOf(other.value);
            return (a+b).compareTo(b+a);
        }
    }
    
    public String largestNumber(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return "";
        Element[] Nums = new Element[n];
        for (int i = 0; i < n; i++)
            Nums[i] = new Element(nums[i]);
        Arrays.sort(Nums);
        StringBuilder ans = new StringBuilder();
        if (Nums[n-1].value == 0)
            return "0";
        for (int i = n-1; i >= 0; i--)
            ans.append(String.valueOf(Nums[i].value));
        return ans.toString();
    }
}
