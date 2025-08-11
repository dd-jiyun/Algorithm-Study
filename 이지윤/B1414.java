package 이지윤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class B1414 {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        parent[pb] = pa;
        return true;
    }

    static int convert(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 27;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> edges = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                int w = convert(line.charAt(j));
                total += w;
                if (i != j && w > 0) {
                    edges.add(new int[]{w, i, j});
                }
            }
        }

        edges.sort(Comparator.comparingInt(o -> o[0]));

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cost = 0, count = 0;
        for (int[] e : edges) {
            if (union(e[1], e[2])) {
                cost += e[0];
                count++;
            }
        }

        if (count == N - 1) {
            System.out.println(total - cost);
        } else {
            System.out.println(-1);
        }
    }
}
