//关键点在于使用了TreeMap
class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> dict = new TreeMap<>();
        dict.put(1, "I");
        dict.put(5, "V");
        dict.put(10, "X");
        dict.put(50, "L");
        dict.put(100, "C");
        dict.put(500, "D");
        dict.put(1000, "M");
        dict.put(4, "IV");
        dict.put(9, "IX");
        dict.put(40, "XL");
        dict.put(90, "XC");
        dict.put(400, "CD");
        dict.put(900, "CM");
        StringBuilder ans = new StringBuilder();
        while(num > 0){
            int key = dict.floorKey(num);
            ans.append(dict.get(key));
            num -= key;
        }
        return ans.toString();
    }
}