package 강민혁;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b18352 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
    }

    int[] distance = new int[n + 1];
    Arrays.fill(distance, -1);
    distance[x] = 0;

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(x);

    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int next : graph.get(current)) {
        if (distance[next] == -1) {
          distance[next] = distance[current] + 1;
          queue.offer(next);
        }
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (distance[i] == k) {
        result.add(i);
      }
    }

    if (result.isEmpty()) {
      System.out.println(-1);
    } else {
      Collections.sort(result);
      for (int city : result) {
        System.out.println(city);
      }
    }
  }
}
