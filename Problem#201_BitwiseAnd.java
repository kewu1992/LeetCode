public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int temp = n - m;
        if (temp == 0)
            return m;
        int pos = 0;
        while ((temp & (1 << 31)) == 0){
            temp = temp << 1;
            pos++;
        }
        int mask = -1 << (32 - pos);
        return m & n & mask;
    }
}
