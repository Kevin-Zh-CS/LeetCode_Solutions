## Permutations I

* <font face="微软雅黑" size = 4>全排列是一种非常经典的Backtrack问题</font>

```
Example
Input: [1,2,3]
Output:[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

```java
package Permrutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
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

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().permute(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
```
