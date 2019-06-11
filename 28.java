//题目简单，主要是写法要简洁
class Solution {
    public int strStr(String haystack, String needle) {
        int nlen = needle.length();
        if(nlen == 0){
            return 0;
        }
        int hlen = haystack.length();
        for(int i = 0; i < hlen - nlen + 1; i++){
            for(int j = 0; ; j++){
                if(j == nlen){
                    return i;
                }
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            
        }
        return -1;
    }
}