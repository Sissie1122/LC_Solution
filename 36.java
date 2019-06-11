//使用flag记下每行每列每个cube加入的数字
class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> record = new ArrayList<>();
        for(int i = 0; i < 27; i++){
            record.add(new HashSet<Character>());
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    
                    int rowIndex = i;
                    int colIndex = 9 + j;
                    int cubeIndex = i / 3 * 3 + j / 3 + 18;
                    if(record.get(rowIndex).contains(board[i][j]) || record.get(colIndex).contains(board[i][j]) 
                       || record.get(cubeIndex).contains(board[i][j])){
                        return false;
                    }
                    else{
                        record.get(rowIndex).add(board[i][j]);
                        record.get(colIndex).add(board[i][j]);
                        record.get(cubeIndex).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}