package 이지윤;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b11003 {
    static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> d = new LinkedList<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());

            while (!d.isEmpty() && current < d.getLast().value) {
                d.removeLast();
            }
            d.addLast(new Node(i, current));

            if (d.getFirst().index <= i - l) {
                d.removeFirst();
            }

            bw.write(d.getFirst().value + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Node {
        int index;
        int value;

        Node(final int index, final int value) {
            this.index = index;
            this.value = value;
        }
    }
}
