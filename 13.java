//方法一，先判断是否是复合数字，不成立的情况下再分别进行相加
class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        dict.put("I", 1);
        dict.put("V", 5);
        dict.put("X", 10);
        dict.put("L", 50);
        dict.put("C", 100);
        dict.put("D", 500);
        dict.put("M", 1000);
        dict.put("IV", 4);
        dict.put("IX", 9);
        dict.put("XL", 40);
        dict.put("XC", 90);
        dict.put("CD", 400);
        dict.put("CM", 900);
        int size = s.length();
        int index = 0;
        int res = 0;
        while(index < size){
            if(index == size - 1){
                res += dict.get(s.substring(index, index + 1));
                index++;
                break;
            }
            if(dict.containsKey(s.substring(index, index + 2))){
                res += dict.get(s.substring(index, index + 2));
                index += 2;
            }
            else{
                res += dict.get(s.substring(index, index + 1));
                index++;
            }
            
        }
        return res;
    }
}

//方法二：只有在出现复合数字的情况下才会后面字母对应的值比前面一个大
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        int size = s.length();
        //int index = 0;
        int last = Integer.MAX_VALUE;
        int res = 0;
        for(int index = 0; index < size; index++){
            int cur = dict.get(s.charAt(index));
            if(last < cur){
                res = res - 2 * last + cur;
            }
            else{
                res += cur;
            }
            last = cur;
        }
        return res;
    }
}