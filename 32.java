//首先明确valid Parentheses的结尾一定是')'，因此在每次遇到')'时，判断以此')'结尾的valid parenthese有多长
class Solution {
    public int longestValidParentheses(String ss) {
        int size = ss.length();
        if(size == 0){
            return 0;
        }
        char[] s = ss.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int lastIndex = -1;
        for(int i = 0; i < size; i++){
            if(s[i] == '('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    lastIndex = i;
                }
                else{
                    stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - lastIndex) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}