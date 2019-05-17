//注意只有当gap1或者gap2为0时会出现重复添加
class Solution {
    public String convert(String s, int numRows) {
        int size = s.length();
        if(size == 0 || size <= numRows || numRows <= 1){
            return s;
        }
        int gap1 = 2 * numRows - 2;
        int gap2 = 0;
        StringBuilder ans = new StringBuilder(); 
        for(int start = 0; start < numRows; start++){
            int p = start;
            while(p < size){
                ans.append(s.charAt(p));
                if(gap1 > 0 && gap2 > 0 && p + gap1 < size){
                    ans.append(s.charAt(p + gap1));
                }
                p += (gap1 + gap2);
            }
            gap1 -= 2;
            gap2 += 2;
        }
        return ans.toString();
    }
}