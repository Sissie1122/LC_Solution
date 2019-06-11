//dfs题
class Solution {
    public void solveSudoku(char[][] board) {
        List<HashSet<Character>> record = new ArrayList<HashSet<Character>>();
        for(int i = 0; i < 27; i++){
            record.add(new HashSet<Character>());
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    mark(record, board[i][j], i, j, true);
                }
            }
        }
        dfs(board, record, 0, 0);
    }
    
    private boolean check(List<HashSet<Character>> record, char x, int i, int j){
        int rowIndex = i;
        int colIndex = 9 + j;
        int cubeIndex = i / 3 * 3 + j / 3 + 18;
        return record.get(rowIndex).contains(x) || record.get(colIndex).contains(x) || record.get(cubeIndex).contains(x);
    }
    
    private void mark(List<HashSet<Character>> record, char x, int i, int j, boolean isAdd){
        int rowIndex = i;
        int colIndex = 9 + j;
        int cubeIndex = i / 3 * 3 + j / 3 + 18;
        if(isAdd){
            record.get(rowIndex).add(x);
            record.get(colIndex).add(x);
            record.get(cubeIndex).add(x);
        }
        else{
            record.get(rowIndex).remove(x);
            record.get(colIndex).remove(x);
            record.get(cubeIndex).remove(x);
        }
        
    }
    
    private boolean dfs(char[][] board, List<HashSet<Character>> record, int i, int j){
        if(i == 9){
            return true;
        }
        int next_i = j + 1 == 9 ? i + 1 : i;
        int next_j = (j + 1) % 9;
        if(board[i][j] != '.'){
            return dfs(board, record, next_i, next_j);
        }
        for(char x = '1'; x <= '9'; x++){
            if(!check(record, x, i, j)){
                mark(record, x, i, j, true);
                board[i][j] = x;
                if(dfs(board, record, next_i, next_j)){
                    return true;    
                }
                board[i][j] = '.';
                mark(record, x, i, j, false);
            }
        }
        return false;
    }
}