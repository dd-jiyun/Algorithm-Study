package 이지윤;

public class P43165 {
    static class Solution {
        int answer = 0;

        public int solution(int[] numbers, int target) {
            dfs(numbers, target, 0, 0);
            return answer;
        }

        private void dfs(int[] numbers, int target, int idx, int sum) {
            if (idx == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                return;
            }

            dfs(numbers, target, idx + 1, sum + numbers[idx]);
            dfs(numbers, target, idx + 1, sum - numbers[idx]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.solution(numbers, target));
    }
}
