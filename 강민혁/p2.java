package 강민혁;

public class p2 {
  public int solution(int[][] sizes) {
    int maxLong = 0;
    int maxShort = 0;

    for(int i = 0; i < sizes.length; i++){
      int longer = Math.max(sizes[i][0], sizes[i][1]);
      int shorter = Math.min(sizes[i][0], sizes[i][1]);
      maxLong = Math.max(maxLong, longer);
      maxShort = Math.max(maxShort, shorter);
    }

    return maxLong * maxShort;
  }
}
