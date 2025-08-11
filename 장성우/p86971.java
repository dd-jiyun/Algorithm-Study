import java.util.*;

public class p86971 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int n;

    public int solution(int n, int[][] wires) {
        this.n = n;
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

        int answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            visited = new boolean[n + 1];
            int count = dfsCount(a, a, b);
            int otherCount = n - count;

            answer = Math.min(answer, Math.abs(count - otherCount));
        }

        return answer;
    }

    static int dfsCount(int current, int blockedA, int blockedB) {
        visited[current] = true;
        int count = 1;

        for (int next : graph[current]) {
            if ((current == blockedA && next == blockedB) || (current == blockedB && next == blockedA)) continue;
            if (!visited[next]) {
                count += dfsCount(next, blockedA, blockedB);
            }
        }
        return count;
    }
}
