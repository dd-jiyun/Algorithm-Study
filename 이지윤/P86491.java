package 이지윤;

public class P86491 {
    static class Solution {
        public int solution(int[][] sizes) {
            int maxWidth = 0;
            int maxHeight = 0;

            for (int[] size : sizes) {
                int w = Math.max(size[0], size[1]);
                int h = Math.min(size[0], size[1]);

                if (w > maxWidth) {
                    maxWidth = w;
                }
                if (h > maxHeight) {
                    maxHeight = h;
                }
            }

            return maxWidth * maxHeight;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(sol.solution(sizes));
    }
}
