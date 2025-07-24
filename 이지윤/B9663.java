package 이지윤;

import java.util.Scanner;

public class B9663 {
    static int n, count;
    static boolean[] cols;
    static boolean[] rightDownDiagonal;
    static boolean[] leftDownDiagonal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        cols = new boolean[n];
        rightDownDiagonal = new boolean[2 * n];
        leftDownDiagonal = new boolean[2 * n];

        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int rightDiagIdx = row + col;
            int leftDiagIdx = row - col + n;

            if (cols[col] || rightDownDiagonal[rightDiagIdx] || leftDownDiagonal[leftDiagIdx]) {
                continue;
            }

            cols[col] = true;
            rightDownDiagonal[rightDiagIdx] = true;
            leftDownDiagonal[leftDiagIdx] = true;

            backtracking(row + 1);

            cols[col] = false;
            rightDownDiagonal[rightDiagIdx] = false;
            leftDownDiagonal[leftDiagIdx] = false;
        }
    }
}
