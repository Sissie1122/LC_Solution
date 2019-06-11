//比较有难度的一道双指针题，首先注意map的更新
//其次就是出现错误单词时对end指针的处理
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        int wordNum = words.length;
        if(wordNum == 0){
            return ans;
        }
        int wordLen = words[0].length();
        int slen = s.length();
        if(slen < wordLen * wordNum){
            return ans;
        }
        HashMap<String, Integer> dict = new HashMap<>();
        for(int base = 0; base < wordLen; base++){
            //每次都需要更新map
            dict.clear();
            for(int i = 0; i < wordNum; i++){
                dict.put(words[i], dict.getOrDefault(words[i], 0) + 1);
            }
            int end = base;
            int cnt = 0;
            for(int start = base; start < slen; start = start + wordLen){
                while(end + wordLen <= slen){
                    String curWord = s.substring(end, end + wordLen);
                    if(dict.containsKey(curWord) && dict.get(curWord) > 0){
                        end += wordLen;
                        dict.put(curWord, dict.get(curWord) - 1);
                        cnt++;
                        if(cnt == wordNum){
                            ans.add(start);
                        }
                    }
                    else{
                        break;
                    }
                }
                //如果是dict中不存在的单词，在start指针消去完成后，需要手动把end指针跳过这个单词
                if(start == end){
                    end += wordLen;
                }
                else{
                    dict.put(s.substring(start, start + wordLen), dict.get(s.substring(start, start + wordLen)) + 1);
                    cnt--;
                }
            }
        }
        return ans;
    }
}