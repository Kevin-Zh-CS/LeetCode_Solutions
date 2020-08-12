package backtracking;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */

import java.util.ArrayList;
import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input N: ");
        int n = sc.nextInt();
        Queen queen = new Queen(n);
        queen.backtrack(0);
        System.out.println("There are "+queen.cnt+" solutions with "+n+"-Queen problem.");
    }
}

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
