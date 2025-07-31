package 강민혁;

import java.io.*;
import java.util.Arrays;

public class b1541 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final String[] parts = br.readLine().split("-");

    int sum = 0;

    for (int i = 0; i < parts.length; i++) {
      final int num = Arrays.stream(parts[i].split("\\+")).mapToInt(Integer::parseInt).sum();
      sum += (i == 0) ? num : -num;
    }

    System.out.println(sum);
  }
}
