//难度不大，在于怎么写的简洁
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        long dividendl = Math.abs((long)dividend);
        long divisorl = Math.abs((long)divisor);
        long ans = 0;
        while(divisorl <= dividendl){
            long shift = 1;
            long tmp = divisorl;
            while((tmp << 1) <= dividendl){
                shift <<= 1;
                tmp <<= 1;
            }
            ans += shift;
            dividendl -= tmp;
            if(sign == 1 && ans >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && -ans <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return sign * (int)ans;
    }
}