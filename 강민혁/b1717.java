package 강민혁;

import java.io.*;
import java.util.StringTokenizer;

public class b1717 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            final StringTokenizer st2 = new StringTokenizer(br.readLine());
            final int operation = Integer.parseInt(st2.nextToken());
            final int a = Integer.parseInt(st2.nextToken());
            final int b = Integer.parseInt(st2.nextToken());

            if (operation == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        final int rootX = find(x);
        final int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}