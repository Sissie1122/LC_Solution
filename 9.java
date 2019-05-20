//不转化为string有两种方法：
//1.将这个integer完全翻转，计算反转前后是否完全相同，需要考虑overflow
//2.很clever的做法,翻转一半，不需要考虑overflow，但是对结尾是0的数字需要特判
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int rev_x = 0;
        while(rev_x < x ){
            rev_x = rev_x * 10 + x % 10;
            x /= 10;
        }
        return x == rev_x || x == rev_x / 10;
    }
}