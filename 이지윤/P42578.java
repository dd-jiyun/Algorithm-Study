package 이지윤;

import java.util.HashMap;
import java.util.Map;

public class P42578 {
    static class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> map = new HashMap<>();
            for (String[] cloth : clothes) {
                String type = cloth[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (int count : map.values()) {
                answer *= (count + 1);
            }

            return answer - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution.solution(clothes)); // 5
        System.out.println(solution.solution(clothes2)); // 3
    }
}
