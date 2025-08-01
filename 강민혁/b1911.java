package 강민혁;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class PuddleComparator implements Comparator<int[]> {

  @Override
  public int compare(int[] o1, int[] o2) {
    if (o1[0] == o2[0]) {
      return Integer.compare(o1[1], o2[1]);
    }
    return Integer.compare(o1[0], o2[0]);
  }
}

public class b1911 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    final int N = Integer.parseInt(st.nextToken());
    final int L = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, new PuddleComparator());

    int board = 0;
    int range = 0;
    for (int i = 0; i < N; i++) {
      if (arr[i][0] > range) {
        range = arr[i][0];
      }

      if (arr[i][1] >= range) {
        while (arr[i][1] > range) {
          range += L;
          board++;
        }
      }
    }

    System.out.println(board);
  }
}
