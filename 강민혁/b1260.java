package 강민혁;

import java.io.*;
import java.util.*;

public class b1260 {

  static boolean[] visited;
  static int N, M, V;
  static TreeSet<Integer>[] graph;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    // 배열 초기화 먼저!
    graph = new TreeSet[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new TreeSet<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      final int a = Integer.parseInt(st.nextToken());
      final int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    visited = new boolean[N+1];
    dfs(V);
    sb.append("\n");

    visited = new boolean[N+1];
    bfs(V);

    System.out.println(sb);
  }

  private static void dfs(final int v) {
    if(visited[v]) {
      return;
    }

    visited[v] = true;
    sb.append(v).append(" ");

    for (int neighbor : graph[v]) {
      if (!visited[neighbor]) {
        dfs(neighbor);
      }
    }
  }

  private static void bfs(final int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      final Integer current = queue.poll();
      sb.append(current).append(" ");

      for (int neighbor: graph[current]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }
  }
}