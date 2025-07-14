package 이지윤;

import java.io.*;
import java.util.StringTokenizer;

public class b11659 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 합배열 2 - 4 = sumArr[4] - sumArr[2-1]
        int[] sumArr = new int[arr.length + 1];
        sumArr[0] = 0;
        for(int i = 1; i <= arr.length; i++) {
            sumArr[i] = sumArr[i-1] + arr[i-1];
        }

        for(int i = 0; i < M; i++) {
            String[] sRanges = br.readLine().split(" ");
            int start = Integer.parseInt(sRanges[0]);
            int end = Integer.parseInt(sRanges[1]);

            int result = sumArr[end] - sumArr[start - 1];

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
