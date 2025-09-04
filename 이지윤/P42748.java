package 이지윤;

import java.util.*;

public class P42748 {
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int x = 0; x < commands.length; x++) {
                int i = commands[x][0];
                int j = commands[x][1];
                int k = commands[x][2];

                int[] sub = Arrays.copyOfRange(array, i - 1, j);
                Arrays.sort(sub);
                answer[x] = sub[k - 1];
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution.solution(array, commands)));
    }
}
