//dp题
class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        for(int j = 0; j < plen + 1; j++){
            for(int i = 0; i < slen + 1; i++){
                if(j == 0){
                    dp[i][j] = (i == 0);
                    continue;
                }
                char x = p.charAt(j - 1);
                if(x == '.'){
                    dp[i][j] = (i != 0 && dp[i - 1][j - 1]);
                }
                else if(x == '*'){
                    dp[i][j] = (i == 0) ? dp[i][j - 2] : 
                        dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                }
                else{
                    dp[i][j] = (i != 0 && dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1));
                }
                
            }
            
        }
        return dp[slen][plen];
    }
}