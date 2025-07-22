package 이지윤;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B15649 {
    static int n, m;
    static int[] result;
    static boolean[] used;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        result = new int[m];
        used = new boolean[n + 1];

        backtracking(0);
        bw.flush();
    }

    private static void backtracking(int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(result[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                result[depth] = i;
                backtracking(depth + 1);
                used[i] = false;
            }
        }
    }
}
