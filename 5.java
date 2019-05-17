//这个方法很笨，DP判断每个字串是不是palindromic，耗时长
class Solution {
    public String longestPalindrome(String ss) {
        int size = ss.length();
        if(size == 0){
            return "";
        }
        char[] s = ss.toCharArray();
        boolean[][] isPal = new boolean[size][size];
        int start = 0;
        int end = 0;
        for(int axis = 0; axis < size; axis++){
            int i = axis;
            int j = axis;
            isPal[i][j] = true;
            i--;
            j++;
            while(i >= 0 && j < size){
                isPal[i][j] = isPal[i + 1][j - 1] && s[i] == s[j];
                if(isPal[i][j] && j - i > end - start){
                    start = i;
                    end = j;
                }
                
                i--;
                j++;
            }
        }
        for(int axis = 0; axis < size - 1; axis++){
            int i = axis;
            int j = axis + 1;
            isPal[i][j] = s[i] == s[j];
            if(isPal[i][j] && j - i > end - start){
                    start = i;
                    end = j;
            }
            i--;
            j++;
            while(i >= 0 && j < size){
                isPal[i][j] = isPal[i + 1][j - 1] && s[i] == s[j];
                if(isPal[i][j] && j - i > end - start){
                    start = i;
                    end = j;
                }
                i--;
                j++;
            }
        }
        return ss.substring(start, end + 1);
    }
}