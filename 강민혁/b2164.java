package 강민혁;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b2164 {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    final int N = Integer.parseInt(br.readLine());

    final Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }

    if (queue.size() == 1) {
      bw.write("1");
    }

    while(queue.size() > 1) {
      queue.remove();
      final Integer poll = queue.poll();
      queue.add(poll);
      if (queue.size() == 1) {
        bw.write(poll.toString());
      }
    }

    bw.flush();
    bw.close();
  }
}