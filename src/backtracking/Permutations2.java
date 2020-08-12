package backtracking;
/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutations2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //要先排序，为了后面去重
        Arrays.sort(nums);
        //完全与Permutations I一致
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Backtrack(nums, list, visited, 0);
        return res;
    }
    void Backtrack(int[] nums, ArrayList<Integer> list, boolean[] visited, int level) {
        //终止条件
        if (level == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        //必须有的for循环
        for (int i = 0; i < nums.length; i++) {
            //跳过的情形
            if (visited[i]) {
                continue;
            }
            //去重，需跳过
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            //做出选择
            list.add(nums[i]);
            visited[i] = true;
            //进入下一层
            Backtrack(nums, list, visited, level + 1);
            //撤销选择
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
