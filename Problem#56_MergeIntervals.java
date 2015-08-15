/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class WrapInterval implements Comparable<WrapInterval>{
        Interval value;
        public int compareTo(WrapInterval other){
            return Integer.compare(this.value.start, other.value.start);
        }
        WrapInterval(Interval v){
            this.value = v;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0)
            return new LinkedList<Interval>();
        WrapInterval[] array = new WrapInterval[intervals.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = new WrapInterval(intervals.get(i));
        Arrays.sort(array);
        List<Interval> ans = new LinkedList<Interval>();
        Interval now = array[0].value;
        for (int i = 1; i < array.length; i++){
            Interval temp = mergeTwoIntervals(now, array[i].value);
            if (temp == null){
                ans.add(now);
                now = array[i].value;
            }
            else 
                now = temp;
        }
        ans.add(now);
        return ans;
    }
    private Interval mergeTwoIntervals(Interval i1, Interval i2){
        if (i2.start <= i1.end){
            if (i2.end > i1.end)
                return new Interval(i1.start, i2.end);
            else
                return new Interval(i1.start, i1.end);
        }
        else
            return null;
    }
}
