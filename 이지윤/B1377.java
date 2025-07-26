package 이지윤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Element[] arr = new Element[n];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = new Element(val, i);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int move = arr[i].index - i;
            if (move > max) {
                max = move;
            }
        }

        System.out.println(max + 1);
    }

    private static class Element implements Comparable<Element> {
        private final int value;
        private final int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }
}
