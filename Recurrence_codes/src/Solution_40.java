import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_40 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();

    public void DFS(int[] candidates, int target, int startIndex, int sum){
        if (sum > target)
            return;
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++){
            if (i > startIndex && candidates[i - 1] == candidates[i])
                continue;
            list.add(candidates[i]);
            DFS(candidates, target, i + 1, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        DFS(candidates, target, 0, 0);
        return res;
    }
}
