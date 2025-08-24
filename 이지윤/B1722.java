package 이지윤;

import java.io.*;
import java.util.*;

public class B1722 {
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());

        if (type == 1) {
            long k = Long.parseLong(st.nextToken());
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                nums.add(i);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = n; 1 <= i; i--) {
                int idx = (int) ((k - 1) / factorial[i - 1]);
                sb.append(nums.get(idx)).append(" ");
                nums.remove(idx);
                k = (k - 1) % factorial[i - 1] + 1;
            }
            System.out.println(sb);
            br.close();
            return;
        }

        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        long order = 1;
        for (int i = 0; i < n; i++) {
            int pos = nums.indexOf(permutation[i]);
            order += (long) pos * factorial[n - 1 - i];
            nums.remove(pos);
        }
        System.out.println(order);
        br.close();
    }
}
