package 강민혁;

import java.io.*;
import java.util.Arrays;

public class b1253 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    final int N = Integer.parseInt(br.readLine());
    final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    Arrays.sort(arr);

    int count = 0;

    for (int i = 0; i < N; i++) {
      int target = arr[i];
      int left = 0;
      int right = N - 1;

      while (left < right) {
        if (left == i) {
          left++;
          continue;
        }
        if (right == i) {
          right--;
          continue;
        }

        int sum = arr[left] + arr[right];

        if (sum == target) {
          count++;
          break;
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }

    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }
}
