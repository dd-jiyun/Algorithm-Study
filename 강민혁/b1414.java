package 강민혁;

import java.io.*;
import java.util.*;

public class b1414 {

    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        final List<Edge> edges = new ArrayList<>();
        int totalLength = 0;

        for (int i = 0; i < N; i++) {
            final String line = br.readLine();
            for (int j = 0; j < N; j++) {
                final char c = line.charAt(j);
                if (c != '0') {
                    final int weight = getWeight(c);
                    totalLength += weight;
                    if (i != j) {
                        edges.add(new Edge(i, j, weight));
                    }
                }
            }
        }

        Collections.sort(edges);

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int mstWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                mstWeight += edge.weight;
                edgeCount++;
                if (edgeCount == N - 1) {
                    break;
                }
            }
        }

        if (edgeCount == N - 1) {
            bw.write(String.valueOf(totalLength - mstWeight));
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int getWeight(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int x, int y) {
        final int rootX = find(x);
        final int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}