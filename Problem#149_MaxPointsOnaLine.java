/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0)
            return 0;
        Map<Double, Integer> map = new HashMap();
        int ans = 0, infSlope, sameCount;
        for (int i = 0; i < points.length; i++){
            map.clear();
            infSlope = 0;
            sameCount = 0;
            for (int j = 0; j < points.length; j++){
                if (points[i].x == points[j].x && points[i].y == points[j].y){
                    sameCount++;
                    continue;
                }
                if (points[i].x - points[j].x == 0)
                    infSlope++;
                else {
                    double slope = (points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                    if (map.containsKey(slope))
                        map.put(slope, map.get(slope) + 1);
                    else
                        map.put(slope, 1);
                }
            }
            for (int num : map.values())
                if (ans < num + sameCount)
                    ans = num + sameCount;
            if (ans < infSlope + sameCount)
                ans = infSlope + sameCount;
        }
        return ans;
    }
}
