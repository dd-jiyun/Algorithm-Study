package 강민혁;

import java.io.*;
import java.util.*;

public class b1325 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer st2 = new StringTokenizer(br.readLine());
            final int A = Integer.parseInt(st2.nextToken());
            final int B = Integer.parseInt(st2.nextToken());
            graph[B].add(A);
        }

        int maxCount = 0;
        final List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            final int count = dfs(i);

            if (count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(i);
            } else if (count == maxCount) {
                result.add(i);
            }
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)));
            if (i < result.size() - 1) {
                bw.write(" ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
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
}