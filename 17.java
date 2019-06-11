//简单的DFS
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        int size = digits.length();
        if(size == 0){
            return ans;
        }
        char[] s = digits.toCharArray();
        StringBuilder sol = new StringBuilder();
        dfs(ans, map, sol, s, 0, size);
        return ans;
        
    }
     private void dfs(List<String> ans, HashMap<Character, String> map, StringBuilder sol, 
                      char[] s, int index, int size){
         if(index == size){
             ans.add(sol.toString());
             return;
         }
         String candidates = map.get(s[index]);
         int len = candidates.length();
         for(int i = 0; i < len; i++){
             sol.append(candidates.charAt(i));
             dfs(ans, map, sol, s, index + 1, size);
             sol.deleteCharAt(sol.length() - 1);
         }
     }
    
}