package 강민혁;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class b2750 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // ex1(br, bw);
    ex2(br);
  }

  private static void ex2(final BufferedReader br) throws IOException {
    IntStream.range(0, Integer.parseInt(br.readLine()))
        .map(i -> {
          try { return Integer.parseInt(br.readLine()); }
          catch (IOException e) { throw new RuntimeException(e); }
        })
        .sorted()
        .forEach(System.out::println);
  }

  private static void ex1(final BufferedReader br, final BufferedWriter bw)
      throws IOException {
    final int N = Integer.parseInt(br.readLine());
    final int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      bw.write(arr[i] + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
