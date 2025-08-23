package 이지윤;

import java.io.*;
import java.util.*;

public class B1256 {
    private static final int MAX_K = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(MAX_K, dp[i - 1][j] + dp[i][j - 1]);
                }
            }
        }

        if (dp[n][m] < k) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0 || m > 0) {
            if (n == 0) {
                sb.append('z');
                m--;
            } else if (m == 0) {
                sb.append('a');
                n--;
            } else {
                if (dp[n - 1][m] >= k) {
                    sb.append('a');
                    n--;
                } else {
                    sb.append('z');
                    k -= dp[n - 1][m];
                    m--;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
