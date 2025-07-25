package 강민혁;

import java.io.*;
import java.util.Arrays;

public class b1377 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // n 입력 받기
    final int N = Integer.parseInt(br.readLine());

    // 정의된 Element 클래스에 값 넣기
    Element[] elements = new Element[N];
    for (int i = 0; i < N; i++) {
      final int num = Integer.parseInt(br.readLine());
      elements[i] = new Element(num, i);
    }

    // 배열을 num으로 정렬
    Arrays.sort(elements);

    // 최대 이동값 저장
    int max = 0;
    // 숫자의 인덱스가 얼마나 움직였는지 계산
    for (int i = 0; i < N; i++) {
      max = Math.max(max, elements[i].idx - i);
    }

    System.out.println(max + 1);
  }
}

// new Element(1,0)
class Element implements Comparable<Element> {

  int num;
  int idx;

  Element(int num, int idx) {
    this.num = num;
    this.idx = idx;
  }

  @Override
  public int compareTo(Element o) {
    return num - o.num;
  }
}
