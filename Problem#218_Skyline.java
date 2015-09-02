public class Solution {
    private class Element implements Comparable<Element>{
        int x, h;
        boolean isLeft;
        Element(int x, int h, boolean isLeft){
            this.x = x;
            this.h = h;
            this.isLeft = isLeft;
        }
        
        public int compareTo(Element other){
            return (this.x < other.x) ? -1 : 1;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        int n = buildings.length;
        Element[] points = new Element[2*n];
        for (int i = 0; i < n; i++){
            points[2*i] = new Element(buildings[i][0], buildings[i][2], true);
            points[2*i+1] = new Element(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(points);
        
        List<int[]> ans = new LinkedList();
        TreeMap<Integer, Integer> tree = new TreeMap();
        int i = 0;
        while (i < 2*n){
            int j = i;
            while (j < 2*n && points[j].x == points[i].x) {
                if (points[j].isLeft) {
                    if (!tree.containsKey(points[j].h))
                        tree.put(points[j].h, 1);
                    else
                        tree.put(points[j].h, tree.get(points[j].h) + 1);
                } else {
                    tree.put(points[j].h, tree.get(points[j].h) - 1);
                    if (tree.get(points[j].h) == 0)
                        tree.remove(points[j].h);
                }
                j++;
            }
            int height = (tree.size() == 0) ? 0 : tree.lastKey();
            if (ans.size() == 0 || ans.get(ans.size()-1)[1] != height)
                 ans.add(new int[] {points[i].x, height});
            i = j;
        }
        
        return ans;
    }
}
