public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0)
            return -1;
        else if (gas.length == 1){
            if (gas[0] >= cost[0]) 
                return 0;
            else
                return -1;
        }
        int n = gas.length;
        int start = 0, end = 1, remain = gas[0] - cost[0];
        while (start != end){
            while (start != end && remain >= 0){
                remain += gas[end] - cost[end];
                end = (end + 1) % n;
            }
            while (start != end && remain < 0){
                start = (start + n - 1) % n;
                remain += gas[start] - cost[start];
            }
        }
        if (remain >= 0)
            return start;
        else
            return -1;
    }
}
