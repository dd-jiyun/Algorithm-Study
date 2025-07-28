package 강민혁;

import java.io.*;
import java.util.Arrays;

public class b1920 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final int N = Integer.parseInt(br.readLine());
    final int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(A);

    final int M = Integer.parseInt(br.readLine());
    final int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
        .toArray();

    for (int i = 0; i < M; i++) {
      System.out.println(bs(A, numbers[i]));
    }
  }

  private static int bs(final int[] A, final int target) {
    int left = 0; // 0
    int right = A.length - 1; // 4

    while (left <= right) {
      int mid = (left + right) / 2; // 2

      if (A[mid] == target) {
        return 1;
      } else if (A[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return 0;
  }
}
