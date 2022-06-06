/*
* 将N皇后问题的记录变为计数，反而更加简单了
* */

public class Solution_52 {

    public int counts = 0;

    boolean isValid(int row, int col, boolean[][] visited){
        for (int i = 0; i < row; i++)
            if (visited[i][col])
                return false;
        for (int i = row-1, j = col-1; i>=0&&j>=0; i--,j--)
            if (visited[i][j])
                return false;
        for (int i = row-1, j = col+1; i>=0&&j<visited.length; i--,j++)
            if (visited[i][j])
                return false;
        return true;
    }

    public void DFS(int level, int n, boolean[][] visited){
        if (level == n){
            counts++;
            return;
        }
        for (int i = 0; i < n; i++){
            if (isValid(level, i, visited)){
                visited[level][i] = true;
                DFS(level+1, n, visited);
                visited[level][i] = false;
            }
        }
    }

    public int totalNQueens(int n){
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                visited[i][j] = false;
        DFS(0, n, visited);
        return counts;
    }
}
