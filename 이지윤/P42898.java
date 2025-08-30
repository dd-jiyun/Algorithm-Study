package 이지윤;

public class P42898 {
    private static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] blocked = new boolean[n + 1][m + 1];

        for (int[] p : puddles) {
            int x = p[1];
            int y = p[0];
            blocked[x][y] = true;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (blocked[i][j]) {
                    dp[i][j] = 0;
                } else {
                    if (i > 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if (j > 1) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        P42898 sol = new P42898();
        int[][] puddles = {{2, 2}};
        System.out.println(sol.solution(4, 3, puddles));
    }
}
