package 강민혁;

import java.io.*;
import java.util.*;

public class b11399 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final int N = Integer.parseInt(br.readLine());
    final int[] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray(); // 1 2 3 3 4

    int result = 0;
    int sum = 0;

    for (int i : P) {
      sum += i;
      result += sum;
    }

    System.out.println(result);
  }
}
