package 강민혁;

import java.io.*;
import java.util.Arrays;

public class b1929 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    final int N = numbers[0];
    final int M = numbers[1];

    for (int i = N; i <= M; i++) {
      if(isPrimeNumber(i)) {
        System.out.println(i);
      }
    }
  }

  private static boolean isPrimeNumber(final int target) {
    if (target < 2) return false;
    if (target == 2) return true;
    if (target % 2 == 0) return false;

    for (int i = 3; i * i <= target; i += 2) {
      if (target % i == 0) {
        return false;
      }
    }
    return true;
  }
}
