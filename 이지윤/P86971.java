package 이지윤;

import java.util.*;

public class P86971 {
    static List<Integer>[] graph;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int minDiff = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));

            visited = new boolean[n + 1];
            int count = dfs(a);

            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);

            graph[a].add(b);
            graph[b].add(a);
        }

        return minDiff;
    }

    static int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        P86971 p86971 = new P86971();

        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        System.out.println(p86971.solution(n, wires));
    }
}
