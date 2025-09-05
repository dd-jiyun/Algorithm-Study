package 이지윤;

import java.util.*;

public class P42747 {
    static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int h = 0;

            for (int i = 0; i < n; i++) {
                int candidate = n - i;
                if (candidate <= citations[i]) {
                    h = candidate;
                    break;
                }
            }
            return h;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution.solution(citations));
    }
}
