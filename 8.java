//string转int，还是精度问题，注意是否超出Integer范围，边转化就要边判断
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int size = str.length();
        if(size == 0){
            return 0;
        }
        char[] s = str.toCharArray();
        int index = 0;
        int sign = 1;
        long ans = 0;
        if(s[0] == '+' || s[0] == '-'){
            index++;
            sign = s[0] == '-' ? -1 : 1;
        }
        while(index < size && s[index] >= '0' && s[index] <= '9'){
            ans = ans * 10 + s[index] - '0';
            if(sign == 1 && ans > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && -ans < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return sign * (int)ans;
    }
}