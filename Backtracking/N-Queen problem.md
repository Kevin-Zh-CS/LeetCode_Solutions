## N-Queen problem

​		The N-Queen problem is a classic backtracking algorithm problem. The rule is that there are N queens on an N × N chessboard. They cannot be in the same row, in the same column, or on the same diagonal. 

​		The following is my code(written with Java), you need to enter the value of N, it should be greater than 2 (otherwise there is no solution), then each line will output N values, assuming that the k-th value from left to right is x, which represents the k-th The x column is the queen.

```java
//By Kevin Zhang
import java.util.ArrayList;
import java.util.Scanner;

class Queen {
    int n;
    int cnt = 0;
    ArrayList<Integer> list = new ArrayList<>();

    public Queen(int n) {
        this.n = n;
    }

    boolean check(int level) {
        for (int i = 0; i < level; i++) {
            if (list.get(level) == list.get(i)) {
                return false;
            }
            if (Math.abs(list.get(i) - list.get(level)) == level - i) {
                return false;
            }
        }
        return true;
    }

    void backtrack(int level) {
        if (level > n) {
            return;
        }
        if (level == n) {
            cnt++;
            System.out.print("["+list.get(0));
            for (int i = 1; i < list.size(); i++) {
                System.out.print(","+list.get(i));
            }
            System.out.println("]");
            return;
        }

        for (int i = 0; i < n; i++) {
            list.add(i);
            if (!check(level)) {
                list.remove(list.size() - 1);
                continue;
            }
            backtrack(level + 1);
            list.remove(list.size() - 1);
        }
    }
}


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = sc.nextInt();
        Queen queen = new Queen(n);
        queen.backtrack(0);
        System.out.println("There are "+queen.cnt+" solutions with "+n+"-Queen problem.");
    }
}
```

if the input is 8, the following is the output of the program.

```out
[0,4,7,5,2,6,1,3]
[0,5,7,2,6,3,1,4]
[0,6,3,5,7,1,4,2]
[0,6,4,7,1,3,5,2]
[1,3,5,7,2,0,6,4]
[1,4,6,0,2,7,5,3]
[1,4,6,3,0,7,5,2]
[1,5,0,6,3,7,2,4]
[1,5,7,2,0,3,6,4]
[1,6,2,5,7,4,0,3]
[1,6,4,7,0,3,5,2]
[1,7,5,0,2,4,6,3]
[2,0,6,4,7,1,3,5]
[2,4,1,7,0,6,3,5]
[2,4,1,7,5,3,6,0]
[2,4,6,0,3,1,7,5]
[2,4,7,3,0,6,1,5]
[2,5,1,4,7,0,6,3]
[2,5,1,6,0,3,7,4]
[2,5,1,6,4,0,7,3]
[2,5,3,0,7,4,6,1]
[2,5,3,1,7,4,6,0]
[2,5,7,0,3,6,4,1]
[2,5,7,0,4,6,1,3]
[2,5,7,1,3,0,6,4]
[2,6,1,7,4,0,3,5]
[2,6,1,7,5,3,0,4]
[2,7,3,6,0,5,1,4]
[3,0,4,7,1,6,2,5]
[3,0,4,7,5,2,6,1]
[3,1,4,7,5,0,2,6]
[3,1,6,2,5,7,0,4]
[3,1,6,2,5,7,4,0]
[3,1,6,4,0,7,5,2]
[3,1,7,4,6,0,2,5]
[3,1,7,5,0,2,4,6]
[3,5,0,4,1,7,2,6]
[3,5,7,1,6,0,2,4]
[3,5,7,2,0,6,4,1]
[3,6,0,7,4,1,5,2]
[3,6,2,7,1,4,0,5]
[3,6,4,1,5,0,2,7]
[3,6,4,2,0,5,7,1]
[3,7,0,2,5,1,6,4]
[3,7,0,4,6,1,5,2]
[3,7,4,2,0,6,1,5]
[4,0,3,5,7,1,6,2]
[4,0,7,3,1,6,2,5]
[4,0,7,5,2,6,1,3]
[4,1,3,5,7,2,0,6]
[4,1,3,6,2,7,5,0]
[4,1,5,0,6,3,7,2]
[4,1,7,0,3,6,2,5]
[4,2,0,5,7,1,3,6]
[4,2,0,6,1,7,5,3]
[4,2,7,3,6,0,5,1]
[4,6,0,2,7,5,3,1]
[4,6,0,3,1,7,5,2]
[4,6,1,3,7,0,2,5]
[4,6,1,5,2,0,3,7]
[4,6,1,5,2,0,7,3]
[4,6,3,0,2,7,5,1]
[4,7,3,0,2,5,1,6]
[4,7,3,0,6,1,5,2]
[5,0,4,1,7,2,6,3]
[5,1,6,0,2,4,7,3]
[5,1,6,0,3,7,4,2]
[5,2,0,6,4,7,1,3]
[5,2,0,7,3,1,6,4]
[5,2,0,7,4,1,3,6]
[5,2,4,6,0,3,1,7]
[5,2,4,7,0,3,1,6]
[5,2,6,1,3,7,0,4]
[5,2,6,1,7,4,0,3]
[5,2,6,3,0,7,1,4]
[5,3,0,4,7,1,6,2]
[5,3,1,7,4,6,0,2]
[5,3,6,0,2,4,1,7]
[5,3,6,0,7,1,4,2]
[5,7,1,3,0,6,4,2]
[6,0,2,7,5,3,1,4]
[6,1,3,0,7,4,2,5]
[6,1,5,2,0,3,7,4]
[6,2,0,5,7,4,1,3]
[6,2,7,1,4,0,5,3]
[6,3,1,4,7,0,2,5]
[6,3,1,7,5,0,2,4]
[6,4,2,0,5,7,1,3]
[7,1,3,0,6,4,2,5]
[7,1,4,2,0,6,3,5]
[7,2,0,5,1,4,6,3]
[7,3,0,2,5,1,6,4]
There are 92 solutions with 8-Queen problem.
```

