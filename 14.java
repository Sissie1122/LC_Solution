//使用字典树，并不是一个很快的方法， 4ms
class Solution {
    class Node{
        char val;
        HashMap<Character, Node> childMap = new HashMap<>();
        String word;
        Node(){};
        Node(char val){
            this.val = val;
        }
    }
    
    class Trie{
        Node root = new Node();
        public void add(String word){
            int size = word.length();
            if(size == 0){
                root.word = word;
                return;
            }
            Node cur = root;
            for(int i = 0; i < size; i++){
                char val = word.charAt(i);
                if(!cur.childMap.containsKey(val)){
                    cur.childMap.put(val, new Node(val));
                }
                cur = cur.childMap.get(val);
            }
            cur.word = word;
        }
        
        public String findPrefix(){
            StringBuilder ans = new StringBuilder();
            Node cur = root;
            while(cur.word == null && cur.childMap.size() == 1){
                if(cur != root){
                    ans.append(cur.val);    
                }
                
                cur = (Node)cur.childMap.values().toArray()[0];
            }
            if(cur != root){
                ans.append(cur.val);    
            }
            return ans.toString();
        }
        
    }
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if(size == 0){
            return "";
        }
        Trie myTree = new Trie();
        for(int i = 0; i < size; i++){
            myTree.add(strs[i]);
        }
        return myTree.findPrefix();
    }
}