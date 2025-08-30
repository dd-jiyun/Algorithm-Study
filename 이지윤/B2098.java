package 이지윤;

import java.io.*;
import java.util.*;

public class B2098 {
    static final int INF = 1_000_000_000;
    static int n;
    static int[][] w;
    static int[][] dp;

    static int tsp(int current, int visited) {
        if (visited == (1 << n) - 1) {
            return w[current][0] != 0 ? w[current][0] : INF;
        }
        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        int minCost = INF;
        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) == 0 && w[current][next] != 0) {
                minCost = Math.min(minCost, w[current][next] + tsp(next, visited | (1 << next)));
            }
        }
        return dp[current][visited] = minCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
        br.close();
    }
}
