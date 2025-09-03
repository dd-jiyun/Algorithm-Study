package 이지윤;

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    static class Solution {
        public String solution(String[] participant, String[] completion) {

            Map<String, Integer> map = new HashMap<>();

            for (String p : participant) {
                map.put(p, map.getOrDefault(p, 0) + 1);
            }
            for (String c : completion) {
                map.put(c, map.get(c) - 1);
            }
            for (String key : map.keySet()) {
                if (0 < map.get(key)) {
                    return key;
                }
            }

            return "";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution.solution(participant, completion)); // vinko

        String[] participant2 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion2 = {"stanko", "ana", "mislav"};
        System.out.println(solution.solution(participant2, completion2)); // mislav
    }
}
