package 강민혁;

import java.io.*;
import java.util.StringTokenizer;

public class b11047 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    final int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    final int[] coins = new int[N];

    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int count = 0;

    for (int i = N - 1; i >= 0; i--) {
      if(coins[i] <= K) {
        final int a = K / coins[i];
        count += a;
        K = K % coins[i];
      }

      if(K == 0) {
        System.out.println(count);
        break;
      }
    }
  }
}
