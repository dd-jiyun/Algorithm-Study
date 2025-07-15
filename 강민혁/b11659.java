package 강민혁;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class b11659 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        final int N = inputs[0];
        final int M = inputs[1];

        final int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();

        final int[] sumArr = new int[N + 1];
        sumArr[0] = 0;
        for (int i = 1; i <= N; i++) {
            sumArr[i] = numbers[i - 1] + sumArr[i - 1];
        }

        for (int i = 0; i < M; i++) {
            final int[] idxes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            final int startIdx = idxes[0];
            final int endIdx = idxes[1];

            final int result = sumArr[endIdx] - sumArr[startIdx - 1];
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
