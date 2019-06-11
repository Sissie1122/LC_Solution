//用一个stack存储括号左半部分，不断用右半部分对括号进行抵消
class Solution {
    public boolean isValid(String ss) {
        Stack<Character> stack = new Stack<>();
        int size = ss.length();
        if(size == 0){
            return true;
        }
        char[] s = ss.toCharArray();
        for(int i = 0; i < size; i++){
            if(s[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
            else if(s[i] == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
            else if(s[i] == '}'){
                if(stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(s[i]);
            }
        }
        return stack.isEmpty();
    }
}