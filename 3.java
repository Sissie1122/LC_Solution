//双指针题
class Solution {
	public int lengthOfLongestSubstring(String ss) {
        int size = ss.length();
        if(size == 0){
            return 0;
        }
        char[] s = ss.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int end = 0;
        int res = 0;
        for(int start = 0; start < size; start++){
            while(end < size){
                if(!map.containsKey(s[end])){
                    map.put(s[end], map.getOrDefault(s[end], 0) + 1);
                    end++;
                    res = Math.max(res, end - start);
                }
                else{
                    break;
                }
            }
            if(end == size){
                break;
            }
            map.put(s[start], map.get(s[start]) - 1);
            if(map.get(s[start]) == 0){
                map.remove(s[start]);
            }
        }
        return res;
    }
}