import java.util.ArrayList;
import java.util.List;

/*
* N皇后问题，经典回溯剪枝问题了
* */

//public class Solution_51 {
//
//    public List<List<String>> res = new ArrayList<>();
//
//    public boolean isValid(int row, int col, char[][] used){
//        // 列上是否已经有皇后
//        for (int i = 0; i < row; i++){
//            if (used[i][col] == 'Q')
//                return false;
//        }
//        // 左对角线上是否有皇后
//        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
//            if (used[i][j] == 'Q')
//                return false;
//        }
//        // 右对角线上是否有皇后
//        for (int i = row - 1, j = col + 1; i >= 0 && j < used.length; i--, j++){
//            if (used[i][j] == 'Q')
//                return false;
//        }
//        return true;
//    }
//
//    public void DFS(int level, int n, char[][] used){
//        if (level == n){
//            List<String> list = new ArrayList<>();
//            for (int i = 0; i < n; i++){
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < n; j++){
//                    sb.append(used[i][j]);
//                }
//                list.add(sb.toString());
//            }
//            res.add(list);
//            return;
//        }
//
//        for (int i = 0; i < n; i++){
//            if (isValid(level, i, used)){
//                used[level][i] = 'Q';
//                DFS(level+1, n, used);
//                used[level][i] = '.';
//            }
//        }
//    }
//
//    public List<List<String>> solveQueens(int n){
//        char[][] used = new char[n][n];
//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < n; j++)
//                used[i][j] = '.';
//        DFS(0, n, used);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 51!\n");
//    }
//
//}

public class Solution_51 {

    public List<List<String>> res = new ArrayList<>();

    public boolean isValid(int row, int col, char[][] visited){

        for (int i = 0; i < row; i++)
            if (visited[i][col] == 'Q')
                return false;
        for (int i = row-1, j = col-1; i>=0&&j>=0; i--,j--)
            if (visited[i][j] == 'Q')
                return false;
        for (int i = row-1, j = col+1; i>=0&&j<visited.length; i--,j++)
            if (visited[i][j] == 'Q')
                return false;
        return true;
    }

    public void DFS(int level, char[][] visited){
        int n = visited.length;
        if (level == n){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++){
                    sb.append(visited[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++){
            if (isValid(level, i, visited)){
                visited[level][i] = 'Q';
                DFS(level+1, visited);
                visited[level][i] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n){
        char[][] visited = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                visited[i][j] = '.';
        DFS(0, visited);
        return res;
    }
}














