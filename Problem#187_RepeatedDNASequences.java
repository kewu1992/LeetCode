public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n <= 10)
            return new LinkedList<String>();
        Map<Integer, Boolean> map = new HashMap();
        List<String> result = new LinkedList<String>();
        for (int i = 0; i < n-9; i++){
            int temp = 0;
            for (int j = 0; j < 10; j++){
                temp = temp << 2;
                switch(s.charAt(i+j)){
                case 'A': temp |= 0; break;
                case 'C': temp |= 1; break;
                case 'G': temp |= 2; break;
                case 'T': temp |= 3; break;
                }
            }
            if (map.containsKey(temp)){
                if (map.get(temp)){
                    map.put(temp, false);
                    result.add(s.substring(i, i+10));
                }
            } else
                map.put(temp, true);
        }
        return result;
    }
}
