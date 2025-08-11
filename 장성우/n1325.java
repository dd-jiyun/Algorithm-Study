import java.io.*;
import java.util.*;

public class n1325 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g[B].add(A);
        }

        int[] counts = new int[N + 1];
        int max = 0;

        for (int start = 1; start <= N; start++) {
            int count = bfs(start, N, g);
            counts[start] = count;
            if (count > max) {
                max = count;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static int bfs(int start, int N, ArrayList<Integer>[] g) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(start);
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                    count++;
                }
            }
        }
        return count;
    }
}