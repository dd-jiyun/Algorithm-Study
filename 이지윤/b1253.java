package 이지윤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1253 {
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        for (int k = 0; k < n; k++) {
            int target = a[k];
            int i = 0;
            int j = n - 1;

            while (i < j) {
                if (a[i] + a[j] == target) {
                    if (i != k && j != k) {
                        count++;
                        break;
                    }
                    if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (a[i] + a[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
