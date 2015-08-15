import  java.util.*;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new LinkedList<Interval>();
        if (intervals.size() == 0){
            ans.add(newInterval);
            return ans;
        }

        if (newInterval.end < intervals.get(0).start){
            ans.add(newInterval);
            for (int i = 0; i < intervals.size(); i++)
                ans.add(intervals.get(i));
            return ans;
        }
        if (intervals.get(intervals.size()-1).end < newInterval.start){
           for (int i = 0; i < intervals.size(); i++)
                ans.add(intervals.get(i));
            ans.add(newInterval);
            return ans;
        }

        boolean isCross = false;
        for (int i = 0; i < intervals.size(); i++)
            if (mergeTwoIntervals(intervals.get(i), newInterval) != null){
                isCross = true;
                break;
            }
        if (!isCross){
            for (int i = 0; i < intervals.size()-1; i++){
                ans.add(intervals.get(i));
                if (intervals.get(i).start < newInterval.start && newInterval.start < intervals.get(i+1).start)
                    ans.add(newInterval);
            }
            ans.add(intervals.get(intervals.size()-1));
            return ans;
        }

        int isMerging = 0;
        for (int i = 0; i < intervals.size(); i++)
            if (isMerging == 0){
                Interval temp = mergeTwoIntervals(intervals.get(i), newInterval);
                if (temp == null)
                    ans.add(intervals.get(i));
                else {
                    ans.add(temp);
                    isMerging = 1;
                }
            } else if (isMerging == 1){
                Interval temp = mergeTwoIntervals(intervals.get(i), ans.get(ans.size()-1));
                if (temp == null){
                    ans.add(intervals.get(i));
                    isMerging = 2;
                } else
                    ans.set(ans.size()-1, temp);
            } else {
                ans.add(intervals.get(i));
            }
        return ans;
    }
    private Interval mergeTwoIntervals(Interval i1, Interval i2){
        if (i1.start > i2.start){
            Interval temp = i1;
            i1 = i2;
            i2 = temp;
        }

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
