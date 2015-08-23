public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> now = new LinkedList();
        if (rowIndex == -1)
            return now;
        now.add(1);
        if (rowIndex == 0)
            return now;
        List<Integer> last = now;
        
        for (int i = 1; i <= rowIndex; i++){
            now = new LinkedList();
            now.add(1);
            for (int j = 0; j < last.size()-1; j++)
                now.add(last.get(j) + last.get(j+1));
            now.add(1);
            last = now;
        }
        
        return now;
    }
}
