import java.io.*;
import java.util.*;

public class n1717 {
    private static int[] p;
    private static int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) p[b] = a;
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];

        for (int i = 0; i <= n; i++) p[i] = i;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (c == 0) union(a, b);
            else sb.append(find(a) == find(b) ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
        br.close();
    }
}
