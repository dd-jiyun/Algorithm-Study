package 강민혁;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b11724 {

  static boolean[] visited;
  static int N;
  static int M;
  static ArrayList<Integer>[] A;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    A = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      final int u = Integer.parseInt(st.nextToken());
      final int v = Integer.parseInt(st.nextToken());
      A[u].add(v);
      A[v].add(u);
    }

    int count = 0;

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }

    System.out.println(count);
  }

  private static void dfs(final int v) {
    if (visited[v]) {
      return;
    }

    visited[v] = true;

    for(int i : A[v]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
