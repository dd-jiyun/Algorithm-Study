package 박채연;

import java.util.*;
import java.io.*;

public class p1377 {
    public static void main(String[] args) throws IOException {
        // 배열 크기 counts에 입력 받고 배열 크기만큼 값을 받아 numbers 배열에 저장하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int counts = Integer.parseInt(br.readLine());
        int[] numbers = new int[counts];
        for (int i = 0; i < counts; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 버블 정렬에서 result번 swap 흐름? 지난 후에 정렬되는지
        boolean changed = false;
        int temp = 0;
        for (int i = 1; i < counts + 1; i++) {
            changed = false;
            for (int j = 1; j < counts - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    changed = true;
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
            if (!changed) {
                System.out.print(i);
            }
        }

    }
}
