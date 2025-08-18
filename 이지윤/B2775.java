package 이지윤;

import java.io.*;

public class B2775 {
    static long comb(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(comb(n + k, k + 1)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
