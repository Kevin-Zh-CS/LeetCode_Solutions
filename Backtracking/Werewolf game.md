## Werewolf game

* This is the hard version of werewolf game, whose number of liars is self-defined.

>Werewolf（狼人杀） is a game in which the players are partitioned into two parties: the werewolves and the human beings. Suppose that in a game,
>
>- player #1 said: "Player #2 is a werewolf.";
>- player #2 said: "Player #3 is a human.";
>- player #3 said: "Player #4 is a werewolf.";
>- player #4 said: "Player #5 is a human."; and
>- player #5 said: "Player #4 is a human.".
>
>Given that there were 2 werewolves among them, at least one but not all the werewolves were lying, and there were exactly 2 liars. Can you point out the werewolves?
>
>Now you are asked to solve a harder version of this problem: given that there were N players, with M werewolves among them, at least one but not all the werewolves were lying, and there were exactly L liars. You are supposed to point out the werewolves.
>
>### Input Specification:
>
>Each input file contains one test case. For each case, the first line gives three positive integer N (5 ≤ N ≤ 100), M and L (2 ≤ M，L < N). Then N lines follow and the i-th line gives the statement of the i-th player (1 ≤ i ≤ N), which is represented by the index of the player with a positive sign for a human and a negative sign for a werewolf.
>
>### Output Specification:
>
>If a solution exists, print in a line in descending order the indices of the M werewolves. The numbers must be separated by exactly one space with no extra spaces at the beginning or the end of the line. If there are more than one solution, you must output the largest solution sequence -- that is, for two sequences A = { a[1], ..., a[M] } and B = { b[1], ..., b[M] }, if there exists 0 ≤ k < M such that a[i] = b[i] (i ≤ k) and a[k+1]>b[k+1], then A is said to be larger than B. In case there is no solution, simply print `No Solution`.
>
>### Sample Input 1:
>
>```in
>5 2 2
>-2
>+3
>-4
>+5
>+4    
>```
>
>### Sample Output 1:
>
>```out
>4 1    
>```
>
>### Sample Input 2:
>
>```in
>6 2 3
>-2
>+3
>-4
>+5
>+4
>-3    
>```
>
>### Sample Output 2:
>
>```out
>6 4    
>```
>
>### Sample Input 3:
>
>```in
>6 2 5
>-2
>+3
>-4
>+5
>+4
>+6          
>```
>
>### Sample Output 3:
>
>```out
>No Solution
>```



Here is my solution with Java, and this solution applies the [aforementioned template](https://github.com/Kevin-Zh-CS/LeetCode_Solutions/blob/master/Backtracking/Backtracking%20algorithm%20summary.md).

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int[] record = new int[101];
    private static boolean solved = false;
    private static boolean[] IsWolf = new boolean[101];
    private static ArrayList<Integer> WolfList = new ArrayList<>();
    private static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            IsWolf[i] = false;
        }
        for (int i = 1; i <= N; i++) {
            record[i] = sc.nextInt();
        }


        backtrack(WolfList, record, N, M, L);

        if (!solved) {
            System.out.println("No Solution");
        } else {
            System.out.print(ans.get(0));
            for (int i = 1; i < ans.size(); i++) {
                System.out.print(" " + ans.get(i));
            }
        }
    }

    static void backtrack(ArrayList<Integer> WolfList, int[] record, int level, int wolves, int liars) {
        if (solved) {
            return;
        }
        if (WolfList.size() == wolves) {
            if (check(record, wolves, liars)) {
                solved = true;
                ans.addAll(WolfList);
                return;
            }
        }
        if (WolfList.size() > wolves || level == 0) {
            return;
        }
        for (int i = level; i > 0; i--) {
            WolfList.add(i);
            IsWolf[i] = true;
            backtrack(WolfList, record, i - 1, wolves, liars);
            IsWolf[i] = false;
            WolfList.remove(WolfList.size() - 1);
        }


    }

    static boolean check(int[] record, int wolves, int liars) {
        int WolfCount = 0, liarCount = 0;
        boolean flag = false;
        for (int i = 1; i <= 100; i++) {
            if ((IsWolf[Math.abs(record[i])] && record[i] > 0) || (!IsWolf[Math.abs(record[i])] && record[i] < 0)) {
                liarCount++;
                if (IsWolf[i]) {
                    WolfCount++;
                }
            }
        }
        if (liarCount == liars && WolfCount != wolves && WolfCount > 0) {
            flag = true;
        }
        return flag;
    }
}
```
