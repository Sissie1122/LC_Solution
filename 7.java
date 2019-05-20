//反转Integer，注意负数，反转过后超出Integer范围等特殊情况
class Solution {
    public int reverse(int x) {
        long ans = 0;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while(x > 0){
            ans = ans * 10 + x % 10;
            if(sign == 1 && ans > Integer.MAX_VALUE){
                return 0;
            }
            if(sign == -1 && -ans < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)ans * sign;
    }
}