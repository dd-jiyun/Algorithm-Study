package 강민혁;

import java.util.HashSet;
import java.util.Set;

public class p2 {
  public String solution(String[] participant, String[] completion) {
    Set<String> runners = new HashSet<>();

    for (String runner: participant) {
      if (!runners.contains(runner)) {
        runners.add(runner);
      } else {
        runners.remove(runner);
      }
    }

    for (String runner: completion) {
      if (runners.contains(runner)) {
        runners.remove(runner);
      } else {
        runners.add(runner);
      }
    }

    for (String ans: runners) {
      return ans;
    }
    return null;
  }
}
