import java.io.*;
import java.util.*;

public class n1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] fact = new long[21];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) fact[i] = fact[i - 1] * i;

        st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());

        if (type == 1) {
            long k = Long.parseLong(st.nextToken());
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= N; i++) nums.add(i);

            StringBuilder sb = new StringBuilder();
            k--;

            for (int i = N; i >= 1; i--) {
                long block = fact[i - 1];
                int idx = (int)(k / block);
                sb.append(nums.get(idx)).append(" ");
                nums.remove(idx);
                k %= block;
            }
            System.out.println(sb.toString().trim());

        } else {
            int[] perm = new int[N];
            for (int i = 0; i < N; i++) {
                perm[i] = Integer.parseInt(st.nextToken());
            }

            long order = 1;
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= N; i++) nums.add(i);

            for (int i = 0; i < N; i++) {
                int val = perm[i];
                int idx = nums.indexOf(val);
                order += (long)idx * fact[N - 1 - i];
                nums.remove(idx);
            }
            System.out.println(order);
        }
        br.close();
    }
}
