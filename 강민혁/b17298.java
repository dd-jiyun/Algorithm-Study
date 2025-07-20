package 강민혁;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class b17298 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    final int N = Integer.parseInt(br.readLine()); // 4
    final int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 3 5 2 7

    Stack<Integer> stack = new Stack<>();

    int[] result = new int[N];
    Arrays.fill(result, -1);

    for (int currentIndex = 0; currentIndex < N; currentIndex++) {
      int currentValue = A[currentIndex]; // A[0] ~ A[3]

      while (!stack.isEmpty()) {
        int topIndex = stack.peek();
        int topValue = A[topIndex];

        if (topValue < currentValue) {
          stack.pop();
          result[topIndex] = currentValue;
        } else {
          break;
        }
      }

      stack.push(currentIndex); // 첫번째 push -> 3
    }

    for (int i = 0; i < N; i++) {
      bw.write(result[i] + "");
      if (i < N - 1) {
        bw.write(" ");
      }
    }
    bw.newLine();

    br.close();
    bw.close();
  }
}
