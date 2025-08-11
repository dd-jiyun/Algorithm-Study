package 강민혁;

import java.util.*;

class p1 {
  public int solution(int n, int[][] wires) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] wire : wires) {
      graph.get(wire[0]).add(wire[1]);
      graph.get(wire[1]).add(wire[0]);
    }

    int minDiff = n;

    for (int[] wire : wires) {
      int v1 = wire[0];
      int v2 = wire[1];

      graph.get(v1).remove(Integer.valueOf(v2));
      graph.get(v2).remove(Integer.valueOf(v1));

      boolean[] visited = new boolean[n + 1];
      int componentSize = dfs(graph, v1, visited);

      int otherComponentSize = n - componentSize;
      int diff = Math.abs(componentSize - otherComponentSize);
      minDiff = Math.min(minDiff, diff);

      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }

    return minDiff;
  }

  private int dfs(List<List<Integer>> graph, int node, boolean[] visited) {
    visited[node] = true;
    int size = 1;

    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) {
        size += dfs(graph, neighbor, visited);
      }
    }

    return size;
  }
}