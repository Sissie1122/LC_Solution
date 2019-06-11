//模仿判断valid parenthesis的方法，记录已经使用的‘（’ 和‘）’，以及抵消的‘（’
//用dfs
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        StringBuilder sol = new StringBuilder();
        dfs(ans, sol, n, 0, 0, 0);
        return ans;
    }
    
    private void dfs(List<String> ans, StringBuilder sol, int n,
                    int leftCnt, int curLeft, int rightCnt){
        if(leftCnt == n && rightCnt == n){
            ans.add(sol.toString());
            return;
        }
		//是否允许sol中添加'('字符
        if(leftCnt < n){
            sol.append('(');
            dfs(ans, sol, n, leftCnt + 1, curLeft + 1, rightCnt);
            sol.deleteCharAt(sol.length() - 1);
        }
		//是否允许sol中添加‘）’字符
        if(rightCnt < n && curLeft > 0){
            sol.append(')');
            dfs(ans, sol, n, leftCnt, curLeft - 1, rightCnt + 1);
            sol.deleteCharAt(sol.length() - 1);
        }
    }
}